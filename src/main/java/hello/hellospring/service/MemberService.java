package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRespository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRespository memberRespository = new MemoryMemberRepository();

    public Long join(Member member){


        validateduplicateMember(member);// 중복회원 검증
        memberRespository.save(member);

        return member.getId();


    }

    private void validateduplicateMember(Member member) {
        memberRespository.findByName(member.getName())
                .ifPresent( member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    
    public List<Member> findMembers {

    }
}


