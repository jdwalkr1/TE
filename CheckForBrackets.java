import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.*;

public class CheckForBrackets extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;

    public CheckForBrackets(JTextArea textArea) {
        this.textArea = textArea;
        //setting the size and parameters for Bracket check
        setTitle("Bracket Checker");
        setSize(400, 70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(textArea);

        resultLabel = new JLabel();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateResult();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateResult();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateResult();
            }
        });
        //creating the panels and border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JLabel("Result: "), BorderLayout.WEST);
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
        updateResult();
    }
    //update with colored warnings

    private void updateResult() {
        String result = checkBalance();
        if (result.startsWith("Warning")) {
            resultLabel.setForeground(Color.RED);
        } else {
            resultLabel.setForeground(Color.GREEN);
        }
        resultLabel.setText("<html>" + result.replaceAll("\n", "<br/>") + "</html>"); // Replace newline with HTML line break
    }
    //the main method that uses a stack to implement the check
    public String checkBalance() {
        String expression = textArea.getText();
        Stack<Character> stack = new Stack<>();
        Set<Character> openingBrackets = new HashSet<>(Arrays.asList('(', '[', '{'));
        Set<Character> closingBrackets = new HashSet<>(Arrays.asList(')', ']', '}'));
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (openingBrackets.contains(ch)) {
                stack.push(ch);
            } else if (closingBrackets.contains(ch)) {
                if (stack.isEmpty() || bracketsMap.get(ch) != stack.pop()) {
                    return "Warning: Missing opening bracket for '<font color='red'>" + ch + "</font>' at position " + i + ".";
                }
            }
        }
        //if the stack isn't popped, the warning is shown
        if (!stack.isEmpty()) {
            StringBuilder extraBracketsWarning = new StringBuilder();
            while (!stack.isEmpty()) {
                char extraOpeningBracket = stack.pop();
                int position = expression.indexOf(extraOpeningBracket);
                extraBracketsWarning.append("Warning: Missing closing bracket for '<font color='red'>")
                        .append(extraOpeningBracket)
                        .append("</font>' at position ")
                        .append(position)
                        .append(".\n");
            }
            return extraBracketsWarning.toString();
        }

        return "The brackets are balanced.";
    }
}