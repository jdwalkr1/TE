import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class JavaFileWriterSnippet {

    private JTextArea textArea;

    public JavaFileWriterSnippet(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void insertCodeSnippet(String codeSnippet) {
        int caretPosition = textArea.getCaretPosition();
        textArea.insert(codeSnippet, caretPosition);
    }

    public void writeFileMethod() {
        String fileWriterMethodSnippet = "public static void main(String[] args) {\n" +
                "    String fileName = \"output.txt\";\n" +
                "    String content = \"Hello, World!\";\n" +
                "\n" +
                "    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {\n" +
                "        writer.write(content);\n" +
                "        System.out.println(\"Content has been written to the file.\");\n" +
                "    } catch (IOException e) {\n" +
                "        System.err.println(\"Error writing to file: \" + e.getMessage());\n" +
                "    }\n" +
                "}\n";
        insertCodeSnippet(fileWriterMethodSnippet);
    }


}
