package com.sf.hash.test.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDemo implements Serializable {
    private Long id;
    
    @JsonProperty("taskType")
    @XmlElement(name = "taskType")
    @NotNull
    @Size(min = 1, max = 50)
    private String taskType;

    @JsonProperty("bizCatgId")
    @XmlElement(name = "bizCatgId")
    private Integer bizCatgId;

    private Date startTm;

    private Date endTm;

    private Date limitTm;
    
    @JsonProperty("startNode")
    @XmlElement(name = "startNode")
    @NotNull
    @Size(min = 1, max = 50)
    private String startNode;
    
    @JsonProperty("endNode")
    @XmlElement(name = "endNode")
    @NotNull
    @Size(min = 1, max = 50)
    private String endNode;
    
    @JsonProperty("bizEntity")
    @XmlElement(name = "bizEntity")
    @NotNull
    @Size(min = 1, max = 50)
    private String bizEntity;
    
    @JsonProperty("status")
    @XmlElement(name = "status")
    @NotNull
    @Size(min = 1, max = 10)
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