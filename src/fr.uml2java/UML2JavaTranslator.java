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
            createUMLClasses(jsonArray.getJSONObject(i));
        }
        for (UMLObject umlObject : umlObjects) {
            System.out.println(umlObject);
        }
    }

    public void setUMLObjectPart(UMLObject umlObject, JSONObject jsonObject) {
        umlObject.setId(jsonObject.getString("_id"));
        umlObject.setParentRef(jsonObject.getJSONObject("_parent").getString("$ref"));
        if (jsonObject.has("name")) {
            umlObject.setName(jsonObject.getString("name"));
        }
    }

    public UMLAttribute createUMLAttribute(JSONObject jsonObject) {
        UMLAttribute umlAttribute = new UMLAttribute();

        setUMLObjectPart(umlAttribute, jsonObject);

        umlAttribute.setType(jsonObject.getString("_type"));

        return umlAttribute;
    }

    public UMLParameter createUMLParameter(JSONObject jsonObject) {
        UMLParameter umlParameter = new UMLParameter();

        setUMLObjectPart(umlParameter, jsonObject);

        if (jsonObject.has("direction")) {
            umlParameter.setDirection(jsonObject.getString("direction"));
        }
        umlParameter.setType(jsonObject.getString("type"));


        return umlParameter;
    }

    public UMLOperation createUMLOperation(JSONObject jsonObject) {
        UMLOperation umlOperation = new UMLOperation();

        setUMLObjectPart(umlOperation, jsonObject);

        if (jsonObject.has("parameters")) {
            JSONArray parameters = jsonObject.getJSONArray("parameters");
            if (!parameters.isEmpty()) {
                for (int i = 0; i < parameters.length(); ++i) {
                    umlOperation.addParameter(createUMLParameter((JSONObject) parameters.get(i)));
                }
            }
        }
        return umlOperation;
    }

    public String createUMLGeneralization(JSONObject jsonObject) {
        return jsonObject.getJSONObject("target").getString("$ref");
    }

    public String createUMLDependency(JSONObject jsonObject) {
        return jsonObject.getJSONObject("target").getString("$ref");
    }

    public String createUMLInterfaceRealization(JSONObject jsonObject) {
        return jsonObject.getJSONObject("target").getString("$ref");
    }

    public UMLClass createUMLClass(JSONObject jsonObject) {
        UMLClass umlClass = new UMLClass();

        setUMLObjectPart(umlClass, jsonObject);

        umlClass.setId(jsonObject.getString("_id"));
        umlClass.setParentRef(jsonObject.getJSONObject("_parent").getString("$ref"));

        if (jsonObject.has("attributes")) {
            JSONArray attributes = jsonObject.getJSONArray("attributes");
            if (!attributes.isEmpty()) {
                for (int i = 0; i < attributes.length(); ++i) {
                    umlClass.addAttribute(createUMLAttribute((JSONObject) attributes.get(i)));
                }
            }
        }

        if (jsonObject.has("operations")) {
            JSONArray operations = jsonObject.getJSONArray("operations");
            if (!operations.isEmpty()) {
                for (int i = 0; i < operations.length(); ++i) {
                    umlClass.addOperation(createUMLOperation(operations.getJSONObject(i)));
                }
            }
        }

        if (jsonObject.has("ownedElements")) {
            JSONArray associations = jsonObject.getJSONArray("ownedElements");
            if (!associations.isEmpty()) {
                for (int i = 0; i < associations.length(); ++i) {
                    String type = associations.getJSONObject(i).getString("_type");
                    switch (type) {
                        case "UMLAssociation"
                                -> umlClass.addAssociation(createUMLAssociation(associations.getJSONObject(i)));
                        case "UMLGeneralization"
                                -> umlClass.addGeneralization(createUMLGeneralization(associations.getJSONObject(i)));
                        case "UMLDependency"
                                -> umlClass.addDependency(createUMLDependency(associations.getJSONObject(i)));
                        case "UMLInterfaceRealization"
                                -> umlClass.addInterfaceRealization(createUMLInterfaceRealization(associations.getJSONObject(i)));
                    }
                }
            }
        }

        return umlClass;
    }

    public UMLAssociationEnd createUMLAssociationEnd(JSONObject jsonObject) {
        UMLAssociationEnd umlAssociationEnd = new UMLAssociationEnd();

        setUMLObjectPart(umlAssociationEnd, jsonObject);

        umlAssociationEnd.setReference(jsonObject.getJSONObject("reference").getString("$ref"));
        umlAssociationEnd.setMultiplicity(jsonObject.getString("visibility"));
        umlAssociationEnd.setVisibility(jsonObject.getString("visibility"));

        return umlAssociationEnd;
    }

    public UMLAssociation createUMLAssociation(JSONObject jsonObject) {
        UMLAssociation umlAssociation = new UMLAssociation();

        setUMLObjectPart(umlAssociation, jsonObject);

        if (jsonObject.has("aggregation")) {
            umlAssociation.setAggregation(jsonObject.getString("aggregation"));
        }

        umlAssociation.setEnd1(createUMLAssociationEnd(jsonObject.getJSONObject("end1")));
        umlAssociation.setEnd2(createUMLAssociationEnd(jsonObject.getJSONObject("end2")));

        return umlAssociation;
    }

    public UMLInterface createUMLInterface(JSONObject jsonObject) {
        UMLInterface umlInterface = (UMLInterface) createUMLClass(jsonObject);

        return umlInterface;
    }

    public void createUMLClasses(JSONObject object) {
        String type = object.getString("_type");
        switch (type) {
            case "UMLClass":
                this.umlObjects.add(createUMLClass(object));
                break;
            case "UMLInterface":
                this.umlObjects.add(createUMLInterface(object));
            default:
                break;
        }
    }
}
