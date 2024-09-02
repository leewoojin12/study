package hello.hellospring.repository;


import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {


    MemoryMemberRepository respository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        respository.clearStort();
    }


    @Test
    public  void save(){
        Member member = new Member();
        member.setName("sping");


        respository.save(member);
        Member result = respository.findById(member.getId()).get();

        assertThat(member).isEqualTo((result));



    }



    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("sping1");
        respository.save(member1);



        Member member2 = new Member();
        member1.setName("sping2");
        respository.save(member2);

        Member result = respository.findByName("sping2").get();



        assertThat(result).isEqualTo(member1);







    }


}
