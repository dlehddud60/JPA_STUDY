package com.example.youngJPA.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SequenceGenerator(
        name = "MEMBER_ID_GEN",
        sequenceName = "MEMBER_ID",
        initialValue = 1000000,
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

    @Column(name = "ABOUT_ME",length = 3000,updatable = false)
    private String aboutMe;

    @Column(name = "MEMBER_DT",updatable = false,nullable = false)
    private LocalDate memberDt;

    @Column(name = "MEMBER_AUTH",updatable = false)
    @Enumerated(EnumType.STRING)
    private Auth memberAuth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


}
