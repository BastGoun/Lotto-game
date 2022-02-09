/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuloto;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author bast
 */
public class Lots {//déclaration de la classe Lots
    private String Descriptif;//attribut pour le descriptif du lot
    private String categorie;//attribut pour la catégorie du lot
    private ImageIcon img;//image du lot
    private int niveau;//niveau du lot
    
    public void setDescriptif(String des){//permet de fixer un descirptif au lot
        this.Descriptif = des;
    }
    
    public void setCategorie(String cat){//permet de fixer une categorie au lot
        this.categorie = cat;
    }
    
    public void setNiveau(int niv){//pemet de fixer un niveau au lot
        this.niveau = niv;
    }
    
    public String getDescriptif(){//permet de récupérer le descriptif du lot
        return this.Descriptif;
    }
    
    public String getCategorie(){//permet de récupérer la catégorie du lot
        return this.categorie;
    }
    
    public int getNiveau(){//permet de récupérer le niveau du lot
        return this.niveau;
    }
    
    public Lots(String des, String cat, int niv){//constructeur de Lots avec en parametre le descriptif, la catégorie et le niveau 
        //on affecte les différentes informations aux attributs
        setDescriptif(des);
        setCategorie(cat);
        setNiveau(niv);
    }
    
    public Lots(){//constructeur par défaut de Lots
        this("","",0);
    }
}
