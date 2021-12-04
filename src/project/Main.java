import fr.uml2java.*;

public class Main {
    public static void main(String[] args) {
        try {
            UML2JavaTranslator uml2JavaTranslator =
                    new UML2JavaTranslator("UMLTestFiles/test_simple_class_attributes_and_operations.mdj");
            uml2JavaTranslator.translate();
            System.out.println(uml2JavaTranslator.getProject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
