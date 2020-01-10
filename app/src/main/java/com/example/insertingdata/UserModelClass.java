package com.example.insertingdata;

public class UserModelClass {

    String id;
    String name;
    String email;
    String contact;
    String lang;
    String city;
    String country;


    public UserModelClass() {
    }

    public UserModelClass(String id, String name, String email, String contact, String lang, String city, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.lang = lang;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
