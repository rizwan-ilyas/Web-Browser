/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Muhammad Rizwan
 */
public class hyperlink implements HyperlinkListener{
    GUIcollection refg;

    public hyperlink(GUIcollection g) {
        refg=g;
        
    }
    
     void loadPage(String url){
       
                try {
                    refg.searchbar.setText(url);
                    refg.sitePane.setContentType("text/html");
                    refg.sitePane.setPage(url);
                    refg.bf.back.push(url);
                } catch (IOException ex) {
                    Logger.getLogger(GUIcollection.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
    } 
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent he) {
        if(he.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
            loadPage(he.getURL().toString());
            try {
                refg.lis.loadhistory();
            } catch (IOException ex) {
                Logger.getLogger(hyperlink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    
    }
    
}
