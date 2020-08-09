package com.hackerrank.github.model;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login" )
    private String login;

    @Column(name = "avatar",nullable = false)
    private String avatar;

    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }


    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }


    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
