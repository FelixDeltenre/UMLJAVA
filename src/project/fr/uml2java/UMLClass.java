package fr.uml2java;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UMLClass extends UMLObject {
    private String type;
    private boolean _abstract = false;
    private List<UMLAttribute> attributeList;
    private List<UMLOperation> operationsList;
    private List<UMLAssociation> associationList;
    private List<String> motherClasses;
    private List<String> dependenciesIDList;
    private List<String> implementedInterfaces;

    public UMLClass(JSONObject jsonObject) {
        super(jsonObject);

        this.type = jsonObject.getString("_type");

        if (jsonObject.has("isAbstract")) {
            this.setAbstract();
        }

        if (jsonObject.has("attributes")) {
            this.attributeList = new ArrayList<>();
            JSONArray attributes = jsonObject.getJSONArray("attributes");
            for (int i = 0; i < attributes.length(); ++i) {
                this.attributeList.add(new UMLAttribute(attributes.getJSONObject(i)));
            }
        }

        if (jsonObject.has("operations")) {
            this.operationsList = new ArrayList<>();
            JSONArray operations = jsonObject.getJSONArray("operations");
            for (int i = 0; i < operations.length(); ++i) {
                this.operationsList.add(new UMLOperation(operations.getJSONObject(i)));
            }
        }

        if (jsonObject.has("ownedElements")) {
            JSONArray ownedElements = jsonObject.getJSONArray("ownedElements");
            for (int i = 0; i < ownedElements.length(); ++i) {
                JSONObject ownedElement = ownedElements.getJSONObject(i);
                if (ownedElement.has("UMLAssociation")) {
                    if (this.associationList == null) this.associationList = new ArrayList<>();

                    this.associationList.add(new UMLAssociation(ownedElement));
                } else if (ownedElement.has("UMLInterfaceRealization")) {
                    if (this.implementedInterfaces == null) {
                        this.implementedInterfaces = new ArrayList<>();
                    }
                    this.implementedInterfaces.add(ownedElement.getJSONObject("target").getString("$ref"));
                } else if (ownedElement.has("UMLDependency")) {
                    // TODO
                } else {
                    if (this.motherClasses == null) {
                        this.motherClasses = new ArrayList<>();
                    }
                    this.motherClasses.add(ownedElement.getJSONObject("target").getString("$ref"));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "UMLClass{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", visibility='" + getVisibility() + '\'' +
                ", _abstract=" + _abstract +
                ", attributeList=" + attributeList +
                ", operationsList=" + operationsList +
                ", associationList=" + associationList +
                ", motherClasses=" + motherClasses +
                ", dependenciesIDList=" + dependenciesIDList +
                ", implementedInterfaces=" + implementedInterfaces +
                '}';
    }

    public List<UMLAttribute> getAttributeList() {
        return attributeList;
    }

    public List<UMLOperation> getOperationsList() {
        return operationsList;
    }

    public List<UMLAssociation> getAssociationList() {
        return associationList;
    }

    public List<String> getMotherClasses() {
        return motherClasses;
    }

    public List<String> getDependenciesIDList() {
        return dependenciesIDList;
    }

    public List<String> getImplementedInterfaces() {
        return implementedInterfaces;
    }

    public Boolean isAbstract() {
        return _abstract;
    }

    public void setAbstract() {
        this._abstract = true;
    }

    public void addAttribute(UMLAttribute umlAttribute) {
        attributeList.add(umlAttribute);
    }

    public void addOperation(UMLOperation umlOperation) {
        operationsList.add(umlOperation);
    }

    public void addAssociation(UMLAssociation umlAssociation) {
        associationList.add(umlAssociation);
    }

    public void addGeneralization(String motherClass) {
        this.motherClasses.add(motherClass);
    }

    public void addDependency(String classId) {
        this.dependenciesIDList.add(classId);
    }

    public void addInterfaceRealization(String interfaceId) {
        this.implementedInterfaces.add(interfaceId);
    }
}
