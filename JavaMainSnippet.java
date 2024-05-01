import javax.swing.*;


    public class JavaMainSnippet {
//Java class prints main method onto the textarea
        private JTextArea textArea;

        public JavaMainSnippet(JTextArea textArea) {
            this.textArea = textArea;
        }

        public void insertCodeSnippet(String codeSnippet) {
            int caretPosition = textArea.getCaretPosition();
            textArea.insert(codeSnippet, caretPosition);
        }

        public void insertMainMethod() {
            String mainMethodSnippet = "public static void main(String[] args) {\n    // Your code here\n}\n";
            insertCodeSnippet(mainMethodSnippet);
        }
    }


