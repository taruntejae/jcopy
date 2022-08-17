package com.jcopy.jcopy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "JUSER")
@Data
public class User {
    @Id
    @Column(name = "ID_USER")
    private int id;

    @Column
    private String username;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> assignedTaskList;

//    @OneToMany(mappedBy = "createdByUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Task> createdTaskList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", assignedTaskList=" + assignedTaskList +
//                ", createdTaskList=" + createdTaskList +
                '}';
    }
}
