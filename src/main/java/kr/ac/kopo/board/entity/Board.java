package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer") //writer 이외 정보들의 문자열
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 방식 설정(즉각 로딩 방식이 기본이지만 모든 관계에 대해 join하기 때문에 데이터의 양이 많을수록 속도가 느려져서 지연 로딩 방식을 사용한다)
    private Member writer; // foreign key
}
