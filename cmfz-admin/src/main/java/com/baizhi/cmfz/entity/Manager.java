package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Manager implements Serializable {
    private String managerId;
    private String managerName;
    private String managerPassword;
    private String managerSalt;
    private Integer managerStatus;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerSalt() {
        return managerSalt;
    }

    public void setManagerSalt(String managerSalt) {
        this.managerSalt = managerSalt;
    }

    public Integer getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(Integer managerStatus) {
        this.managerStatus = managerStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", managerSalt='" + managerSalt + '\'' +
                ", managerStatus=" + managerStatus +
                '}';
    }

    public Manager(String managerId, String managerName, String managerPassword, String managerSalt, Integer managerStatus) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.managerSalt = managerSalt;
        this.managerStatus = managerStatus;
    }

    public Manager() {

    }
}
