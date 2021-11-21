import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UML2JavaTranslator uml2JavaTranslator = new UML2JavaTranslator("test_association_attribut_operation.mdj");
            uml2JavaTranslator.translate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
