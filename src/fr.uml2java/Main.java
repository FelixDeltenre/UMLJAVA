import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            UML2JavaTranslator uml2JavaTranslator = new UML2JavaTranslator("test_classe_attribut_operation.mdj");
            uml2JavaTranslator.translate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
