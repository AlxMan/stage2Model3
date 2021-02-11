package com.example.stage2Model3.entity;

public class Login {
    private int id;
    private String name;
    private String passWord;

    public Login() {
    }

    public Login(String name, String pwd) {
        this.name = name;
        this.passWord = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Login(int id, String name, String passWord) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
