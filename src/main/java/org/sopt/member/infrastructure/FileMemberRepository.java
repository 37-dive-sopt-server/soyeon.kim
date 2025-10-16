package org.sopt.member.infrastructure;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.sopt.member.domain.model.Gender;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;

public class FileMemberRepository implements MemberRepositoryPort {

    private final Map<Long, Member> store = new ConcurrentHashMap<>();
    private final Set<String> emails = new LinkedHashSet<>();
    private final AtomicLong sequence = new AtomicLong(1);
    private final String filePath;

    public FileMemberRepository(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            member.updateId(sequence.getAndIncrement());
            member.updateCreatedAt(Instant.now());
        }
        member.updateUpdatedAt(Instant.now());
        store.put(member.getId(), member);
        emails.add(member.getEmail());
        logToFile("SAVE," + memberToCsv(member));
        return member;
    }

    @Override
    public void deleteById(Long id) {
        if (store.remove(id) == null) {
            throw new NoSuchElementException("ID " + id + "에 해당하는 회원이 없습니다.");
        }
        logToFile("DELETE," + id);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean existsByEmail(String email) {
        return emails.contains(email);
    }

    private void loadFromFile() {
        try {
            File dbFile = new File(filePath);
            if (!dbFile.exists()) {
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(dbFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",", 2);
                    String operation = parts[0];
                    String[] data = parts[1].split(",");

                    if ("SAVE".equals(operation)) {
                        Member member = csvToMember(data);
                        store.put(member.getId(), member);
                    } else if ("DELETE".equals(operation)) {
                        long idToDelete = Long.parseLong(data[0]);
                        store.remove(idToDelete);
                    }
                }
                long maxId = store.keySet().stream().max(Long::compareTo).orElse(0L);
                this.sequence.set(maxId + 1);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("데이터베이스 파일 로드 실패", e);
        }
    }

    private synchronized void logToFile(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(log);
            writer.newLine();
        } catch (IOException e) {
            throw new UncheckedIOException("로그 파일 쓰기 실패", e);
        }
    }

    private String memberToCsv(Member member) {
        return String.join(",",
            member.getId().toString(),
            member.getName(),
            member.getBirthday().toString(),
            member.getEmail(),
            member.getGender().name(),
            member.getCreatedAt().toString(),
            member.getUpdatedAt().toString()
        );
    }

    private Member csvToMember(String[] data) {
        return Member.reconstitute(
            Long.parseLong(data[0]),
            data[1],
            LocalDate.parse(data[2]),
            data[3],
            Gender.from(data[4]),
            Instant.parse(data[5]),
            Instant.parse(data[6])
        );
    }
}