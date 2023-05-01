package EnigmaMachine.gui;

import EnigmaMachine.EnigmaMachine;
import EnigmaMachine.ViewManager;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mehrad Hajati
 */
public class BaconianPanel extends JPanel{
    
    private final ViewManager viewManager;
    private final GridBagConstraints constraints;
    
    private JLabel cipherName, cipherIntro, enterText, output;
    private JTextField input;
    private JButton encryptButton, decryptButton;
    
    public BaconianPanel(ViewManager view){
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
        cipherName = new JLabel("Baconian Cipher");
        // changing the font, style, and size of the title
        cipherName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        // underlining the title
        Font font = cipherName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cipherName.setFont(font.deriveFont(attributes));
        
        //Creating the label which will explain how the cipher works and changing its font
        cipherIntro = new JLabel("<html>The Baconian cipher encrypts the English alphabet by transforming it into a 5-bit binary code. Meaning that A becomes 00001, B becomes 00010 and etc.<br> "
                + "However it has one extra twist where 0 is represented as \"A\" and 1 is represented as \"B\". This cipher requires no key and is an easy cipher to break, by looking at the frequency of occurences.<html>");
        cipherIntro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the label that will tell the user to type in their cipher or plain text and changing its font
        enterText = new JLabel("Enter your Ciphertext or Plaintext:");
        enterText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the text field that the user will type in their cipher of plain text
        input = new JTextField(20);
        input.addKeyListener(new KeyAdapter(){});
        
        //creating the encrypt button and adding its actionListener
        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                encrypt();
            }
        });
        
        //creating the decrypt button and adding its actionListener
        decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                decrypt();
            }
        });
        
        // creating the label which will show the user the output
        output = new JLabel("Your Output");
        output.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
               
        
    }
    
    private void addObjects(){
        // adding the cipherName to the panel, using constrains and the grid system it comes with
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(cipherName, constraints);
        
        // adding the cipher explaination or intro to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(cipherIntro, constraints);
        
        // addiong the enterText label to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(enterText, constraints);
        
        // adding the input text field to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(input, constraints);
        
        // adding the encryptButton to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=0;
        constraints.gridy=4;
        add(encryptButton, constraints);
        
        // adding the decryptButton to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=1;
        constraints.gridy=4;
        add(decryptButton, constraints);
        
        // adding the output label to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=0;
        constraints.gridy=5;
        add(output, constraints);
    }
    
    /*
    Method to decrypt
    */
    private void decrypt(){
            if(checkCipherText()){
                String answer = EnigmaMachine.decryptBaconian(input.getText());
                output.setText(answer);
            }
            else{
                Dialogs.error(viewManager, "The text you have entered is invalid, ensure it only contains the English alphabet", "Invalid Text");
            }
        }
    
    /*
    Method to encrypt
    */
    private void encrypt(){
            if(checkPlainText()){
                String answer = EnigmaMachine.encryptBaconian(input.getText());
                output.setText(answer);
            }
            else{
                Dialogs.error(viewManager, "The text you have entered is invalid, ensure it contains only the English alphabet", "Invalid Text");
            }
        }
    
    
    /*
    Method to check whether the plaintext is valid
    */
    private boolean checkPlainText(){
        String text = input.getText();
        if(text == null){
            return false;
        }
        if(!text.matches("[a-zA-Z]+")){
            return false;
        }
        return true;
    }
    
    /*
    Method to check whether the ciphertext is valid
    */
    private boolean checkCipherText(){
        String text = input.getText();
        if(text == null){
            return false;
        }
        if(!text.matches("[a-bA-B]+")){
            return false;
        }
        return true;
    }
}
