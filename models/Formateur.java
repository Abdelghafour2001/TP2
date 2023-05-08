package com.example.tp2.models;

import java.util.Objects;

public class Formateur {
    private String cin;
    private String nom;
    private Integer age;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formateur formateur = (Formateur) o;
        return Objects.equals(cin, formateur.cin) && Objects.equals(nom, formateur.nom) && Objects.equals(age, formateur.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin, nom, age);
    }
}
