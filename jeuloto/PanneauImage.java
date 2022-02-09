/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuloto;
import java.awt.*;
import java.util.ArrayList;//import des différentes bibliotèques de java
import javax.swing.*;


public class PanneauImage extends JPanel{//sorte de JPanel (classe dérivée)
    private Image img;//image changeante en fonction du constructeur
    
    public PanneauImage(){//constructeur par défaut
        super();//appel du constructeur de la classe encetre
        this.img = null;//initialisation de l'attribut à null
    }
    
    public PanneauImage(Image img){//constructeur avec une image en parametre
        super();//appel du constructeur de la classe encetre
        this.img=img;//initialisation de l'attribut avec le parametre du constructeur
    }
    
    public Image getImage(){//getter qui retourne l'attribut img
        return this.img;
    }
    public void setImage(Image img){
        this.img = img;
        this.repaint();//surchargement de la méthode paint de la classe mère,pour redessiner l'image dans le panneau (sur tout le panneau)
    }
    
    public void paint(Graphics g){//parametre de type Graphics pour pouvoir dessiner sur un JPanel
        super.paint(g);//appel de la méthode paint de la classe encetre, on lui donne en parametre le graphique
        if(this.img!=null){//si l'image est non nulle
            g.drawImage(this.img, 0, 0, this.getWidth(),this.getHeight(),this);//méthode de la classe Graphics pour dessiner une image
            //img de type image à dessiner
            //(0,0)coord à gauche
            //largeur
            //hauteur
            //this = objet courant à observer
        }
    }
}
