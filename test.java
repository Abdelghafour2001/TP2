package com.example.tp2;

import com.example.tp2.dao.FormateurDAO;
import com.example.tp2.dao.FormationDAO;
import com.example.tp2.dao.LieuDAO;
import com.example.tp2.dao.LigneformationformateurDAO;
import com.example.tp2.models.Formateur;
import com.example.tp2.models.Formation;
import com.example.tp2.models.Lieu;
import com.example.tp2.models.Ligneformationformateur;

public class test {

    public static void main(String[] args) {
        FormationDAO dao= new FormationDAO();
        LieuDAO daol = new LieuDAO();
        FormateurDAO daof =  new FormateurDAO();
        LigneformationformateurDAO daoligne = new LigneformationformateurDAO();
        Formation formation = new Formation();
        formation.setTheme("Java");
        Lieu lieu = new Lieu();
        lieu.setId(3);
        lieu.setAdresse("123 Rue de la Paix");
        lieu.setVille("Parisssssss");
        daol.save(lieu);
        formation.setLieu(lieu.getId());
        Formateur formateur1 = new Formateur();
        formateur1.setCin("W434322");
        formateur1.setNom("John Doe");
        formateur1.setAge(30);
        Formateur formateur2 = new Formateur();
        formateur2.setCin("W444442");
        formateur2.setNom("Jane Smith");
        formateur2.setAge(35);
        daof.save(formateur1);
        daof.save(formateur2);
        Ligneformationformateur ligne1 = new Ligneformationformateur();
        ligne1.setFormateur(formateur1.getCin());
        ligne1.setFormation(formation.getId());
        Ligneformationformateur ligne2 = new Ligneformationformateur();
        ligne2.setFormateur(formateur2.getCin());
        ligne1.setFormation(formation.getId());
        dao.save(formation);
        daoligne.save(ligne1);
        daoligne.save(ligne2);
        Formation savedFormation = dao.getById(formation.getId());
    }
}
