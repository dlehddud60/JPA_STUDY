package com.example.youngJPA.member.entity;

//import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.team.domain.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SequenceGenerator(
        name = "MEMBER_ID_GEN",
        sequenceName = "MEMBER_ID",
        allocationSize = 1
)
public class Member {

    //    JPA 테이블 컬럼 생성
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MEMBER_ID_GEN")
    @Column(name = "MEMBER_ID", length = 20, unique = true)
    private Long memberId;

    @Column(name = "ID",length = 200,nullable = false)
    private String id;

    @Column(name = "PW",length = 200,nullable = false)
    private String pw;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


}
