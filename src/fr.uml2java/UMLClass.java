import java.util.ArrayList;
import java.util.List;

public class UMLClass extends UMLObject {
    private List<UMLAttribute> attributeList;

    public UMLClass() {
        attributeList = new ArrayList<>();
    }

    public List<UMLAttribute> getAttributeList() {
        return attributeList;
    }

    public void add(UMLAttribute umlAttribute) {
        attributeList.add(umlAttribute);
    }
}
