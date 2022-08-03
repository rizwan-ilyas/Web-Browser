/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;

/**
 *
 * @author Muhammad Rizwan
 */
public class listener implements ActionListener{
    GUIcollection refg;
    URL url,pre_url,next_url;
    File file;
    DateTimeFormatter dateformate;

    public listener(GUIcollection g) {
        refg=g;
        file=new File("history.txt");
        dateformate=DateTimeFormatter.ofPattern("dd/MM/yy,HH:MM");
    }
    
    boolean loadPage(String address){
        try {
            boolean isResfreshed=false;
                
                url=new URL(address);
                try {
                    refg.searchbar.setText(address);
                    refg.sitePane.setContentType("text/html");
                    refg.sitePane.setPage(url);
                    if(isResfreshed==false){
                        refg.bf.back.push(address);
                        refg.back.setEnabled(true);
                    }
                    return true;
                
                } catch (IOException ex) {
                    Logger.getLogger(GUIcollection.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(listener.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        
    }
    
    void loadhistory() throws IOException {
            try {
                FileWriter myWriter = new FileWriter(file,true);
                String temp=refg.searchbar.getText()+"- "+dateformate.format(LocalDateTime.now());
                myWriter.write(temp+"\n");
                refg.historyMenu.add(new JMenuItem(temp));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
    
    
    
    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
       String command=ae.getActionCommand();
        if(command.equals("gobtn")){
            //System.out.println(refg.searchbar.getText());
            loadPage(refg.searchbar.getText());
           try {
               loadhistory();
               //System.out.println(url.);
           } catch (IOException ex) {
               Logger.getLogger(listener.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else if(command.equals("refresh")){
            loadPage(url.toString());
        }
        
    }
    
}
