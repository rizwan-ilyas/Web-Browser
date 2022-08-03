/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Muhammad Rizwan
 */
public class favouriteManager implements ActionListener{
    GUIcollection refg;
    File file;
    public favouriteManager(GUIcollection g) {
        refg=g;
        file=new File("favourite.txt");
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("favourite")){
            try {
                loadfav();
            } catch (IOException ex) {
                Logger.getLogger(favouriteManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            refg.lis.loadPage(ae.getActionCommand());
        }
        
    }
    
    
     void loadfav() throws IOException {
            try {
                FileWriter myWriter = new FileWriter(file,true);
                String temp=refg.searchbar.getText();
                myWriter.write(temp+"\n");
                JPanel p=new JPanel();
                refg.fav.add(new JMenuItem(temp));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
    
    
}
