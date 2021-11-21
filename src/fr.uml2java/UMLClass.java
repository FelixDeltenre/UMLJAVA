import java.util.ArrayList;
import java.util.List;

public class UMLClass extends UMLObject {
    private List<UMLAttribute> attributeList;
    private List<UMLOperation> operationsList;

    @Override
    public String toString() {
        return "UMLClass{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", attributeList=" + attributeList +
                ", operationsList=" + operationsList +
                '}';
    }

    public UMLClass() {
        attributeList = new ArrayList<>();
        operationsList = new ArrayList<>();
    }

    public List<UMLAttribute> getAttributeList() {
        return attributeList;
    }

    public void addAttribute(UMLAttribute umlAttribute) {
        attributeList.add(umlAttribute);
    }

    public void addOperation(UMLOperation umlOperation) {
        operationsList.add(umlOperation);
    }
}
