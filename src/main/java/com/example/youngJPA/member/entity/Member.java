package com.example.youngJPA.member.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "ID")
    private String id;

    @Column(name = "PW")
    private String pw;
}
