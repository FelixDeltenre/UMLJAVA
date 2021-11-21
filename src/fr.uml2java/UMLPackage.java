import java.util.ArrayList;
import java.util.List;

public class UMLPackage extends UMLObject {
    private List<UMLObject> ownedElements;

    public UMLPackage() {
        this.ownedElements = new ArrayList<>();
    }

    public void addElement(UMLObject umlObject) {
        this.ownedElements.add(umlObject);
    }

    public List<UMLObject> getOwnedElements() {
        return ownedElements;
    }

    public void setOwnedElements(List<UMLObject> ownedElements) {
        this.ownedElements = ownedElements;
    }
}
