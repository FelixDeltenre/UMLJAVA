package fr.uml2java;

import org.json.JSONObject;

public class UMLAssociationEnd extends UMLAttribute {
    private String reference; // id of the class with that attribute

    public UMLAssociationEnd(JSONObject jsonObject) {
        super(jsonObject);

        this.reference = jsonObject.getJSONObject("reference").getString("$ref");
    }

    @Override
    public String toString() {
        return "UMLAssociationEnd{" +
                "value={" + super.toString() +
                ", reference='" + reference + '\'' +
                '}';
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
