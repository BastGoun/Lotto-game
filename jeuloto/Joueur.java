/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuloto;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author bast
 */
public class Joueur {//déclaration de la classe Joueur

    private String pseudo;//attribut pour le pseudo du joueur
    private Color couleur;//attribut pour la couleur du joueur
    private double solde;//attribut pour le solde du joueur
    private ImageIcon photo;//attribut pour l'image qui va représenter le joueur
    private LesCartes mesC;//attribut pour avoir la liste des cartes du joueurs
    private LesLots mesL;//attribut pour avoir la liste des lots

    public LesLots getMesLots(){//récupération de la liste de lots du joueur
        return this.mesL;
    }
    
    public void setLot(Lots lot){//méthode pour affecter un lot à la liste des lots mesL
        this.mesL.ajouteLots(lot);
    }
    public String getPseudo() {//méthode pour récupérer le pseudo d'un joueur
        return this.pseudo;
    }

    public Color getCouleur() {//méthode pour récupérer la couleur d'un joueur 
        return this.couleur;
    }

    public double getSolde() {//méthode pour récuprérer le solde d'un joueur
        return this.solde;
    }

    public ImageIcon getPhoto() {//permet de récupérer l'image d'un joueur
        return this.photo;
    }
    
    public LesCartes getMesCartes(){//permet de récupérer la liste des Cartes d'un joueur
        return this.mesC;
    }
    
    
    public int getLesLots(){//permet de récupérer la taille de la liste des lots
        return this.mesL.getTaille();
    }
    
    public int getLesCartes(){//pemret de récupérer la taille de la liste des Cartes
        return this.mesC.getTaille();
    }

    public void setPseudo(String p) {//permet d'affecter un pseudo passer en parametre
        this.pseudo = p;
    }

    public void setCouleur(Color c) {//permet d'affecter une couleur passer en parametre
        this.couleur = c;
    }

    public void setPhoto(ImageIcon p) {//permet d'affecter une image passer en parametre
        this.photo = p;
    }

    public void setSolde(double s) {//permet d'affecter un solde passer en parametre
        this.solde = s;
    }

    public Joueur() {//constrcuteur de Joueur par défaut
        this.pseudo = "";
        this.couleur = Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/jeuloto/Icon/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();
    }

    public Joueur(String p) {//constructeur de Joueur avec le pseudo passer en parametre
        this.pseudo = p;
        this.couleur = Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/jeuloto/Icon/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();
    }
    
    public boolean acheter(CarteLoto c){//méthode pour demander l'autorisation de l'achat d'une carte
        if(this.solde>c.getPrix()){//si le solde du joueur est supérieur au prix d'une carte
           return true;//on retourne true
        }
        else{
            return false;//sinon on retourne false
        }
    }
    
    public String toString(){//permet l'affichage des informations du joueur (hors couleur et pseudo)
        if(this.mesC.getTaille()==0){//si il n'y a pas de cartes
            String g = "Le joueur ne possède aucune carte";
            if(this.mesL.getTaille()==0)//si le joueur possede aucun lot
                g+="\n\nLe Joueur ne possède aucun Lot";
            else//
                g+="\n\nLe Joueur possède"+this.mesL.getTaille()+" lot/s";//sinon on affiche la liste des lots
                for(int i =0; i<this.mesL.getTaille();i++){//boucle qui va permettre de lister le descriptif des lots renportés
                    g+="\n - "+this.mesL.getLots(i).getDescriptif();
                }
            return g;//on retourne g
        }
        else{//si il y a des cartes
            String g = "Le joueur possède "+this.mesC.getTaille()+" cartes";//on affiche le nombre de cartes
            if(this.mesL.getTaille()==0)//si le joueur possede aucun lot
                g+="\n\nLe Joueur ne possède aucun Lot";
            else//si le joueur possède un lot au minimum
                g+="\n\nLe Joueur possède "+this.mesL.getTaille()+" lot/s";
            for(int i =0; i<this.mesL.getTaille();i++){//boucle qui va permettre de lister le descriptif des lots renportés
                    g+="\n - "+this.mesL.getLots(i).getDescriptif();
                }
            return g;//on retourne g
        }
    }
}
