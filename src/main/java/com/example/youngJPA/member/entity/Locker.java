package com.example.youngJPA.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LOCKER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@SequenceGenerator(
                    name = "LOCKER_ID_GEN",
                    sequenceName = "LOCKER_ID"
                    )
public class Locker {
    @Column(name = "LOCKER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long lockerId;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "locker",fetch = FetchType.LAZY)
    private Member member;
}
