import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UML2JavaTranslator {
    private BufferedReader reader;
    private List<UMLObject> contents;
    private String currentLine;

    private static List<Character> commandEndingChars = new ArrayList<Character>(Arrays.asList(
            ',', '}', '{', '[', ']'
    ));

    public UML2JavaTranslator(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        contents = new ArrayList<>();
    }

    public String getNextLine() {
        try {
            StringBuilder command = new StringBuilder();
            int r;
            while (true) {
                r = reader.read();
                char readChar = (char) r;
                command.append(readChar);
                if (commandEndingChars.contains((char) r)) {
                    reader.read();
                    break;
                }
            }
            return command.toString().strip();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void createNewObject() {
        while (true) {
            System.out.println(getNextLine());
        }
    }

    public void interpretFile() {

    }
}
