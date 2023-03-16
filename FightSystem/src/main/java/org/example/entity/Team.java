package org.example.entity;

import java.util.Set;

public class Team {
    private Long id;
    private String name;
    private Set<Fighter> fighters;


    public Team(Long id, String name, Set<Fighter> fighters) {
        this.id = id;
        this.name = name;
        this.fighters = fighters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getFighters() {
        return fighters;
    }

    public void setFighters(Set<Fighter> fighters) {
        this.fighters = fighters;
    }
}
