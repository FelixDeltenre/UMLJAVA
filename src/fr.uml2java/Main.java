public class Main {
    public static void main(String[] args) {
        try {
            UML2JavaTranslator uml2JavaTranslator = new UML2JavaTranslator("test.mdj");
            uml2JavaTranslator.createNewObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
