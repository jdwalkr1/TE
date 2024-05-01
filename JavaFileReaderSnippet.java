import javax.swing.*;

//Code snippet writes the file reader into the main text editor
public class JavaFileReaderSnippet {

    private JTextArea textArea;

    public JavaFileReaderSnippet(JTextArea textArea) {
        this.textArea = textArea;
    }
    //gets the position in the text area
    public void insertCodeSnippet(String codeSnippet) {
        int caretPosition = textArea.getCaretPosition();
        textArea.insert(codeSnippet, caretPosition);
    }
//output in string
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
