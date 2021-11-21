import java.util.ArrayList;
import java.util.List;

public class UMLClass extends UMLObject {
    private List<UMLAttribute> attributeList;
    private List<UMLOperation> operationsList;
    private List<UMLAssociation> associationList;

    @Override
    public String toString() {
        return "UMLClass{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", attributeList=" + attributeList +
                ", operationsList=" + operationsList +
                ", associationList=" + associationList +
                '}';
    }

    public UMLClass() {
        attributeList = new ArrayList<>();
        operationsList = new ArrayList<>();
        associationList = new ArrayList<>();
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

    public void addAttribute(UMLAttribute umlAttribute) {
        attributeList.add(umlAttribute);
    }

    public void addOperation(UMLOperation umlOperation) {
        operationsList.add(umlOperation);
    }

    public void addAssociation(UMLAssociation umlAssociation) {
        associationList.add(umlAssociation);
    }
}
