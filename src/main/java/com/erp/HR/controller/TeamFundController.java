package com.erp.HR.controller;

import com.erp.HR.domain.Projects;
import com.erp.HR.service.TeamFundManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/HR/teamFund")
public class TeamFundController {

    @Autowired
    TeamFundManagementService teamFundManagementService;

    @GetMapping("/partyFund")
    public List<Projects> getAvailablePartyFund(@RequestParam(value = "projectId") int projectId,
                                                @RequestParam(value = "managerId") String managerId,
                                                @RequestParam(value = "teamBuildingActFlag") char teamBuildingActivityFlag){
        return teamFundManagementService.getByProjectIdAndManagerIdAndTeamBuildingActivity(projectId,
                managerId, teamBuildingActivityFlag);

    }
}
