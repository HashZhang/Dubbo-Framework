package com.sf.hash.test.dao.domain.task;

import java.io.Serializable;
import java.util.Date;

public class TaskUser implements Serializable {
    private Long id;

    private Long userid;

    private Long taskid;

    private String taskStatus;

    private Date taskLinitTm;

    private String userUsername;

    private String userStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public Date getTaskLinitTm() {
        return taskLinitTm;
    }

    public void setTaskLinitTm(Date taskLinitTm) {
        this.taskLinitTm = taskLinitTm;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", taskid=").append(taskid);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", taskLinitTm=").append(taskLinitTm);
        sb.append(", userUsername=").append(userUsername);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}