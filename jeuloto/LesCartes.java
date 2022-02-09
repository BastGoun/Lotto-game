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
public class LesCartes{//déclaration de la classe Les Cartes
    private ArrayList<CarteLoto>lst;//attribut lst de type ArrayList composé de CarteLoto
    
    public LesCartes(){//constructeur de LesCartes par défaut
        this.lst = new ArrayList<CarteLoto>();//instanciation de la ArrayList lst
    }
    
    public int getTaille(){//récupération de la taille de la ArrayList
        return this.lst.size();
    }
    
    public CarteLoto getCarte(int i){//récupération de la CarteLoto au rang i
        if(i>=0&&i<getTaille())
            return this.lst.get(i);//si la carte est dans la ArrayList, on la retourne
        else
            return null;
    }
    
    public void ajouteCarte(CarteLoto c){//ajout d'une carte à la liste des CartesLoto lst
        this.lst.add(c);
    }
    
    public void retireCarte(CarteLoto c){//on retire la carte qui est placé en parametre
        this.lst.remove(c);
    }
    
    public void retireCarte(){//on retire l'intégralité des cartes présente dans la liste
        this.lst.clear();
    }
    
    public LesCartes rechCartes(int num){//on recherche les cartes comportants la valeur passé en parametre
        LesCartes lc = new LesCartes();//instanciation d'une nouvelle carte
        for(int i=0;i<getTaille();i++)//on parcours l'intégraité de la liste de cartes
            if(getCarte(i).estDans(num))//si une carte comporte la valeur passé en parametre
                lc.ajouteCarte(getCarte(i));//on l'ajout à lc
        return lc;//on retourne lc
    }
    
    public void initLesCartes(int n, int nbcol, int nbval){//Initialisation des cartes
        for(int i=0;i<n;i++){//pour l'nesemble des cartes jusqu'à n
            CarteLoto c = new CarteLoto(nbcol,nbval);//instanciation de CarteLoto
            ajouteCarte(c);//ajout de c à la Liste des Cartes lst
        }
    }

    
    public String toString(){//méthode pour afficher la carte
        String res="";
        for(int i=0;i<getTaille();i++)
            res = res +"Carte n°"+(i+1)+"\n"+getCarte(i).toString()+"\n";
        return res;
    }
}
