import java.util.ArrayList;
import java.util.List;

public class UMLClass extends UMLObject {
    private List<UMLAttribute> attributeList;
    private List<UMLOperation> operationsList;
    private List<UMLAssociation> associationList;
    private List<String> motherClasses;
    private List<String> dependenciesIDList;
    private List<String> interfacesRealizations;

    @Override
    public String toString() {
        return "UMLClass{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", attributeList=" + attributeList +
                ", operationsList=" + operationsList +
                ", associationList=" + associationList +
                ", motherClasses=" + motherClasses +
                ", dependencies=" + dependenciesIDList +
                ", interfacesRealization=" + interfacesRealizations +
                '}';
    }

    public UMLClass() {
        attributeList = new ArrayList<>();
        operationsList = new ArrayList<>();
        associationList = new ArrayList<>();
        motherClasses = new ArrayList<>();
        dependenciesIDList = new ArrayList<>();
        interfacesRealizations = new ArrayList<>();
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

    public List<String> getInterfacesRealizations() {
        return interfacesRealizations;
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
        this.interfacesRealizations.add(interfaceId);
    }
}
