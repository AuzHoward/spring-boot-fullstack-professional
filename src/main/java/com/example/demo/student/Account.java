package com.example.demo.student;

public class Account {

    String name;
    int age;

    public static void main(String[] args) {
        Account account = new Account();
        account.setName("Auz");
        account.setAge(27);
        System.out.println(account.getName());
        System.out.println(account.getAge());
        account.printDetails();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printDetails(){
        System.out.println(name + ", " + age);
    }

}
