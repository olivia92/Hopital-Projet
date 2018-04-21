/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author cfran
 */
public class Hopital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creation de la fenetre
        //Fenetre f = new Fenetre();
        
        //SwingUtilities.invokeLater(new Runnable()
        //{
          //  public void run()
            //{
                FenLogin login = new FenLogin();
                login.createComponents();
                //Connexion maconnexion = login.getConnexion();
                //login.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                //FenMenuu menu = new FenMenuu(maconnexion);
                
            //}
        //});
        
    }
    
}
