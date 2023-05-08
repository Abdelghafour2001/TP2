package com.example.tp2.models;

import java.io.Serializable;
import java.util.Objects;

public class LigneformationformateurPK implements Serializable {
    private int formation;
    private String formateur;

    public int getFormation() {
        return formation;
    }

    public void setFormation(int formation) {
        this.formation = formation;
    }

    public String getFormateur() {
        return formateur;
    }

    public void setFormateur(String formateur) {
        this.formateur = formateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneformationformateurPK that = (LigneformationformateurPK) o;
        return formation == that.formation && Objects.equals(formateur, that.formateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formation, formateur);
    }
}
