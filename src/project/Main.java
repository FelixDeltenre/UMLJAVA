import fr.uml2java.*;

public class Main {
    public static void main(String[] args) {
        try {
            UML2JavaTranslator uml2JavaTranslator = new UML2JavaTranslator("test_interface_realization.mdj");
            uml2JavaTranslator.translate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
