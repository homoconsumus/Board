package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 100).forEach(i ->{
            Member member = Member.builder()
                    .email("user" + i +"@kopo.ac.kr")
                    .build();

            Board board = Board.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer(member) // FK가 설정된 컬럼에 값을 삽입할 때는 반드시 참조하는 Member의 객체 참조값으로 사용(+ 실제 존재하는 객체만 이용 가능)
                    .build();

            boardRepository.save(board);
        });
    }
}
