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
import javax.swing.border.LineBorder;

public class FenLogin extends JFrame implements ActionListener {
    
     private JFrame myFrame;
    // Added by me
    private JPanel contentPane;
    private JPanel myPanel;
    private JLabel username=null;
    private JLabel password=null;
    private JLabel nameBDD= null;
    private JLabel databasepassword=null;
    private JTextField usernameField=null;
    private JTextField nameBDDText=null;
    private JPasswordField passwordField=null;
    private JPasswordField passwordFieldBDD=null;
    private Color myColor=new Color(173, 216, 230);
    private Font myFont11=new Font("Tahoma", 1, 11);
    private Font myFont12bold=new Font("Tahoma", Font.BOLD, 12);
    private Font myFont11bold=new Font("Tahoma", Font.BOLD, 11);
    private JButton connect, local;
    
    public void createComponents(){
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        

        nameBDD=new JLabel("name BDD");
        nameBDD.setLabelFor(nameBDDText);
        nameBDD.setFont(myFont11);
        nameBDD.setForeground(Color.white);
        
        username=new JLabel("Username");
        username.setLabelFor(usernameField);
        username.setFont(myFont11);
        username.setForeground(Color.white);
        
        databasepassword=new JLabel("database Password");
        databasepassword.setLabelFor(passwordFieldBDD);
        databasepassword.setFont(myFont11);
        databasepassword.setForeground(Color.white);
        
        password=new JLabel("Password");
        password.setLabelFor(passwordField);
        password.setFont(myFont11);
        password.setForeground(Color.white);
        
        nameBDDText=new JTextField(10);
        nameBDDText.setBorder(new LineBorder(null, 0, false));
        passwordFieldBDD=new JPasswordField(10);
        passwordFieldBDD.setBorder(new LineBorder(null, 0, false));
        
        
        usernameField=new JTextField(10);
        usernameField.setBorder(new LineBorder(null, 0, false));
        passwordField=new JPasswordField(10);
        passwordField.setBorder(new LineBorder(null, 0, false));
        
        connect=new JButton ("connexion internet");
        local=new JButton("connexion locale");
        
        //Panel
        myPanel=new JPanel();
        myPanel.setOpaque(true);
        myPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        myPanel.setBackground(myColor);
        myPanel.setLayout(new GridLayout(5, 2, 2, 2)); // 5 désigne la ligne, 2 la colonne
        myPanel.add(username);
        myPanel.add(usernameField);
        myPanel.add(password);
        myPanel.add(passwordField);
        myPanel.add(nameBDD);
        myPanel.add(nameBDDText);
        myPanel.add(databasepassword);
        myPanel.add(passwordFieldBDD);
        myPanel.add(connect);
        myPanel.add(local);
        
        //----------------------------------------------------------
        contentPane.add(myPanel);

        myFrame=new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setPreferredSize(new Dimension(400,300));//width:400px, height:300px
        myFrame.setLocationRelativeTo(null);//to show at center of screen
        myFrame.setTitle("Page de Connexion");
        //myFrame.add(myPanel);
        myFrame.setContentPane(contentPane);
        myFrame.pack();//this alone will not give the frame a size
        myFrame.setVisible(true);
        
        
        connect.addActionListener(this);
        local.addActionListener(this);
        
    
        
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        
        Object source = evt.getSource();

        // tester cas de la commande evenementielle
        if (source == connect) {
            ArrayList<String> liste;
            String passwdECEString = new String(passwordField.getPassword());
            String passwdBDDString = new String(passwordFieldBDD.getPassword());
            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    Connexion maconnexion = new Connexion(username.getText(), passwdECEString,
                            "root", passwdBDDString);

                
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } else if (source == local) {
            ArrayList<String> liste;
            try {
                String passwordstring = new String(passwordField.getPassword());
                String usernamestring = usernameField.getText();
                try {

                    // tentative de connexion si les 4 attributs sont remplis
                    Connexion maconnexion = new Connexion(nameBDDText.getText(), usernamestring, passwordstring);
                    System.out.println("Connexion réussie");
                
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } 

           

          
    }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

  
    

