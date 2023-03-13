package org.example.entity;

public class Fighter {
    private Division division;
    private String name;
    private  Long id;
    private  Long age;

    public Fighter(Division division, String name, Long id, Long age) {
        this.division = division;
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
