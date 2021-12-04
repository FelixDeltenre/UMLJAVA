package fr.uml2java;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class UMLProject extends UMLObject {
    private List<UMLObject> ownedElements = new ArrayList<>();

    public UMLProject(JSONObject jsonObject) {
        super(jsonObject);

        JSONArray ownedElems = jsonObject.getJSONArray("ownedElements")
                .getJSONObject(0).getJSONArray("ownedElements");

        for (int i = 0; i < ownedElems.length(); ++i) {
            JSONObject elem = ownedElems.getJSONObject(i);
            if (elem.getString("_type").equals("UMLPackage")) {
                this.ownedElements.add(new UMLPackage(elem));
            }
        }
    }

    public List<UMLObject> getOwnedElements() {
        return ownedElements;
    }

    public void setOwnedElements(List<UMLObject> ownedElements) {
        this.ownedElements = ownedElements;
    }

    @Override
    public String toString() {
        return "UMLProject{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                "ownedElements=" + ownedElements +
                "}";
    }
}
