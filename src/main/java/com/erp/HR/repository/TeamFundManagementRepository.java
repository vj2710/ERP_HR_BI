package com.erp.HR.repository;

import com.erp.HR.domain.Projects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamFundManagementRepository extends CrudRepository<Projects, Integer> {

    List<Projects> getByProjectIdAndManagerIdAndTeamBuildingActivity(int projectId, String managerId, char teamBuildingActivityFlag);
}
