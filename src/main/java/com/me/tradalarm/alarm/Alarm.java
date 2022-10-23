package com.me.tradalarm.alarm;

import com.me.tradalarm.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_alarm")

public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "_symbole1")
    private String symbole1;

    @Column(name = "_symbole2")
    private String symbole2;

    @Column(name="_valeur")
    private BigDecimal valeur;

    @Column(name = "_inferieur")
    private boolean inferieur;

    @Column(name = "_on")
    private boolean on=false;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="_owner", referencedColumnName = "id")
    private User owner;

}
