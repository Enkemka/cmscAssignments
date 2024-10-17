
/*
 * Class: CMSC203 
 * Instructor:
 * Description: (encyption and decryption program)
 * Due: 10/16/2024
 * Platform/compiler:eclipse ide
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Essemooo Nkemka
*/




package application;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class FXMainPane extends BorderPane { // Extend BorderPane (or any layout of your choice)
    
    public FXMainPane() {
        // Create a label and add it to the center of the BorderPane
        Label label = new Label("Welcome to the Cybersecurity Encryption and Decryption App!");
        this.setCenter(label); // Place the label in the center of the BorderPane
        
        
     // Create RadioButtons for Caesar Cipher and Bellaso Cipher
        RadioButton caesarCipher = new RadioButton("Caesar Cipher");
        RadioButton bellasoCipher = new RadioButton("Bellaso Cipher");

        // Add the RadioButtons to a ToggleGroup to allow only one to be selected
        ToggleGroup cipherGroup = new ToggleGroup();
        caesarCipher.setToggleGroup(cipherGroup);
        bellasoCipher.setToggleGroup(cipherGroup);
        
        HBox cipherOptions = new HBox(10, caesarCipher, bellasoCipher);
        cipherOptions.setAlignment(Pos.CENTER); // Center the options
        cipherOptions.setPadding(new Insets(10, 0, 10, 0)); // Add padding

        // Create a separator (line) underneath the cipher options
        Separator separator = new Separator();
        
        // Create a VBox to hold both the cipher options and the separato
        VBox topSection = new VBox(cipherOptions, separator);

        // Add the top section to the top of the BorderPan
        this.setTop(topSection);
        
        
        
        
        // Create the first label and TextField for "Enter plain-text string to encrypt"
        Label plainTextLabel = new Label("Enter plain-text string to encrypt:");
        TextField plainTextField = new TextField();
        plainTextField.setPromptText("Enter plain-text here");

        // Create the second label and TextField for "Encrypted string"
        Label encryptedStringLabel = new Label("Encrypted string:");
        TextField encryptedStringField = new TextField();
        encryptedStringField.setPromptText("Encrypted text will appear here");

        // Create the third label and TextField for "Decrypted string"
        Label decryptedStringLabel = new Label("Decrypted string:");
        TextField decryptedStringField = new TextField();
        decryptedStringField.setPromptText("Decrypted text will appear here");

        // Create the fourth label and TextField for "Cyber key"
        Label cyberKeyLabel = new Label("Cyber key - Enter a string for cipher:");
        TextField cyberKeyField = new TextField();
        cyberKeyField.setPromptText("Enter cipher key here");

        // Add all labels and text fields to a VBox
        VBox inputSection = new VBox(10, plainTextLabel, plainTextField, 
                                         encryptedStringLabel, encryptedStringField, 
                                         decryptedStringLabel, decryptedStringField, 
                                         cyberKeyLabel, cyberKeyField);
        inputSection.setAlignment(Pos.CENTER); // Center everything
        inputSection.setPadding(new Insets(15)); // Add padding

        // Add the VBox to the center of the BorderPane
        this.setCenter(inputSection);
        
        Button encryptButton = new Button("Encrypt a String");
        Button decryptButton = new Button("Decrypt a String");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("Exit");

        // Add the buttons to an HBox for horizontal alignment
        HBox buttonSection = new HBox(10, encryptButton, decryptButton, clearButton, exitButton);
        buttonSection.setAlignment(Pos.CENTER); // Center the buttons
        buttonSection.setPadding(new Insets(10)); // Add padding around the button section

        // Add the input section to the center and the button section to the bottom of the BorderPane
        this.setCenter(inputSection);
        this.setBottom(buttonSection);
        
        
     // Add listener to the ToggleGroup
        cipherGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (cipherGroup.getSelectedToggle() != null) {
                // Check which radio button is selected
                if (caesarCipher.isSelected()) {
                    // Perform Caesar Cipher action
                    System.out.println("Caesar Cipher selected. Perform Caesar Cipher action.");
                    cyberKeyLabel.setText("Cyber key - Enter a string for Caesar cipher:");
                    
                    
                    
                    // Add your Caesar Cipher logic here
                } else if (bellasoCipher.isSelected()) {
                    // Perform Bellaso Cipher action
                    System.out.println("Bellaso Cipher selected. Perform Bellaso Cipher action.");
                    cyberKeyLabel.setText("Cyber key - Enter a string for Bellaso cipher:"); 
                    // Add your Bellaso Cipher logic here
                }
            }
        });

        
        encryptButton.setOnAction(event -> {
            // Check if any toggle is selected
            if (cipherGroup.getSelectedToggle() != null) {
            	String plainText = plainTextField.getText();
                String keyText = cyberKeyField.getText();
                int key;
                if (caesarCipher.isSelected()) {
                	
                        // Get input values from TextFields
                        

                        // Validate if the key is a valid integer using if-else
                        if (keyText.matches("\\d+")) { // Check if keyText contains only digits
                            key = Integer.parseInt(keyText); // Convert to integer if valid
                        } else {
                            System.out.println("Invalid key. Please enter a valid integer.");
                            return; // Exit if the key is invalid
                        }

                        // Check if the plainText is within bounds using isStringInBounds
                        if (CryptoManager.isStringInBounds(plainText)) {
                            // Encrypt the string using caesarEncryption
                            String encryptedText = CryptoManager.caesarEncryption(plainText, key);
                            encryptedStringField.setText(encryptedText); // Set encrypted text

                            // Optionally, decrypt the encrypted string and display it in the decryptedStringField
                            String decryptedText = CryptoManager.caesarDecryption(encryptedText, key);
                            decryptedStringField.setText(decryptedText); // Set decrypted text
                        } 
                        
                        else {
                            // Handle if the string is out of bounds
                            System.out.println("String is out of bounds. Please enter valid characters.");
                        }
                	
                    // Action for Caesar Cipher encryption
                    
                    // Add Caesar Cipher encryption logic here
                } else if (bellasoCipher.isSelected()) {
                	
                	
                	
                	// Get input values from TextFields
                	
                	String bellasoKeyText = cyberKeyField.getText(); // This is now the string key for Bellaso Cipher

                	// Validate if the Bellaso key is not empty
                	if (!bellasoKeyText.isEmpty()) {
                	    // Check if the plainText is within bounds using isStringInBounds
                	    if (CryptoManager.isStringInBounds(plainText)) {
                	        // Encrypt the string using bellasoEncryption
                	        String encryptedText = CryptoManager.bellasoEncryption(plainText, bellasoKeyText);
                	        encryptedStringField.setText(encryptedText); // Set encrypted text

                	        // Optionally, decrypt the encrypted string and display it in the decryptedStringField
                	        String decryptedText = CryptoManager.bellasoDecryption(encryptedText, bellasoKeyText);
                	        decryptedStringField.setText(decryptedText); // Set decrypted text
                	    } else {
                	        // Handle if the string is out of bounds
                	        System.out.println("String is out of bounds. Please enter valid characters.");
                	    }
                	} else {
                	    System.out.println("Invalid Bellaso key. Please enter a valid string.");
                	}
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                    // Action for Bellaso Cipher encryption
                    System.out.println("Bellaso Cipher is selected. Perform Bellaso Cipher encryption.");
                    // Add Bellaso Cipher encryption logic here
                }
            } else {
                // If no cipher is selected, do something (optional)
                System.out.println("No cipher selected. Please select a cipher.");
            }
        });  
        
        
        
        
       

        decryptButton.setOnAction(event -> {
            // Check if any toggle is selected
            if (cipherGroup.getSelectedToggle() != null) {
                String encryptedText = encryptedStringField.getText();  // Get the encrypted text
                
                if (caesarCipher.isSelected()) {
                    // Caesar Cipher is selected
                    System.out.println("Caesar Cipher is selected. Perform Caesar Cipher decryption.");

                    // Get the key for Caesar Cipher
                    String keyText = cyberKeyField.getText();
                    int key;

                    // Validate if the key is a valid integer
                    if (keyText.matches("\\d+")) {
                        key = Integer.parseInt(keyText); // Convert to integer
                    } else {
                        System.out.println("Invalid key. Please enter a valid integer.");
                        return;
                    }

                    // Decrypt the string using caesarDecryption
                    String decryptedText = CryptoManager.caesarDecryption(encryptedText, key);
                    decryptedStringField.setText(decryptedText); // Set decrypted text

                } else if (bellasoCipher.isSelected()) {
                    // Bellaso Cipher is selected
                    System.out.println("Bellaso Cipher is selected. Perform Bellaso Cipher decryption.");

                    // Get the Bellaso key
                    String bellasoKey = cyberKeyField.getText();

                    // Validate if the Bellaso key is not empty
                    if (!bellasoKey.isEmpty()) {
                        // Decrypt the string using bellasoDecryption
                        String decryptedText = CryptoManager.bellasoDecryption(encryptedText, bellasoKey);
                        decryptedStringField.setText(decryptedText); // Set decrypted text
                    } else {
                        System.out.println("Invalid Bellaso key. Please enter a valid string.");
                    }
                }
            } else {
                // No cipher selected
                System.out.println("No cipher selected. Please select a cipher.");
            }
        });

        
        
        
     // Clear button functionality
        clearButton.setOnAction(event -> {
            // Clear all the text fields
            plainTextField.clear();
            encryptedStringField.clear();
            decryptedStringField.clear();
            cyberKeyField.clear();
        });

        
        exitButton.setOnAction(event -> {
            // Exit the application
            System.exit(0);
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
    }
}
