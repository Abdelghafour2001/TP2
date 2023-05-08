package com.example.tp2.models;

import java.util.Objects;

public class Lieu {
    private int id;
    private String adresse;
    private String ville;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lieu lieu = (Lieu) o;
        return id == lieu.id && Objects.equals(adresse, lieu.adresse) && Objects.equals(ville, lieu.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adresse, ville);
    }
}
