package com.erp.HR.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Projects")
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String teamId;
    private String managerId;
    private Integer allocatedPartyFund;
    private Character teamBuildingActivity;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int getAllocatedPartyFund() {
        return allocatedPartyFund;
    }

    public void setAllocatedPartyFund(int allocatedPartyFund) {
        this.allocatedPartyFund = allocatedPartyFund;
    }

    public char getTeamBuildingActivity() {
        return teamBuildingActivity;
    }

    public void setTeamBuildingActivityFlag(char teamBuildingActivity) {
        this.teamBuildingActivity = teamBuildingActivity;
    }
}
