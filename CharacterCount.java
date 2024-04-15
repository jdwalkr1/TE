import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CharacterCount extends JPanel {

    private JLabel charCountLabel;
    private JTextArea textArea;

    public CharacterCount(JTextArea textArea) {
        this.textArea = textArea;

        charCountLabel = new JLabel("Character Count: 0");

        // Adding components
        add(charCountLabel);

        // Add document listener to JTextArea to update character count in real-time
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        // Update character count initially
        updateCharacterCount();
    }

    // Method to update the character count label
    private void updateCharacterCount() {
        String text = textArea.getText();
        int charCount = text.length();
        charCountLabel.setText("Character Count: " + charCount);
    }
}