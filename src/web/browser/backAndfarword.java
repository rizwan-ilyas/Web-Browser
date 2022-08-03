/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Rizwan
 */
public class backAndfarword implements ActionListener{

    GUIcollection refg;
    Stack<String> back,farword;

    public backAndfarword(GUIcollection g) {
        refg=g;
        back=new Stack<>();
        farword=new Stack<>();
    }
    
    void loadPage(String address){
        try {
                URL url=new URL(address);
                
                if(address.equals(refg.searchbar.getText())){
                    loadPage(back.pop());
                }
                else{
                
                try {
                    refg.searchbar.setText(address);
                    refg.sitePane.setContentType("text/html");
                    refg.sitePane.setPage(url);
                
                } catch (IOException ex) {
                    Logger.getLogger(GUIcollection.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(listener.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("farward")){
            System.out.println("farward");
            System.out.println(farword);
            String temp=farword.pop();
            loadPage(temp);
            back.push(temp);
            refg.back.setEnabled(true);
            if(farword.isEmpty()){
                refg.farward.setEnabled(false);
            }else{
                refg.farward.setEnabled(true);
            }
            
            System.out.println(farword);
        }
        else if(ae.getActionCommand().equals("back")){
            System.out.println("back");
            String temp=back.pop();
            loadPage(temp);
            farword.push(temp);
            refg.farward.setEnabled(true);
            if(back.isEmpty()){
                refg.back.setEnabled(false);
            }else{
                refg.back.setEnabled(true);
            }
            
            System.out.println(back);
                      
        }
    
    }
    

}
