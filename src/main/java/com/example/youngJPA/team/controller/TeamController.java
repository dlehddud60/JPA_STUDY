package com.example.youngJPA.team.controller;

import com.example.youngJPA.team.model.FindResponseTeamListModel;
import com.example.youngJPA.team.model.FindResponseTeamModel;
import com.example.youngJPA.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    //d
    private final TeamService teamService;

    @GetMapping("/save")
    public void save() {
        teamService.save();
    }

    @GetMapping("/find/{teamId}")
    public FindResponseTeamModel find(@PathVariable(name = "teamId") Long teamId) {
        return teamService.findByTeamId(teamId);
    }

    @GetMapping
    public List<FindResponseTeamListModel> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/delete/{teamId}")
    public void delete(@PathVariable(name = "teamId") Long teamId) {
        teamService.delete(teamId);
    }
}
