package com.example.mobin.devchild;

//common regis er shomoy info save er jonno (authentication related)(pg - 1)

public class User {
    public String name,email,age;

    public User(){

    }

    public User(String name, String email, String age){
        this.name=name;
        this.email=email;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}