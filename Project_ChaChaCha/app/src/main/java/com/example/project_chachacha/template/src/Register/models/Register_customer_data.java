package com.example.project_chachacha.template.src.Register.models;

public class Register_customer_data {
    String userid;
    String userpw;
    String userpw2;
    String name;
    int age;
    int gender;
    String email;

    public Register_customer_data(String userid, String userpw, String userpw2, String name, int age, int gender, String email) {
        this.userid = userid;
        this.userpw = userpw;
        this.userpw2 = userpw2;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
}
