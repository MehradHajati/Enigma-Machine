package EnigmaMachine;

import EnigmaMachine.gui.MenuBar;
import EnigmaMachine.gui.AffinePanel;
import EnigmaMachine.gui.AtBashPanel;
import EnigmaMachine.gui.CaesarPanel;
import EnigmaMachine.gui.MatrixPanel;
import EnigmaMachine.gui.RailFencePanel;
import EnigmaMachine.gui.VigenerePanel;
import EnigmaMachine.gui.BaconianPanel;
import EnigmaMachine.gui.JFrameExit;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * 
 * @author Mehrad Hajati
 * This class will act as both the ViewManager and the controller in the MVC structure
 */
public class ViewManager extends JFrameExit{

    public final int AFFINE = 1;
    public final int ATBASH = 2;
    public final int CAESAR = 3;
    public final int MATRIX = 4;
    public final int RAILFENCE = 5;
    public final int VIGENERE = 6;
    public final int BACONIAN = 7;
    
    private final EnigmaMachine model;
    private int currentCipher = AFFINE;
    
    private MenuBar menu;
    private AffinePanel affinePanel;
    private AtBashPanel atbashPanel;
    private CaesarPanel caesarPanel;
    private MatrixPanel matrixPanel;
    private RailFencePanel railPanel;
    private VigenerePanel vigenerePanel;
    private BaconianPanel baconianPanel;
            
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
        
        baconianPanel = new BaconianPanel(this);
        baconianPanel.setBorder(BorderFactory.createEtchedBorder());
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
                break;
                
            case ATBASH:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(atbashPanel);
                break;
                
            case CAESAR:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(caesarPanel);
                break;
                
            case MATRIX:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(matrixPanel);
                break;
                
            case RAILFENCE:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(railPanel);
                break;
            
            case VIGENERE:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(vigenerePanel);
                break;
                
            case BACONIAN:
                contentPane.setLayout(new GridLayout(1,1));
                contentPane.add(baconianPanel);
                break;
        }
        
        // Have to refresh or else the changes don't show up immediately.
        contentPane.validate();
        contentPane.setVisible(true);
        contentPane.repaint();
                
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