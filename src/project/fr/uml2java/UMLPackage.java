package fr.uml2java;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UMLPackage extends UMLObject {
    private final List<UMLObject> ownedElements;

    public UMLPackage(JSONObject jsonObject) {
        super(jsonObject);

        this.ownedElements = new ArrayList<>();

        JSONArray ownedElems = jsonObject.getJSONArray("ownedElements");
        for (int i = 0; i < ownedElems.length(); ++i) {
            JSONObject ownedElem = ownedElems.getJSONObject(i);
            switch (ownedElem.getString("_type")) {
                case "UMLClass" -> this.ownedElements.add(new UMLClass(ownedElem));
                case "UMLInterface" -> this.ownedElements.add(new UMLInterface(ownedElem));
                default -> {
                }
            }
        }
    }

    @Override
    public String toString() {
        return "UMLPackage{" +
                "id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", ownedElements=" + ownedElements +
                "}";
    }

    public List<UMLObject> getOwnedElements() {
        return ownedElements;
    }
}
