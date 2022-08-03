/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Rizwan
 */
public class homeListener implements ActionListener{

    GUIcollection refg;
    String address;
    public homeListener(GUIcollection g) {
        refg=g;
       
    }
    
    void loadHome() throws FileNotFoundException{
        try {
                File myObj = new File("home.txt");
                Scanner myReader = new Scanner(myObj);
                address=myReader.nextLine();
                myReader.close();

                URL url=new URL(address);
                try {
                    
                    refg.searchbar.setText(address);
                    refg.sitePane.setContentType("text/html");
                    refg.sitePane.setPage(url);
                    
                    refg.bf.back.push(address);
                    refg.back.setEnabled(true);
                    
                
                } catch (IOException ex) {
                    Logger.getLogger(GUIcollection.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(listener.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("home")){
            try {
                loadHome();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(homeListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(ae.getActionCommand().equals("SetHome")){
            JFrame fr=new JFrame("Home");
            fr.setLayout(new FlowLayout());
            fr.setBackground(Color.BLACK);
            JTextField txt=new JTextField(25);
            JButton btn=new JButton("Enter");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(txt.getText().equals("")){
                        //do nothing
                    }
                    else{
                        try {
                            FileWriter myWriter = new FileWriter(new File("home.txt"),false);
                            if(refg.lis.loadPage(txt.getText())){
                               String temp=txt.getText();
                                myWriter.write(temp+"\n");
                                myWriter.close();
                                System.out.println("Successfully wrote to the file."); 
                                fr.dispatchEvent(new WindowEvent(fr, WindowEvent.WINDOW_CLOSING));
                            }else{
                                System.out.println("URL not set");
                            }
                            
                            } 
                        catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                    }
                        
                        
                        
                    }
                
                }
            });
            
            
            //fr.setPreferredSize(new Dimension(50, 50));
            fr.add(txt);
            fr.add(btn);
            fr.setVisible(true);
            //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setSize(350,100);
            fr.setLocationRelativeTo(refg.frame);
            System.out.println(txt.getText());
        }
        
    
    }
    
}
