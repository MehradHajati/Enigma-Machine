package EnigmaMachine.gui;

import EnigmaMachine.ViewManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.text.NumberFormat;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;


/**
 *
 * @author Mehrad Hajati
 */
public class AffinePanel extends JPanel{
    
    private ViewManager viewManager;
    
    private JLabel cipherName, cipherIntro, firstIntLabel;
    private JTextField firstIntInput, secondIntInput;
    
    public AffinePanel(ViewManager view){
        viewManager = view;
        makeObjects();
        addObjects();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void makeObjects(){
        
        // creating the cipherName or title of the panel
        cipherName = new JLabel("Affine Cipher");
        // changing the font, style, and size of the title
        cipherName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        // underlining the title
        Font font = cipherName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cipherName.setFont(font.deriveFont(attributes));
        
        cipherIntro = new JLabel("<html>Assume each letter in the alphabet is numbered from 0-25.<br> "
                + "In the Affine, using two integer keys A, and B, the data is encrypted by multiplying each letter's corresponding number by A and then adding B to the result.<br> The result is then modded by 26 and converted into a letter.<html>");
        cipherIntro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        firstIntLabel = new JLabel("Enter the first encryption key (A):");
        
        firstIntInput = new JTextField(1);
        firstIntInput.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = firstIntInput.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    firstIntInput.setEditable(true);
                } 
                else{
                    firstIntInput.setEditable(false);
                }
            }
        });
        
        
        secondIntInput = new JTextField(1);
        secondIntInput.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = secondIntInput.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    secondIntInput.setEditable(true);
                } 
                else{
                    secondIntInput.setEditable(false);
                }
            }
        });
    }
           
        
    
    private void addObjects(){
        add(cipherName);
        add(cipherIntro);
        add(firstIntLabel);
        add(firstIntInput);
        add(secondIntInput);
    }
}
