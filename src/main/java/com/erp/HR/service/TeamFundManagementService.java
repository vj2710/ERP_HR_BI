package com.erp.HR.service;

import com.erp.HR.domain.Projects;
import com.erp.HR.repository.TeamFundManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFundManagementService {

    @Autowired
    TeamFundManagementRepository teamFundManagementRepository;

    public List<Projects> getByProjectIdAndManagerIdAndTeamBuildingActivity(int projectId, String managerId, char teamBuildingActivityFlag){
        return teamFundManagementRepository.getByProjectIdAndManagerIdAndTeamBuildingActivity(projectId, managerId,teamBuildingActivityFlag);
    }

}
