package org.choongang.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class CreateTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    void createTest1() {

        BoardData boardData = new BoardData();
        boardData.setSeq(1L);
        boardData.setEmail("user02@test.org");
        boardData.setPassword("12345678");
        boardData.setTitle("게시글 테스트");
        boardData.setContent("게시글 내용");
        boardData.setCreatedAt(LocalDateTime.now());

        em.flush(); // INSERT 쿼리 DB에 반영

    }

}
