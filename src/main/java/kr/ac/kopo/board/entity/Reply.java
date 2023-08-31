package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    private String text;
    private String replyer;

    @ManyToOne // foreign key
    private Board board; // 실제 reply 테이블에는 board_bno 열이 생성되고 Fk(Board 테이블의 bno 열값만 참조)
}
