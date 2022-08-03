/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Rizwan
 */
public class historymanager implements ActionListener{
    GUIcollection refg;
    File file;
    public historymanager(GUIcollection g) {
        refg=g;
        file=new File("history.txt");
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
             refg.lis.loadPage(getUrl(ae.getActionCommand()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(historymanager.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    String getUrl(String rawURL) throws MalformedURLException{
        String str[]=rawURL.split("-");
        return str[0];
    }
   
    
 
}
