package com.jcopy.jcopy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JTASK")
@Data
public class Task {
    @Id
    @Column(name = "ID_TASK")
    private int idTask;

    @Column
    private String title;

    @Column
    private String description;

    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ASSIGNEE")
    private User assignee;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "ID_CREATEDBY")
//    private User createdByUser;
}
