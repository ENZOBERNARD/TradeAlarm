package com.me.tradalarm.user;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "_user")
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "_pseudo")
    private String pseudo;



    public User(long id, String pseudo) {
        super();
        this.id = id;
        this.pseudo = pseudo;
    }

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
