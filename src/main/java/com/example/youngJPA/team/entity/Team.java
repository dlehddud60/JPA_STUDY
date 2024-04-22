package com.example.youngJPA.team.entity;

import com.example.youngJPA.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "TEAM")
@SequenceGenerator(
                        name = "TEAM_ID_GEN",
                        sequenceName = "TEAM_ID",
                        allocationSize = 1
                    )
public class Team {
    @Column(name = "TEAM_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TEAM_ID_GEN")
    private Long teamId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "team")
    private final List<Member> members = new ArrayList<>();
}
