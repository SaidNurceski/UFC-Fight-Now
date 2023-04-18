package org.example.entity;

public class Fighter {
    private Division division;
    private String name;
    private  Long id;
    private  int age;

    public Fighter( int age,Division division, String name) {
        this.division = division;
        this.name = name;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
