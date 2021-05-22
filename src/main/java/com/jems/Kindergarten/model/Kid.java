package com.jems.Kindergarten.model;

import javax.persistence.*;

@Entity
public class Kid {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String code;

    @OneToOne(targetEntity = KidDetail.class,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private KidDetail detail;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public KidDetail getDetail() {
        return detail;
    }

    public void setDetail(KidDetail detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
