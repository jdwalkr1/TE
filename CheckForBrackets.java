import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.*;

//Checks for unclosed brackets
//returns index of unclosed bracket

public class CheckForBrackets extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;
    //instantiates swing window
    //@param textArea to iterate through text area searching for brackets
    public CheckForBrackets(JTextArea textArea) {
        this.textArea = textArea;
        //setting the size and parameters for Bracket check
        setTitle("Bracket Checker");
        setSize(400, 70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(textArea);
        //importing document listener
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
    //changes happen in the mark up languages
    private void updateResult() {
        String result = checkBalance();
        if (result.startsWith("Warning")) {
            resultLabel.setForeground(Color.RED);
        } else {
            resultLabel.setForeground(Color.GREEN);
        }
        resultLabel.setText("<html>" + result.replaceAll("\n", "<br/>") + "</html>");
    }
    //the main method that uses a stack to implement the check
    //famous stack exercise
    public String checkBalance() {
        String expression = textArea.getText();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> bracketPositions = new HashMap<>();
        Set<Character> openingBrackets = new HashSet<>(Arrays.asList('(', '[', '{'));
        Set<Character> closingBrackets = new HashSet<>(Arrays.asList(')', ']', '}'));
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        int lineNumber = 1;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '\n') {
                lineNumber++;
            }
            if (openingBrackets.contains(ch)) {
                stack.push(ch);
                bracketPositions.put(ch, lineNumber);
            } else if (closingBrackets.contains(ch)) {
                if (stack.isEmpty() || bracketsMap.get(ch) != stack.pop()) {
                    return "Warning: Missing opening bracket for '<font color='red'>" + ch + "</font>' at line " + lineNumber + ".";
                }
            }
        }
        //if the stack isn't popped, the warning is shown
        if (!stack.isEmpty()) {
            StringBuilder extraBracketsWarning = new StringBuilder();
            while (!stack.isEmpty()) {
                char extraOpeningBracket = stack.pop();
                int lineNumberMissingClosing = bracketPositions.get(extraOpeningBracket);
                extraBracketsWarning.append("Warning: Missing closing bracket for '<font color='red'>")
                        .append(extraOpeningBracket)
                        .append("</font>' at line ")
                        .append(lineNumberMissingClosing)
                        .append(".\n");
            }
            return extraBracketsWarning.toString();
        }

        return "The brackets are balanced.";
    }
    }
