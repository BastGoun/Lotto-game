/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuloto;
import java.awt.*;
import java.util.ArrayList;//import des différentes bibliotèques de java
import javax.swing.*;
/**
 *
 * @author bast
 */
public class CarteLoto{
    private int tab[ ] [ ]; // tableau représentant la carte, avec ses nombres (0 si case vide)
    private int jetons[ ] [ ]; // tableau donnant uniquement les valeurs recouvertes de la carte
    private int nbCol;//nombre de colonne
    private int nbLig;//nombre de ligne
    private int nbNumeros;//nb de numéros de la carte, dépend de nbLig et nbCol
    private double prix;//prix de la carte
    private final int valMax=90; //valeur max des numéros, constante

    public CarteLoto( ){ // valeurs fixées par défaut
        this.nbNumeros=15; // fixe le nb de numéros présents sur la carte
        this.nbCol = 9; // fixe le nb de colonnes de la carte
        this.nbLig=3; // fixe le nb de lignes de la carte
        this.tab = new int[nbLig][nbCol]; // on alloue de la mémoire pour stocker le contenu du tableau tab
        this.jetons = new int[nbLig][nbCol]; // on alloue de la mémoire pour stocker le contenu du tableau jetons
        this.prix=5; // fixe le prix de la carte
        initValeursCarte( );
    }
 
    public CarteLoto(int nbC,int nbVal){
        this.nbNumeros = nbVal; // l’utilisateur fixe le nb de numéros de la carte
        this.nbCol = nbC; // l’utilisateur fixe le nb de colonnes de la carte
        this.nbLig=3;//nombre de ligne bloqué à 3
        this.tab = new int[nbLig][nbCol];//nouveau tableau à deux dimensions tab avec nbLig et nbCol
        this.jetons = new int[nbLig][nbCol];///nouveau tableau à deux dimensions jetons avec nbLig et nbCol
        this.prix=5;//prix proposé à 5€
        initValeursCarte();//appel de la méthode initValeursCarte()
    }
    
    public int getCase(int i, int j) {//méthode pour récupérer une case de coordonné i,j
        if(i >= 0 && i < nbLig && j >= 0 && j < nbCol)//si la case de cordonné i j rentre dans les criteres, on la retourne
            return this.tab[i][j];
        else
            return -1 ;//sinon on renvoie -1
    }
    
    public int getValMax() {//getter classique pour renvoyer valMax
        return valMax;
    }

    public double getPrix(){//getter classique pour retourner le prix
        return prix;
    }

    public void setPrix(double prix) {//setter pour mettre en place un autre prix que celui proposé
        this.prix = prix;
    }

    public int getNbNumeros(){//permet de récupérer le nombre de numéros dans un tableau
        return nbNumeros;
    }

    public void setNbNumeros(int nbNumeros) {//permet de mettre en place un nombre de numéros
        this.nbNumeros = nbNumeros;
    }

    public int getNbLig(){//permet de renvoyrer le nombre de ligne
        return nbLig;
    }

    public void setNbLig(int nbLig){//permet de placer le nombre de ligne
        this.nbLig = nbLig;
    }

    public int getNbCol(){//permet de récupérer le nombre de colonne
        return nbCol;
    }

    public void setNbCol(int nbCol) {//permet de placer le nombre de colonne
        this.nbCol = nbCol;
    }

    public int[][] getJetons() {//permet de retourner une case d'un tableau à deux dimensions de type int (récupérer un jeton)
        return jetons;
    }

    public void setJetons(int jetons[][]) {//permet de placer un jeton sur une case du tableau
        this.jetons = jetons;
    }

    public int[][] getTab() {//permet de récupérer une case de tab
        return tab;
    }

    public void setTab(int tab[][]) {//permet de placer une case de tab
        this.tab = tab;
    }
    
    public String toString( ){//méthode qui va permettre d'avoir un rendu visuel du tableau tab
        String res="";
        for(int i=0; i<this.nbLig; i++){ // parcours des lignes
            for(int j=0; j<this.nbCol; j++){ // parcours des colonnes
                int num = tab[i][j];//récpération de chaque association de i et j
                if(num!=-1){//si num est différent de -1
                   if(num>10)//si num est suéprieur à on ajoute seulement un espace
                    res+=" "+tab[i][j];
                else//sinon on rajoute deux espaces
                    res+="  "+tab[i][j]; 
                }
            }
            res+="\n"; // saut à la ligne dans la chaine
        } // construit une chaine de caractères comportant les numéros d’une carte, ligne par ligne
        return res;
    }
    
    
    public boolean estDans(int val){//méthode qui va permettre de savoir si la valeur en parametre se trouve dans le tableau
        boolean res=false;
        int j, i = 0;
        do{//meme fonctionnement qu'une boucle for mais avec un do while
            j = 0;
            while(j < nbCol && res != true) {//tant que les conditions ne sont pas remplies
                if (tab[i][j] == val)//si la valeur de val est comprise dans une case de tab
                    res = true;//res passe à true
                    j++;//on incrémente de 1
            }
            i++;//on incrémente de 1
        } while (res != true && i < nbLig);//tant que toutes les cases ne sont pas passées
        return res;//on retourne le boolean qui va etre a true si le tableau comporte cette valeur
    }

    public void initValeursCarte() {//initialisation de la méthode des cartes 
        int i,j,k,n, num=0;
        //Toutes les valeurs des cases de la carte (tab) sont initialisées à 0 ainsi que toutes celles des jetons.
        for(i=0; i<this.nbLig; i++)
            for(j=0; j<this.nbCol; j++){
                if(num<=this.nbNumeros){
                    tab[i][j] = 0;
                    jetons[i][j] = 0;
                    num++;
                }
            }
            i = 0;
            //Pour chaque numéro à placer
            for(k=0; k<this.nbNumeros; k++){
            //Sur une ligne, on recherche aléatoirement une case vide pour placer le numéro.
                do{
                    j = (int)(Math.random()*this.nbCol) ;
                } while(tab[i][j] != 0 );
                //On génère aléatoirement ce numéro : un nombre compris entre 1 et la valeur maximum de numéros possibles (s’il est déjà présent dans la carte, on recommence)
                do{
                    n = (int)(Math.random()*this.valMax + 1) ;
                } while(this.estDans(n)) ;
                //on place ce nombre dans la case vide (sinon on regénère un nb)
                tab[i][j] = n;
                //On passe à la ligne suivante (ou à la première si on était à la dernière)
                i++;
                    if(i == this.nbLig)
                        i = (int)(Math.random()*3);
                        //ou : i = (i+1)%this.nbLig;
            }
    }
    
    //utilisée lors de chaque tirage
    public boolean placePion(int val){
        boolean res=false;
            for(int i=0; i<this.nbLig; i++) //parcours des lignes
                for(int j=0; j<this.nbCol; j++) //parcours des colonnes
                    if (tab[i][j]==val){ //si la valeur cherchée est trouvée dans la carte
                        res=true; 
                        jetons[i][j]=val;
                    } //on place un pion au même endroit dans le tableau jetons
                return res;
    }

    public boolean estLignePleine(int lig){
        boolean res=true; //on suppose la ligne pleine
            for(int j=0; j<this.nbCol; j++) //parcours de la ligne n°lig
                if (jetons[lig][j]!=tab[lig][j]) 
                    res=false; //si un jeton n’est pas sur un numéro de la ligne, la ligne n’est pas pleine et le booléen passe à false
                return res;
    }


    public int getNbLignesPleines ( ) {//
        int cpt = 0;
            for(int i=0; i<this.nbLig; i++)//boucle qui parcours l'ensemble des lignes
                if (estLignePleine(i))//si une ligne est pleine
                    cpt++;//cpt incrémenté de 1
                return cpt;//on retourne la valeur de cpt à la fin du parcours des lignes
   }
 
 //appelée à chaque tirage
    public boolean cartonGagnant(int option){//méthode pour valider ou non si en fonction de l'option sélectionner, le jeu est gagné ou pas   
        boolean res=false;
        switch (option){//en fonction du parametre option
            case 1 : res= (getNbLignesPleines()==1);break; // si option 1 choisie (gagnant avec une ligne), resprend la valeur true (comparaison avec 1 du résultat renvoyée par la méthode getNbLignesPleines)
            case 2 : res= getNbLignesPleines()==2;break; // idem avec option 2 (gagnant avec deux lignes)
            case 3 : res= getNbLignesPleines()==3; // idem avec option 3 (gagnant avec trois lignes)
        }
        return res;//on retourne la valeur de res
    }
    
    public void dessineCarte(JPanel jp,Color coul){//dessine une carte dans un panneau placé en parametre et une couleur en parametre
        jp.removeAll();//on supprime ce qu'il y a dans le panneau
        jp.setLayout(new GridLayout(nbLig,nbCol));
        for(int i=0; i<this.nbLig; i++){ // parcours les lignes
            for(int j=0; j<this.nbCol; j++){ // parcours les colonnes
                JButton button = new JButton();//instanciation d'un bouton
                button.setBackground(coul);//on fixe la couleur coul en background du bouton
                if(tab[i][j]==0){//si la case de coordonnée i j est égale à 0
                    button.setText("");//on affecte un texte vide
                }
                else if(jetons[i][j]!=0){//si la valeur de la case est différente de 0
                    button.setBackground(Color.white);//la case devient blanche
                    button.setText(""+tab[i][j]);//et on affecte sa valeur sur celle-ci
                }
                else{
                    button.setText(""+tab[i][j]);//sinon on affcete juste la valeur de celle-ci
                }
                jp.add(button);//on ajoute le bouton au panneau
            }
        }
    }
}
