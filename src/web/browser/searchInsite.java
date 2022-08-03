/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Muhammad Rizwan
 */
public class searchInsite implements ActionListener{
    
    GUIcollection refg;

    public searchInsite(GUIcollection g) {
        refg=g;
    }

    int countSearch(String toSearch,String fromSearch){
        String str[]=fromSearch.split(toSearch);
        return str.length;

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) { 
       String sr=refg.siteSearch.getText();
       String pane=refg.sitePane.getText();
       
        System.out.println(countSearch(sr, pane));
       
       
       
    }
    
    
    
}
