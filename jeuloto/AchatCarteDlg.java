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
/**
 *
 * @author bast
 */
public class AchatCarteDlg extends javax.swing.JDialog {
    private ArrayList<Joueur>lsj; //ArrayList des Joueurs de type Joueurs
    private int nbCol, nbLig; //Nombre de colonnes, de lignes et du nombre de numéros de type int
    private int nbNum;//Nombre de numéros
    private Joueur jc; //sélection de un joueur jc (joueur courant) avec comme type Joueur
    private CarteLoto cc; //carte loto qui sera proposé au joueur avec comme type CarteLoto
    private boolean achat; //boolean permettant de savoir si un achat à déja été fait avec comme type un boolean
    private ArrayList<String> NomJoueur = new ArrayList<String>();//nom des joueurs pour la combobox
    /**
     * Creates new form AchatCarteDlg
     */
    public AchatCarteDlg(java.awt.Frame parent, boolean modal, ArrayList<Joueur> lsj, int nbl, int nbc,int val) {
        super(parent, modal);//appel du constructeur de la classe mère
        this.lsj = lsj;//attribut lsj prend la valeur de la ArrayList
        this.nbCol = nbc;//nombre de colonne donné en parametre 
        this.nbLig = nbl;//nombre de ligne donné en parametre
        this.nbNum = val;//nombre de numéro donné en parametre
        this.achat=false;//valeur de l'achat donné en parametre (si un achat à été fait)
        this.jc = lsj.get(0);//joueur courant placé initialment au premier de la liste
        this.cc = new CarteLoto(this.nbCol,val);//initialisation d'une carte de loto avec en parametre le nombre de colonne et le nombre de numéros
        initComponents();//initialisation des composants de la boite de dialogue
        remplirListeJoueurs();//méthode pour remplir la JComboBox des joueurs
        affInit();//méthode pour initialiser un text donnant le solde du joueur
        initCarte();//méthode pour initialiser la carte 
        afficheCarte();//méthode pour afficher la carte
    }
    public boolean getAchat(){//getter classique pour pouvoir récupérer la valeur de achat
        return this.achat;
    }
    
    public void AchatRealise(){//méthode pour donner une valeur à achat
        for(int i=0;i<this.lsj.size();i++){//boucle parcourant les joueurs
            if(this.lsj.get(i).getLesCartes()!=0){//si un joueur possede une carte
                this.achat = true;//attribut achat passe à true
            }
        }
    }
    
    public void initCarte(){//initialisation des cartes
        PCentre.setLayout(new GridLayout(this.nbLig,this.nbCol));//PCentre se voit accorder un GrdiLayout en fonction de nbLig et nbCol
        for(int i = 0;i<this.nbCol*this.nbLig;i++){//boucle permettant d'avoir un affichage de nb boutons 
            JButton bouton = new JButton();//instanciation d'un bouton 
            PCentre.add(bouton);//ajout de ce bouton dans PCentre (il y en aura [nbCol*.nbLig] en tout)
        }
    }
    
    public void afficheCarte(){//affichage d'une carte
        int num = 0;//initialisation d'un entier qui va permettre de récupérer un composant
            for(int i=0;i<nbLig;i++){//boucle parcourant les lignes
                for(int y=0;y<nbCol;y++){//boucles parcourant les colonnes
                    if(this.cc.getCase(i,y)!=0){//si une Case de coordonnée xi,y est différente de 0
                        JButton button = (JButton)PCentre.getComponent(num);//on récupère un composant bouton d'index num
                        button.setText(""+this.cc.getCase(i,y));//on lui affecte le numéro qui est à l'intérieur de la Case de coordonné i,y
                    }
                    else if(this.cc.getCase(i,y)==0){//si une Case de coordonnée i,y est égale à 0
                        JButton button = (JButton)PCentre.getComponent(num);//on récupère le bouton d'index num
                        button.setText("");//on lui affecte un text qui est vide
                    }
                    num++;//on incrémente num de 1
                }
            }
    }
    
    public void remplirListeJoueurs(){//remplissage de la JComboBox avec les pseudos des joueurs
        DefaultComboBoxModel mod;//initialisation d'une DefaultComboBoxModel nommé mod
        for(int i=0;i<this.lsj.size();i++){//boucle parcourant l'ensemble des joueurs
            NomJoueur.add(this.lsj.get(i).getPseudo());//Ajout à l'ArrayList  placé en attribut des pseudos des joueurs
        }
        mod = new DefaultComboBoxModel(NomJoueur.toArray());//instanciation de la DefaultComboBoxModel avec en parametre une ArrayList 
        ComboBoxPseudo.setModel(mod);//Ajout de mod à ComboBoxPseudo
    }
    
    public ArrayList getArrayList(){//getter classique permettant de renvoyé la Arrylist lsj
        return this.lsj;
    }

    public void afficherSolde(){//méthode pour afficher le solde du joueur en fonction de l'index sélectionné dans la JComboBox ComboBoxPseudo et des méthodes pour récupérer le solde et le pseudo du joueur
        Edition.setText(this.lsj.get(ComboBoxPseudo.getSelectedIndex()).getPseudo()+" dispose de "+this.lsj.get(ComboBoxPseudo.getSelectedIndex()).getSolde()+"€");
    }
    
    public void affInit(){//méthode pour un affichage initial du solde du premier joueur de la liste
        Edition.setText(lsj.get(0).getPseudo()+" dispose de "+lsj.get(0).getSolde()+"€");
        jc = this.lsj.get(0);//le joueur courant est désigné comme le permier joueur de la liste
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PHaut = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PFoot = new javax.swing.JPanel();
        Bas = new javax.swing.JPanel();
        ComboBoxPseudo = new javax.swing.JComboBox<>();
        Autrechoix = new javax.swing.JButton();
        Acheter = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        Haut = new javax.swing.JPanel();
        Edition = new javax.swing.JLabel();
        PCentre = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PHaut.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acheter une ou plusieurs cartes");
        PHaut.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PHaut, java.awt.BorderLayout.PAGE_START);

        PFoot.setLayout(new java.awt.BorderLayout());

        Bas.setLayout(new java.awt.GridLayout(1, 4));

        ComboBoxPseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPseudoActionPerformed(evt);
            }
        });
        Bas.add(ComboBoxPseudo);

        Autrechoix.setText("Autre choix");
        Autrechoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutrechoixActionPerformed(evt);
            }
        });
        Bas.add(Autrechoix);

        Acheter.setText("Acheter");
        Acheter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcheterActionPerformed(evt);
            }
        });
        Bas.add(Acheter);

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        Bas.add(Quitter);

        PFoot.add(Bas, java.awt.BorderLayout.CENTER);

        Haut.setLayout(new java.awt.BorderLayout());

        Edition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Haut.add(Edition, java.awt.BorderLayout.CENTER);

        PFoot.add(Haut, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PFoot, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout PCentreLayout = new javax.swing.GroupLayout(PCentre);
        PCentre.setLayout(PCentreLayout);
        PCentreLayout.setHorizontalGroup(
            PCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PCentreLayout.setVerticalGroup(
            PCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        getContentPane().add(PCentre, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxPseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxPseudoActionPerformed
        afficherSolde();//lors du choix d'un joueur dans la ComboBox, on affiche le solde du joueur sélectionné
        jc = this.lsj.get(ComboBoxPseudo.getSelectedIndex());//le joueur courant devient ce joueur sélectionné
    }//GEN-LAST:event_ComboBoxPseudoActionPerformed

    private void AutrechoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutrechoixActionPerformed
        CarteLoto carte = new CarteLoto(this.nbCol,this.nbNum);//instanciation d'une nouvelle CarteLoto avec nbCol et nbNum en parametre
        this.cc = carte;//cette carte devient la carte cc
        afficheCarte();//on affiche cette carte cc pour avoir un nouveau choix
    }//GEN-LAST:event_AutrechoixActionPerformed

    private void AcheterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcheterActionPerformed
        if(this.jc.getMesCartes().getTaille()<=1){//si le joueur courant possede moins de deux cartes
            if(this.jc.getSolde()>0){//si le solde ce joueur est supérieur à 0
                this.jc.getMesCartes().ajouteCarte(this.cc);//ajout de la carte cc à la liste des cartes du joueur courant
                this.jc.setSolde(this.jc.getSolde()-this.cc.getPrix());//on enleve le prix de la carte au solde du joueur
                this.setVisible(false);//on rend invisible la boite de dialogue
                this.AchatRealise();//on appel la méthode pour vérifier si une carte au moins à été acheter
            }else{
                this.setVisible(false);//si le solde du joueur est insuffisant
                this.dispose();//on efface la boite de dialogue
                JOptionPane option = new JOptionPane();//instanciation d'une boite de dialogue permettant l'affichage d'informations
                option.showMessageDialog(this, "Solde du joueur insuffisant","Jeu Loto",JOptionPane.WARNING_MESSAGE);//on indique l'information au joueur
            }
        }else if(this.jc.getMesCartes().getTaille()>1){//si le joueur possede plus de deux cartes
            JOptionPane option = new JOptionPane();//instanciation d'une boite de dialogue permettant l'affichage d'informations
                option.showMessageDialog(this, "Le joueur possède déja deux cartes","Jeu Loto",JOptionPane.WARNING_MESSAGE);//on indique l'information au joueur
        }
    }//GEN-LAST:event_AcheterActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        this.setVisible(false);//permet de rendre invisible la boite de dialogue
        this.dispose();//on efface la boite de dialogue
    }//GEN-LAST:event_QuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acheter;
    private javax.swing.JButton Autrechoix;
    private javax.swing.JPanel Bas;
    private javax.swing.JComboBox<String> ComboBoxPseudo;
    private javax.swing.JLabel Edition;
    private javax.swing.JPanel Haut;
    private javax.swing.JPanel PCentre;
    private javax.swing.JPanel PFoot;
    private javax.swing.JPanel PHaut;
    private javax.swing.JButton Quitter;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
