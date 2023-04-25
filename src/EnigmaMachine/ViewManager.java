package EnigmaMachine;

import EnigmaMachine.gui.MenuBar;
import EnigmaMachine.EnigmaMachine;
import EnigmaMachine.gui.AffinePanel;
import EnigmaMachine.gui.AtBashPanel;
import EnigmaMachine.gui.CaesarPanel;
import EnigmaMachine.gui.MatrixPanel;
import EnigmaMachine.gui.RailFencePanel;
import EnigmaMachine.gui.VigenerePanel;
import gui.JFrameExit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Mehrad Hajati
 * This class will act as both the ViewManager and the controller in the MVC structure
 */
public class ViewManager extends JFrameExit implements ActionListener {

    public final int AFFINE = 1;
    public final int ATBASH = 2;
    public final int CAESAR = 3;
    public final int MATRIX = 4;
    public final int RAILFENCE = 5;
    public final int VIGENERE = 6;
    
    private final EnigmaMachine model;
    private int currentCipher = AFFINE;
    
    private MenuBar menu;
    private AffinePanel affinePanel;
    private AtBashPanel atbashPanel;
    private CaesarPanel caesarPanel;
    private MatrixPanel matrixPanel;
    private RailFencePanel railPanel;
    private VigenerePanel vigenerePanel;
            
    public ViewManager(){
        // Create the window with a title
        super("EnigmaMachine by Mehrad Hajati", "EnigmaMachine");
        // Display the about information
        about();
        model = new EnigmaMachine(this);
        // Make and add objects
        makeObjects();
        addObjects();
        // Resize the window to some percentage of the screen size and centre the window on the screen:
        resizeAndCentre();
        // Make the window visible:
        setVisible(true);
        requestFocusInWindow();
        
        
    }

    private void makeObjects(){
        menu = new MenuBar(this);
        
        affinePanel = new AffinePanel(this);
        affinePanel.setBorder(BorderFactory.createEtchedBorder());
        
        atbashPanel = new AtBashPanel(this);
        atbashPanel.setBorder(BorderFactory.createEtchedBorder());
        
        caesarPanel = new CaesarPanel(this);
        caesarPanel.setBorder(BorderFactory.createEtchedBorder());
        
        matrixPanel = new MatrixPanel(this);
        matrixPanel.setBorder(BorderFactory.createEtchedBorder());
        
        railPanel = new RailFencePanel(this);
        railPanel.setBorder(BorderFactory.createEtchedBorder());
        
        vigenerePanel = new VigenerePanel(this);
        vigenerePanel.setBorder(BorderFactory.createEtchedBorder());
        
    }
    
    private void addObjects(){
        // Put on the menu:
        setJMenuBar(menu);
        
        // Get the content pane:
        Container contentPane = getContentPane();
        contentPane.removeAll();
        switch(currentCipher){
            
            case AFFINE:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(affinePanel);
                affinePanel.revalidate();
                break;
                
            case ATBASH:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(atbashPanel);
                atbashPanel.revalidate();
                break;
                
            case CAESAR:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(caesarPanel);
                caesarPanel.revalidate();
                break;
                
            case MATRIX:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(matrixPanel);
                matrixPanel.revalidate();
                break;
                
            case RAILFENCE:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(railPanel);
                railPanel.revalidate();
                break;
            
            case VIGENERE:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(vigenerePanel);
                vigenerePanel.revalidate();
                break;
        }
                
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }

    
    public void changeCipher(int num){
        currentCipher = num;
        addObjects();
    }
    
    private void resizeAndCentre() {
        // Resize the window to some percentage of the screen size:
        Dimension dim = getToolkit().getScreenSize();
        //setSize( win.width , (int)(0.75*win.height) );
        setSize((int)(0.75*dim.width) , (int)(0.50*dim.height) );
        // Centre the window on the screen:
        Dimension siz = this.getSize();
        setLocation((int)((dim.width  - siz.width )*0.5),
                (int)((dim.height - siz.height)*0.5));
    }
    
    public static void main(String[] args){
        ViewManager vm = new ViewManager();
    }
}