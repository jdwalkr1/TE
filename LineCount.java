import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LineCount extends JPanel {

    private JLabel lineCountLabel;
    private JTextArea textArea;

    //@param textArea to access area to count
    //method counts the members of the string
    public LineCount(JTextArea textArea) {
        this.textArea = textArea;

        lineCountLabel = new JLabel("Line Count: 0");

        // Adding components
        add(lineCountLabel);

        // Add document listener to JTextArea to update line count in real-time
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        // Updates the line counter
        updateLineCount();
    }

    //To JLabel
    private void updateLineCount() {
        int lineCount = textArea.getLineCount();
        lineCountLabel.setText("Line Count: " + lineCount);
    }

}
