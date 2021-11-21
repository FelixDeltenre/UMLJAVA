import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class UML2JavaTranslator {
    private FileReader fileReader;
    private JSONObject jsonObject;
    private List<UMLObject> umlObjects = new ArrayList<>();
    ;

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
        for (int i = 0; i < jsonArray.length(); ++i) {
            createUMLObject(jsonArray.getJSONObject(i));
        }
        for (UMLObject umlObject : umlObjects) {
            System.out.println(umlObject);
        }
    }

    public void setUMLObjectPart(UMLObject umlObject, JSONObject jsonObject) {
        umlObject.setId(jsonObject.get("_id").toString());
        umlObject.setParentRef(jsonObject.getJSONObject("_parent").get("$ref").toString());
    }

    public UMLAttribute createUMLAttribute(JSONObject jsonObject) {
        UMLAttribute umlAttribute = new UMLAttribute();

        setUMLObjectPart(umlAttribute, jsonObject);

        umlAttribute.setName(jsonObject.get("name").toString());
        umlAttribute.setType(jsonObject.get("_type").toString());

        return umlAttribute;
    }

    public UMLParameter createUMLParameter(JSONObject jsonObject) {
        UMLParameter umlParameter = new UMLParameter();

        setUMLObjectPart(umlParameter, jsonObject);

        if (jsonObject.has("name")) {
            umlParameter.setName(jsonObject.get("name").toString());
        }
        if (jsonObject.has("direction")) {
            umlParameter.setDirection(jsonObject.get("direction").toString());
        }
        umlParameter.setType(jsonObject.get("type").toString());


        return umlParameter;
    }

    public UMLOperation createUMLOperation(JSONObject jsonObject) {
        UMLOperation umlOperation = new UMLOperation();

        setUMLObjectPart(umlOperation, jsonObject);

        umlOperation.setName(jsonObject.get("name").toString());

        JSONArray parameters = jsonObject.getJSONArray("parameters");
        if (!parameters.isEmpty()) {
            for (int i = 0; i < parameters.length(); ++i) {
                umlOperation.addParameter(createUMLParameter((JSONObject) parameters.get(i)));
            }
        }

        return umlOperation;
    }

    public void createUMLClass(JSONObject jsonObject) {
        UMLClass umlClass = new UMLClass();

        umlClass.setId(jsonObject.get("_id").toString());
        umlClass.setName(jsonObject.get("name").toString());
        umlClass.setParentRef(jsonObject.getJSONObject("_parent").get("$ref").toString());

        JSONArray attributes = jsonObject.getJSONArray("attributes");
        if (!attributes.isEmpty()) {
            for (int i = 0; i < attributes.length(); ++i) {
                umlClass.addAttribute(createUMLAttribute((JSONObject) attributes.get(i)));
            }
        }
        JSONArray operations = jsonObject.getJSONArray("operations");
        if (!operations.isEmpty()) {
            for (int i = 0; i < operations.length(); ++i) {
                umlClass.addOperation(createUMLOperation(operations.getJSONObject(i)));
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
