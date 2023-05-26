package EnigmaMachine.gui;

import EnigmaMachine.ViewManager;
import EnigmaMachine.EnigmaMachine;
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
public class AffinePanel extends JPanel{
    
    private final ViewManager viewManager;
    private final GridBagConstraints constraints;
    
    private JLabel cipherName, cipherIntro, enterFirstKey, enterSecondKey, enterText, output;
    private JTextField firstKey, secondKey, input;
    private JButton encryptButton, decryptButton;
    
    public AffinePanel(ViewManager view){
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
        cipherName = new JLabel("Affine Cipher");
        // changing the font, style, and size of the title
        cipherName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        // underlining the title
        Font font = cipherName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cipherName.setFont(font.deriveFont(attributes));
        
        //Creating the label which will explain how the cipher works and changing its font
        cipherIntro = new JLabel("<html>Assume each letter in the alphabet is numbered from 0-25.<br> ");
                //+ "In the Affine cipher, using two integers keys A and B, the text is encrypted by multiplying each letter's corresponding number by A and then adding B to the results. The results is then modded by 26 and converted back into a letter.<html>");
        cipherIntro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the label that will tell the user to type in their cipher or plain text and changing its font
        enterText = new JLabel("Enter your Ciphertext or Plaintext:");
        enterText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the text field that the user will type in their cipher of plain text
        input = new JTextField(20);
        input.addKeyListener(new KeyAdapter(){});
        
        //creating the label that will tell the user to type in their key and changing its font
        enterFirstKey = new JLabel("Enter your first key A, which should be coprime with 26 or decryption will not be correct:");
        enterFirstKey.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the text field that the user will tyep in their key into
        firstKey = new JTextField(10);
        firstKey.addKeyListener(new KeyAdapter(){});
        
        //creating the label that will tell the user to type in their key and changing its font
        enterSecondKey = new JLabel("Enter your second key B:");
        enterSecondKey.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        
        // creating the text field that the user will tyep in their key into
        secondKey = new JTextField(10);
        secondKey.addKeyListener(new KeyAdapter(){});
        
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
        
        // adding the enterFirstKey label to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(enterFirstKey, constraints);
        
        // adding the firstKey text field to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx=1;
        constraints.gridy=3;
        add(firstKey, constraints);
        
        // adding the enterSecondKey label to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(enterSecondKey, constraints);
        
        // adding the SecondKey text field to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx=1;
        constraints.gridy=4;
        add(secondKey, constraints);
        
        // adding the encryptButton to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=0;
        constraints.gridy=5;
        add(encryptButton, constraints);
        
        // adding the decryptButton to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=1;
        constraints.gridy=5;
        add(decryptButton, constraints);
        
        // adding the output label to the panel
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx=0;
        constraints.gridy=6;
        add(output, constraints);
    }
    
    /*
    Method to decrypt
    */
    private void decrypt(){
        if(checkFirstKey()){
            if(checkSecondKey()){
                if(checkInput()){
                    String answer = EnigmaMachine.decryptAffine(input.getText(), Integer.parseInt(firstKey.getText()), Integer.parseInt(secondKey.getText()));
                    output.setText(answer);
                }
                else{
                    Dialogs.error(viewManager, "The text you have entered is invalid, ensure it contains only the English alphabet", "Invalid Text");
                }
            }
            else{
                   Dialogs.error(viewManager, "The second key you have entered is invalid, ensure it is a number", "Invalid Second Key");     
            }
        }
        else{
            Dialogs.error(viewManager, "The first key you have entered is invalid, ensure it is a number", "Invalid First Key");
        }
    }
    
    /*
    Method to encrypt
    */
    private void encrypt(){
        if(checkFirstKey()){
            if(checkSecondKey()){
                if(checkInput()){
                    String answer = EnigmaMachine.encryptAffine(input.getText(), Integer.parseInt(firstKey.getText()), Integer.parseInt(secondKey.getText()));
                    output.setText(answer);
                }
                else{
                    Dialogs.error(viewManager, "The text you have entered is invalid, ensure it contains only the English alphabet", "Invalid Text");
                }
            }
            else{
                   Dialogs.error(viewManager, "The second key you have entered is invalid, ensure it is a number", "Invalid Second Key");     
            }
        }
        else{
            Dialogs.error(viewManager, "The first key you have entered is invalid, ensure it is a number", "Invalid First Key");
        }
    }
    
    /*
    Method to check whether first key is valid
    */
    private boolean checkFirstKey(){
        String value = firstKey.getText();
        if(value == null){
            return false;
        }
        if(!value.matches("[0-9]+")){
            return false;
        }
        return true;
    }
    
    /*
    Method to check whether second key is valid
    */
    private boolean checkSecondKey(){
        String value = secondKey.getText();
        if(value == null){
            return false;
        }
        if(!value.matches("[0-9]+")){
            return false;
        }
        return true;
    }
    
    /*
    Method to check whether input is valid
    */
    private boolean checkInput(){
        String text = input.getText();
        if(text == null){
            return false;
        }
        if(!text.matches("[a-zA-Z]+")){
            return false;
        }
        return true;
    }
}
