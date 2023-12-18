package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    // key, value 쌍으로 map 에 저장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // values() --> 값들을 컬렉션 형태로 가져옴
        // stream() --> 컬렉션을 스트림으로 변환하여 스트림 연산을 수행할 수 있게 만든다.
        // filter() --> stream 클래스에서 제공, 스트림 요소를 순회하면서 특정 조건을 만족하는 요소로 구성된 새로운 스트림 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // <> --> diamond 연산자, 내가 비워 놓으면 컴파일러가 대입된 값을 기반으로 실제 타입을 결정, 가독성, 간결
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
