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
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FenMenuu extends JFrame implements ActionListener {
    private Connexion maconnexion;
    private JLabel bonjour;
    private JPanel contentPane;
    private JPanel myPanel;
    private JFrame myFrame;
    private JButton n;
    
    public FenMenuu(Connexion connexion) {
        this.maconnexion = connexion;
        contentPane = new JPanel();
        bonjour = new JLabel("bonjour");
        n= new JButton("recherche");
        myPanel=new JPanel();
        myPanel.setOpaque(true);
        
        myPanel.setLayout(new GridLayout(1, 2));
        myPanel.add(bonjour);
        myPanel.add(n);
        
        contentPane.add(myPanel);
        n.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == n) {
          this.goToRecherche();  
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void goToRecherche(){
        myFrame.setVisible(false); //rend la fenêtre plus visible
        FenRecherche recherche= new FenRecherche(this.maconnexion);
    }
    
}
