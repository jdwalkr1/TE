import javax.swing.*;

public class JavaFileReaderSnippet {

    private JTextArea textArea;

    public JavaFileReaderSnippet(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void insertCodeSnippet(String codeSnippet) {
        int caretPosition = textArea.getCaretPosition();
        textArea.insert(codeSnippet, caretPosition);
    }

    public void insertFileReaderMethod() {
        String fileReaderMethodSnippet = "public static void main(String[] args) {\n" +
                "    try (BufferedReader br = new BufferedReader(new FileReader(\"path/to/your/file.txt\"))) {\n" +
                "        String line;\n" +
                "        while ((line = br.readLine()) != null) {\n" +
                "            // Process each line\n" +
                "        }\n" +
                "    } catch (IOException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "}\n";
        insertCodeSnippet(fileReaderMethodSnippet);
    }
}
