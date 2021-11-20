public class UMLObject {
    private String id;
    private String parentRef;
    private String name;

    @Override
    public String toString() {
        return "UMLObject{" +
                "id='" + id + '\'' +
                ", parentRef='" + parentRef + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentRef() {
        return parentRef;
    }

    public void setParentRef(String parentRef) {
        this.parentRef = parentRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
