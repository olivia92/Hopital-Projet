/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cfran
 */
public class FenMenu extends JFrame implements ActionListener {
    private Connexion maconnexion;
    private JLabel bonjour;
    private JPanel contentPane;
    private JPanel myPanel;
    private JFrame myFrame;
    private JButton n; /**creation bouton recherche*/
    private JButton maj; /**creation bouton mise a jour*/
    private JButton r; /**creation bouton reporting*/
    
    public FenMenu() {
        Connexion connexion = null;
        this.maconnexion = connexion;
        contentPane = new JPanel();
        bonjour = new JLabel("Bonjour, que voulez-vous faire?");
        n= new JButton("Recherche dans la base de donnees");
        maj = new JButton ("Mettre a jour la table");
        r=new JButton("Reporting");
        
        myPanel=new JPanel();
        myPanel.setOpaque(true);
        
        myPanel.setLayout(new GridLayout(4, 1,0,20)); // 4 représente le nb de lignes et 1 le nb de colonnes
        
        myPanel.add(bonjour);
        myPanel.add(n);
        myPanel.add(maj);
        myPanel.add(r);
        
        contentPane.add(myPanel);
        n.addActionListener(this);
        maj.addActionListener(this);
        r.addActionListener(this);
        
        myFrame=new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setPreferredSize(new Dimension(400,300));//width:400px, height:300px
        myFrame.setLocationRelativeTo(null);//to show at center of screen
        myFrame.setTitle("Menu");
        //myFrame.add(myPanel);
        myFrame.setContentPane(contentPane);
        myFrame.pack();//this alone will not give the frame a size
        myFrame.setVisible(true);
    }
    /**
    //public FenMenu(){
        
		
    this.setTitle("Menu");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    

    JPanel recherche= new JPanel();
    recherche.setLayout(new BoxLayout(recherche, BoxLayout.LINE_AXIS));
    recherche.add(new JButton("Recherche dans la base de données "));
    
    

    JPanel maj = new JPanel();
    maj.setLayout(new BoxLayout(maj, BoxLayout.LINE_AXIS));
    maj.add(new JButton("Mise à jour de la table"));
    

    JPanel reporting = new JPanel();
    //Idem pour cette ligne
    reporting.setLayout(new BoxLayout(reporting, BoxLayout.LINE_AXIS));
    reporting.add(new JButton("Reporting"));
   

    JPanel colonne = new JPanel();

    colonne.setLayout(new BoxLayout(colonne, BoxLayout.PAGE_AXIS));
    colonne.add(recherche);
    colonne.add(maj);
    colonne.add(reporting);
		
    this.getContentPane().add(colonne);
    this.setVisible(true);
  } */
    
      @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == n) {
          this.goToRecherche();  
        }else if (source == maj){
            this.goToMaj();
        }else if (source == r){
            this.goToReporting();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void goToRecherche(){
        myFrame.setVisible(false); //rend la fenêtre plus visible
        FenRecherche recherche= new FenRecherche(this.maconnexion);
    }
    
    public void goToMaj(){
        myFrame.setVisible(false); //rend la fenêtre plus visible
        FenMaj MiseAJour = new FenMaj(this.maconnexion);
    }
    
    public void goToReporting(){
        myFrame.setVisible(false); //rend la fenêtre plus visible
        FenReporting reporting = new FenReporting(this.maconnexion);
    }
    
    
}

