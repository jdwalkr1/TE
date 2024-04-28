import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class WordCount extends JPanel {

    private JLabel wordCountLabel;
    private JTextArea textArea;
    //@param takes textArea to iterate through UI text
    //returns strings not seperated by spaces
    public WordCount(JTextArea textArea) {
        this.textArea = textArea;

        wordCountLabel = new JLabel("Word Count: 0");

        // Adding components
        add(wordCountLabel);

        // Add document listener to update word count in real-time
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        // Initial word count update
        updateWordCount();
    }

    // Method to update the word count label
    private void updateWordCount() {
        String text = textArea.getText();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length;
        wordCountLabel.setText("Word Count: " + wordCount);
    }
}