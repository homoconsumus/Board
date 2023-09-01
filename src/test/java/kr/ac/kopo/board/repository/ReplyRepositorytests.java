package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;
import kr.ac.kopo.board.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositorytests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1, 300).forEach(i ->{
            // 1~100 사이의 임의의 값을 사용하자(BoardRepositoryTests에서 생성한 bno들)
            long bno = new Random().nextInt(200) + 101;

            Board board = Board.builder()
                    .bno(bno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply......" + i)
                    .replyer("guest" + i)
                    .board(board)
                    .build();

            replyRepository.save(reply);
        });
    }
}
