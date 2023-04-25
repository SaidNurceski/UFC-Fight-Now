package org.example.entity;

public class Fighter {
    private Division division;
    private String name;
    private  Long id;
    private  int age;
    private String record;

    private int rank;

    public Fighter(String name, int age, Division division, int rank, String record) {
        this.division = division;
        this.name = name;
        this.age = age;
    }

    public Fighter(String name, Division division, int age, String record, int rank) {
        this.division = division;
        this.name = name;
        this.age = age;
        this.record = record;
        this.rank = rank;
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

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
