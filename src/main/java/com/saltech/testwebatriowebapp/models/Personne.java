package com.saltech.testwebatriowebapp.models;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Personne {

    private Integer id;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int calculateAge(LocalDate currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //solution a chaud peut être améliorée
        if (dateNaissance.split(" ").length != 2)
            dateNaissance+=" 00:00:00";


        //convert String to LocalDate
        LocalDate birthDate = LocalDate.parse(dateNaissance, formatter);
        if ((birthDate != null) && (currentDate != null)) {
            this.age = Period.between(birthDate, currentDate).getYears();
            return Period.between(birthDate, currentDate).getYears();
        } else {
            this.age = 0;
            return 0;
        }
    }

}
