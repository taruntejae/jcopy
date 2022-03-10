package com.jcopy.jcopy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "JUSER")
public class User {
    @Id
    @Column(name = "ID_USER")
    private int id;

    @Column
    private String username;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> assignedTaskList;

    @OneToMany(mappedBy = "createdByUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> createdTaskList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", assignedTaskList=" + assignedTaskList +
                ", createdTaskList=" + createdTaskList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Task> getAssignedTaskList() {
        return assignedTaskList;
    }

    public void setAssignedTaskList(List<Task> assignedTaskList) {
        this.assignedTaskList = assignedTaskList;
    }

    public List<Task> getCreatedTaskList() {
        return createdTaskList;
    }

    public void setCreatedTaskList(List<Task> createdTaskList) {
        this.createdTaskList = createdTaskList;
    }
}
