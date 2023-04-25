package EnigmaMachine.gui;

import EnigmaMachine.ViewManager;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mehrad Hajati
 */
public class CaesarPanel extends JPanel{
    
    private ViewManager viewManager;
    private JLabel cipherName, cipherIntro, enterKey;
    private JTextField key;
    private GridBagConstraints constraints;
    
    public CaesarPanel(ViewManager view){
        viewManager = view;
        // here we are setting the layout manager
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        // here we are creating the objects and adding them using the layout manager
        makeObjects();
        addObjects();
    }
    
    private void makeObjects(){
        
        // creating the cipherName or title of the panel
        cipherName = new JLabel("Caesar Cipher");
        // changing the font, style, and size of the title
        cipherName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        // underlining the title
        Font font = cipherName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cipherName.setFont(font.deriveFont(attributes));
        
        cipherIntro = new JLabel("<html>Assume each letter in the alphabet is numbered from 0-25.<br> "
                + "In the Ceasar Cipher, using one integer keys A, the data is encrypted by shifting the letters by A in the alphabet and then modding by 26.<html>");
        cipherIntro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        enterKey = new JLabel("Enter your key:");
        enterKey.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        key = new JTextField(10);
        key.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = key.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    key.setEditable(true);
                } 
                else{
                    key.setEditable(false);
                }
            }
        });
        
    }
    
    private void addObjects(){
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(cipherName, constraints);
        
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(cipherIntro, constraints);
        
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(enterKey, constraints);
        
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx=1;
        constraints.gridy=2;
        add(key, constraints);
        
    }
    
}
