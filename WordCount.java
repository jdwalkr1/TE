import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel wordCountLabel;
    private JTextArea textArea;

    public WordCount(JTextArea textArea) {
        this.textArea = textArea;

        wordCountLabel = new JLabel("Word Count: 0");
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        // Set Layout to null
        setLayout(null);

        // Adding components
        wordCountLabel.setBounds(10, 10, 150, 20);
        countButton.setBounds(170, 10, 120, 20);

        add(wordCountLabel);
        add(countButton);

        // Set size and visibility
        setSize(300, 80);
        setLocationRelativeTo(textArea);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Method to update the word count label
    private void updateWordCount() {
        String text = textArea.getText();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length;
        wordCountLabel.setText("Word Count: " + wordCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateWordCount();
    }
}