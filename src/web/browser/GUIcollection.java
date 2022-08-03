/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.browser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Rizwan
 */
public class GUIcollection {

    JFrame frame;
    JButton back,farward,home,gobtn,refresh,favourite,f_home;
    JEditorPane homePage;
    JPanel actionPanel,middlePanel,sitePanel;
    JTextField searchbar,hometxt,siteSearch;
    JMenu menu,historyMenu,fav;
    JMenuBar menuBar;
    JMenuItem sethome;
    
    JEditorPane sitePane;
    JScrollPane jscroll;
    backAndfarword bf;
    historymanager hm;
    hyperlink hl;
    homeListener homeli;
    historymanager his;
    favouriteManager fav_lis;
    listener lis;
    
    
    public GUIcollection() throws MalformedURLException, IOException {
        init();
    }

    public void init() throws MalformedURLException, IOException {
        frame=new JFrame("Browser");
        GridBagLayout gridBagLayout=new GridBagLayout();
        frame.setLayout(gridBagLayout);
        GridBagConstraints c=new GridBagConstraints();
        
        lis=new listener(this);
        
        bf=new backAndfarword(this);
        hm=new historymanager(this);
        hl=new hyperlink(this);
        homeli=new homeListener(this);
        his=new historymanager(this);
        fav_lis=new favouriteManager(this);
        
        siteSearch=new JTextField(10);
        //siteSearch.setPreferredSize(new Dimension(25, 20));
        
        
        actionPanel=new JPanel();
        actionPanel.setLayout(new GridBagLayout());
        //actionPanel.setSize(20 , 600);
        actionPanel.setBackground(Color.WHITE);
        //"#EEEEEE"
        
        middlePanel=new JPanel();
        
        //middlePanel.setSize(20, 600);
        middlePanel.setBackground(Color.decode("0x00FFFFFF"));
        //siteSearch.setLocation(100, 10);
        searchInsite srIn=new searchInsite(this);
        JButton bt=new JButton("Search");
        bt.addActionListener(srIn);
        
        middlePanel.add(siteSearch);
        middlePanel.add(bt);
        
        
        
        sitePanel=new JPanel();
        //sitePanel.setSize(new Dimension(10, 600));
        sitePanel.setBackground(Color.white);
        
        back=new JButton();
        farward=new JButton();
        home=new JButton();
        searchbar=new JTextField(45);
        hometxt=new JTextField(25);
        gobtn=new JButton();
        refresh=new JButton();
        favourite=new JButton();
        f_home=new JButton("Set home");
       
        menu=new JMenu();
        menuBar=new JMenuBar();
        
        historyMenu=new JMenu("GetHistory");
        
        
        fav=new JMenu("Favourite");
        sethome=new JMenuItem("SetHome");
        
        
        
        sitePane=new JEditorPane();
        //sitePane.setPage(new URL("https://wwww.google.com"));
        sitePane.addHyperlinkListener(hl);
        sitePane.setEditable(false);
        sitePane.setSize(300, 300);
        sitePane.setContentType("text/html");
        
        jscroll=new JScrollPane(sitePane);
        jscroll.setPreferredSize(new Dimension(870, 540));
        jscroll.setBackground(Color.yellow);
        jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        GridBagConstraints btnc=new GridBagConstraints();
        
        back.setIcon(new ImageIcon(this.getClass().getResource("icons/back1.png")));
        back.setActionCommand("back");
        back.addActionListener(bf);
        back.setEnabled(false);
        back.setSize(20,20);
        back.setBackground(Color.decode("0x00FFFFFF"));
        back.setBorder(null);
        btnc.gridx=0;
        btnc.gridy=0;
        actionPanel.add(back,btnc);
        
        farward.setIcon(new ImageIcon(this.getClass().getResource("icons/farward1.png")));
        farward.setActionCommand("farward");
        farward.addActionListener(bf);
        farward.setEnabled(false);
        farward.setSize(20,20);
        farward.setBackground(Color.decode("0x00FFFFFF"));
        farward.setBorder(null);
        btnc.gridx=1;
        btnc.gridy=0;
        btnc.insets = new Insets(0,15,0,0);
        //btnc.gridwidth=10;
        //btnc.fill=GridBagConstraints.HORIZONTAL;
        actionPanel.add(farward,btnc);
        
        home.setIcon(new ImageIcon(this.getClass().getResource("icons/home1.png")));
        home.setPreferredSize(new Dimension(30, 30));
        homeli.loadHome();
        home.addActionListener(homeli);

        home.setActionCommand("home");
        home.setBackground(Color.decode("0x00FFFFFF"));
        home.setBorder(null);
        btnc.gridx=2;
        btnc.gridy=0;
        btnc.insets=new Insets(0, 15, 0, 10);
        actionPanel.add(home,btnc);
        
        
        searchbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //searchbar.setActionCommand("search");
        searchbar.setPreferredSize(new Dimension(60, 33));
        //searchbar.setOpaque(false);
        btnc.gridx=3;
        btnc.gridy=0;
        btnc.insets = new Insets(0,5,0,0);
        //btnc.gridwidth=10;
        //btnc.fill=GridBagConstraints.HORIZONTAL;
        actionPanel.add(searchbar,btnc);
        
        gobtn.setIcon(new ImageIcon(this.getClass().getResource("icons/webgo1.png")));
        gobtn.setActionCommand("gobtn");
        gobtn.addActionListener(lis);
        
        gobtn.setPreferredSize(new Dimension(25, 33));
        gobtn.setBackground(Color.decode("0x00FFFFFF"));
        btnc.gridx=4;
        btnc.gridy=0;
        btnc.insets = new Insets(0,0,0,0);
        actionPanel.add(gobtn,btnc);
        
        refresh.setIcon(new ImageIcon(this.getClass().getResource("icons/refresh1.png")));
        refresh.setActionCommand("refresh");
        refresh.addActionListener(lis);
        //refresh.setPreferredSize(new Dimension(20, 25));
        refresh.setBackground(Color.decode("0x00FFFFFF"));
        refresh.setBorder(null);
        btnc.gridx=5;
        btnc.gridy=0;
        btnc.insets = new Insets(0,15,0,0);
        //btnc.gridwidth=3;
        //btnc.fill=GridBagConstraints.HORIZONTAL;
        actionPanel.add(refresh,btnc);
        
        favourite.setIcon(new ImageIcon(this.getClass().getResource("icons/favourite1.png")));
        favourite.setActionCommand("favourite");
        favourite.addActionListener(fav_lis);
        //favourite.setPreferredSize(new Dimension(25, 35));
        favourite.setBackground(Color.decode("0x00FFFFFF"));
        favourite.setBorder(null);
        btnc.gridx=6;
        btnc.gridy=0;
        btnc.insets=new Insets(0, 10, 0, 0);
        actionPanel.add(favourite);
        
        f_home.addActionListener(homeli);
        f_home.setActionCommand("f_home");
        
        menu.setIcon(new ImageIcon(this.getClass().getResource("icons/menu11.png")));
        menu.setBackground(Color.decode("0x00FFFFFF"));
        menuBar.setBackground(Color.decode("0x00FFFFFF"));
        menu.setPreferredSize(new Dimension(30, 30));
        
        sethome.addActionListener(homeli);
        menu.add(sethome);
        menu.add(fav);
        File file=new File("history.txt");
        File fav_file=new File("favourite.txt");
        try {
              Scanner reader=new Scanner(file);
              Scanner fav_reader=new Scanner(fav_file);
              while(reader.hasNextLine()){
                  String data=reader.nextLine();
                  JMenuItem temp=new JMenuItem(data);
                  temp.setActionCommand(data);
                  temp.addActionListener(his);
                  historyMenu.add(temp);
              }
              
              while(fav_reader.hasNextLine()){
                  String data=fav_reader.nextLine();
                  JMenuItem temp=new JMenuItem(data);
                  temp.setActionCommand(data);
                  temp.addActionListener(fav_lis);
                  fav.add(temp);
              }
              
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(historymanager.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        //historyMenu.addActionListener(his);
        menu.add(historyMenu);
        //sethome.add(hometxt);
            //sethome.add(f_home);
            
            

        //menu.add(sethome);
        menuBar.add(menu);
        btnc.gridx=7;
        btnc.gridy=0;
        actionPanel.add(menuBar,btnc);
        
        
        
        
        //jscroll.add(sitePane);
        sitePanel.add(jscroll,BorderLayout.CENTER);
        
        //String url="https://www.google.com/";
        //java.net.URL helpURL = TextSamplerDemo.class.getResource(url);
        
        
        
        
        gridBagLayout.columnWeights=new double[] {1};
        gridBagLayout.rowWeights=new double[] {0.05,0.03,1};
        c.fill=GridBagConstraints.BOTH;
        
        
        //c.fill=GridBagConstraints.VERTICAL;
        c.gridx=0;
        c.gridy=0;
        frame.add(actionPanel,c);
        
        c.gridx=0;
        c.gridy=1;
       
        frame.add(middlePanel,c);
        c.gridx=0;
        c.gridy=2;
        c.gridheight=1;
        frame.add(sitePanel,c);
        //frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(900,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
   
    
    
    
    
    
}
