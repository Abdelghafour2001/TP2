package com.example.tp2.models;

import java.util.Objects;

public class Formation {
    private int id;
    private String theme;
    private Lieu lieu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Object getLieu() {
        return lieu;
    }

    public void setLieu(Object lieu) {
        this.lieu = (Lieu) lieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return id == formation.id && Objects.equals(theme, formation.theme) && Objects.equals(lieu, formation.lieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, lieu);
    }
}
