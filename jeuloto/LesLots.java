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
public class LesLots {//instanciation de la classe LesLots
    private ArrayList<Lots>lsl;//attribut de type ArrayList lsl
    
    public LesLots(){//constructeur par défaut de LesLots
        this.lsl = new ArrayList<Lots>();//instanciation d'une ArrayList de type Lots
    }
    
    public int getTaille(){//récupération de la taille de lsl
        return this.lsl.size();
    }
    
    public Lots getLots(int i){//récupération d'un lot dans la ArrayList avec i en parametre
        if(i>=0&&i<getTaille())//si le lot à l'index i est présent
            return this.lsl.get(i);//on retourne le lot à l'index i
        else
            return null;//sinon on ne retourne rien
    }
    
    public void ajouteLots(Lots l){//ajout d'un lot dans la Arraylist lsl
        this.lsl.add(l);
    }
    
    public void retireLot(){//on retire l'intégralité des lots qui sont dans la ArrayList lsl
        this.lsl.clear();
    }
    
}
