package com.sf.hash.test.dao.domain.task;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private Long id;

    private String taskType;

    private Integer bizCatgId;

    private Date startTm;

    private Date endTm;

    private Date limitTm;

    private String startNode;

    private String endNode;

    private String bizEntity;

    private String status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public Integer getBizCatgId() {
        return bizCatgId;
    }

    public void setBizCatgId(Integer bizCatgId) {
        this.bizCatgId = bizCatgId;
    }

    public Date getStartTm() {
        return startTm;
    }

    public void setStartTm(Date startTm) {
        this.startTm = startTm;
    }

    public Date getEndTm() {
        return endTm;
    }

    public void setEndTm(Date endTm) {
        this.endTm = endTm;
    }

    public Date getLimitTm() {
        return limitTm;
    }

    public void setLimitTm(Date limitTm) {
        this.limitTm = limitTm;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode == null ? null : startNode.trim();
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode == null ? null : endNode.trim();
    }

    public String getBizEntity() {
        return bizEntity;
    }

    public void setBizEntity(String bizEntity) {
        this.bizEntity = bizEntity == null ? null : bizEntity.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskType=").append(taskType);
        sb.append(", bizCatgId=").append(bizCatgId);
        sb.append(", startTm=").append(startTm);
        sb.append(", endTm=").append(endTm);
        sb.append(", limitTm=").append(limitTm);
        sb.append(", startNode=").append(startNode);
        sb.append(", endNode=").append(endNode);
        sb.append(", bizEntity=").append(bizEntity);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}