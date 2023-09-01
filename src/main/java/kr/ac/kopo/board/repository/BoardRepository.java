package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> { // jpaRepository는 sql실행을 위한 것

    // lazy(지연) 방식에서는 join이 필요할 때 jpql을 사용해서 join을 명시해줘야함
    @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    // 목록화면에 사용할 데이터들을 얻기 위한 jpql
    @Query("select b, r from Board b left join Reply r ON r.board = b where b.bno=:bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    // 목록 화면에 사용될 데이터 행들과 댓글의 개수, JPQL사용
    @Query(value = "select b, w, count(r) from Board b left join b.writer w left join Reply r ON r.board = b group by b", // left join b.writer 는 email을 의미
            countQuery = "select count(b) from Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);
}
