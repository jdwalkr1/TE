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
        charCountLabel.setBounds(20, 20, 150, 20);

        add(charCountLabel);

        // Set size and visibility
        setSize(200, 80);
        setLocationRelativeTo(textArea);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add document listener to JTextArea to update character count
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
                updateCharacterCount();
            }
        });
    }

    // Method to update the character count label
    private void updateCharacterCount() {
        String text = textArea.getText();
        int charCount = text.length();
        charCountLabel.setText("Character Count: " + charCount);
    }
}