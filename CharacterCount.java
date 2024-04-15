import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CharacterCount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel charCountLabel;
    private JTextArea textArea;

    public CharacterCount(JTextArea textArea) {
        this.textArea = textArea;

        charCountLabel = new JLabel("Character Count: 0");

        // Set Layout to null
        setLayout(null);

        // Adding components
        charCountLabel.setBounds(20, 20, 200, 20);

        add(charCountLabel);

        // Set size and visibility
        setSize(250, 80);
        setLocationRelativeTo(textArea);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add document listener to JTextArea to update character and word count
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCounts();
            }
        });

        // Update counts initially
        updateCounts();
    }

    // Method to update the character and word count labels
    private void updateCounts() {
        String text = textArea.getText();
        // Remove whitespace from the text
        String trimmedText = text.replaceAll("\\s", "");
        int charCount = trimmedText.length();
        charCountLabel.setText("Character Count: " + charCount);
    }
}