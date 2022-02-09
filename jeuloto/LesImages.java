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
public class LesImages {//déclaration de la classe LesImages
    private ImageIcon[] lstI = new ImageIcon[6];//attribut lstI qui est un tableau de ImageIcon de 6 places mémoires
    
    public LesImages(){//constructeur par défaut de LesImages
        InitImages();//initialisation du tableau avec les images
    }
    
    public void InitImages(){//méthode pour ajouter des images au tableau
        ImageIcon image1 = new ImageIcon(getClass().getResource("/jeuloto/Icon/lara.jpg"));//récupération du chemin et affectation de l'image dans une nouvelle instance d'image
        ImageIcon image2 = new ImageIcon(getClass().getResource("/jeuloto/Icon/jack.png"));
        ImageIcon image3 = new ImageIcon(getClass().getResource("/jeuloto/Icon/joueurDefaut.png"));
        ImageIcon image4 = new ImageIcon(getClass().getResource("/jeuloto/Icon/player.jpg"));
        ImageIcon image5 = new ImageIcon(getClass().getResource("/jeuloto/Icon/player2.jpg"));
        ImageIcon image6 = new ImageIcon(getClass().getResource("/jeuloto/Icon/player3.png"));
        
        this.lstI[0]=image1;//ajout des instances de image dans le tableau
        this.lstI[1]=image2;
        this.lstI[2]=image3;
        this.lstI[3]=image4;
        this.lstI[4]=image5;
        this.lstI[5]=image6;
    }
    
    public int getTailleLesImage() {//récupération de la taille du tableau lstI
        return this.lstI.length;
    }

    
    public ImageIcon getImage(int i){//récupération de l'image placé au rang i(en parametre)
        return this.lstI[i];
    }
}
