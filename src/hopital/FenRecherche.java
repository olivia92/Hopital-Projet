/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;

/**
 *
 * @author Olivia
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class FenRecherche extends JFrame implements ActionListener, ItemListener{
    
    private JTextField requete;
    private final JPanel p;
    private Connexion maconnexion;
    
    
    public FenRecherche(Connexion connexion){
        super("Fenêtre de Recherche");
        
        this.maconnexion=connexion;
        
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setVisible(true);
        p = new JPanel();
        
        //requete = new JTextField();
        p.setLayout(new GridLayout(1, 3));
        
        p.add(requete);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
