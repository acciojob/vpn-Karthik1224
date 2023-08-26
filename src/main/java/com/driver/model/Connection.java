package com.driver.model;


import javax.persistence.*;

@Entity
@Table
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer connectionId;

    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JoinColumn
    private User user;

}
