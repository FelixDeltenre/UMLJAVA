import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

public class UML2JavaTranslator {
    private FileReader fileReader;
    private JSONObject jsonObject;
    private List<UMLObject> umlObjects = new ArrayList<>(); ;

    public UML2JavaTranslator(String file) {
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getFile() throws IOException {
        String parsable = "";
        int r;
        while ((r = fileReader.read()) != -1) {

            parsable += (char) r;
        }
        System.out.println(parsable);
        jsonObject = new JSONObject(parsable);
    }

    public void translate() {
        try {
            getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        JSONArray jsonArray = (JSONArray) jsonObject.get("ownedElements");
        System.out.println(jsonArray);
        for(int i = 0; i < jsonArray.length(); ++i) {
            createUMLObject(jsonArray.getJSONObject(i));
        }
        for (UMLObject umlObject : umlObjects) {
            System.out.println(umlObject);
        }
    }

    public UMLAttribute createUMLAttribute(JSONObject jsonObject) {
        UMLAttribute umlAttribute = new UMLAttribute();

        //TODO

        return umlAttribute;
    }

    public void createUMLClass(JSONObject jsonObject) {
        UMLClass umlClass = new UMLClass();
        umlClass.setId(jsonObject.get("_id").toString());
        umlClass.setName(jsonObject.get("name").toString());
        umlClass.setParentRef(jsonObject.getJSONObject("_parent").get("$ref").toString());
        if (!jsonObject.getJSONObject("attributes").isEmpty()) {
            JSONArray attributes = jsonObject.getJSONArray("attributes");
            for (int i = 0; i < attributes.length(); ++i) {
                attributes.get(i);
            }
        }


        umlObjects.add(umlClass);
    }

    public void createUMLObject(JSONObject object) {
        String type = object.get("_type").toString();
        switch (type) {
            case "UMLClass":
                createUMLClass(object);
                break;
            default:
                break;
        }
    }
}
