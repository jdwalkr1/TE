import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class WordCount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel wordCountLabel;
    private JTextArea textArea;

    public WordCount(JTextArea textArea) {
        this.textArea = textArea;

        wordCountLabel = new JLabel("Word Count: 0");

        // Set Layout to null
        setLayout(null);

        // Adding components
        wordCountLabel.setBounds(10, 10, 150, 20);

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

        // Set size and visibility
        setSize(200, 80);
        setLocationRelativeTo(textArea);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initial word count update
        updateWordCount();
    }

    // Method to update the word count label
    private void updateWordCount() {
        String text = textArea.getText();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length;
        wordCountLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        new WordCount(textArea);
    }
}