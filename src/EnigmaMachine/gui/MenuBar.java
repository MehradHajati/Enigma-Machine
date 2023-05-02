package EnigmaMachine.gui;

import EnigmaMachine.ViewManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * The Menu on the Enigma-Machine Window
 * @author mhaja
 */
public final class MenuBar extends JMenuBar {
    
    private final ViewManager viewManager;
    private JMenu mainMenu, changeCipher;
    private JMenuItem about, exit, affine, atBash, caesar, matrix, railFence, vigenere, baconian, adfgvx;
    
    /** Makes the menu bar.
     * @param view the window that the menu bar will be placed on.
     */
    public MenuBar(ViewManager view) {
        super();
        this.viewManager = view;
        makeMenuItems();
        addMenuItems();
    }
    
    private void makeMenuItems() {
        MenuListener listener = new MenuListener();
        
        // Creating the menus
        mainMenu = new JMenu("Enigma-Machine");
        changeCipher = new JMenu("Change Cipher");
        
        // creating the buttons that will be placed in the menus
        about = makeMenuItem("About","Display information about EnignaMachine",listener);
        exit = makeMenuItem("Exit","Close EnigmaMachine Window",listener);
        affine = makeMenuItem("Affine Cipher", "Change the cipher being used to the Affine Cipher", listener);
        atBash = makeMenuItem("AtBash Cipher", "Change the cipher being used to the AtBash Cipher", listener);
        caesar = makeMenuItem("Caesar Cipher", "Change the cipher being used to the Caesar Cipher", listener);
        matrix = makeMenuItem("Matrix/Hill Cipher", "Change the cipher being used to the Matrix/Hill Cipher", listener);
        railFence = makeMenuItem("RailFence Cipher", "Change the cipher being used to the RailFence Cipher", listener);
        vigenere = makeMenuItem("Vigenere Cipher", "Change the cipher being used to the Vigenere Cipher", listener);
        baconian = makeMenuItem("Baconian Cipher", "Change the cipher being used to the Baconian Cipher", listener);
        adfgvx = makeMenuItem("ADFGVX Cipher", "Change the cipher being used to the ADFGVX Cipher", listener);
    }
    
    private JMenuItem makeMenuItem(String text, String tip, ActionListener al) {
        JMenuItem mi = new JMenuItem(text);
        mi.setToolTipText(tip);
        mi.addActionListener(al);
        return mi;
    }
    
    private void addMenuItems() {
        
        // remove all previously added items
        this.removeAll();
        
        // Mainmenu
        this.add(mainMenu);
        // adding the about and exit menu
        mainMenu.add(about);
        mainMenu.add(exit);
        
        // change cipher menu tab
        this.add(changeCipher);
        changeCipher.add(affine);
        changeCipher.add(atBash);
        changeCipher.add(caesar);
        changeCipher.add(matrix);
        changeCipher.add(railFence);
        changeCipher.add(vigenere);
        changeCipher.add(baconian);
        changeCipher.add(adfgvx);
        
    }
    
    /** Action listener for menu items. */
    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Object src = event.getSource();
            if (src==null) { return; }
            if (src == exit) { viewManager.exit(); }
            else if (src == about) { viewManager.about(); }
            else if(src == affine) {viewManager.changeCipher(viewManager.AFFINE); }
            else if(src == atBash) {viewManager.changeCipher(viewManager.ATBASH); }
            else if(src == caesar) {viewManager.changeCipher(viewManager.CAESAR); }
            else if(src == matrix) {viewManager.changeCipher(viewManager.MATRIX); }
            else if(src == railFence) {viewManager.changeCipher(viewManager.RAILFENCE); }
            else if(src == vigenere) {viewManager.changeCipher(viewManager.VIGENERE); }
            else if(src == baconian) {viewManager.changeCipher(viewManager.BACONIAN); }
            else if(src == adfgvx) {viewManager.changeCipher(viewManager.ADFGVX); }
        }
    }
    
}