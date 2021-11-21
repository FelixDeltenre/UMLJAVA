public class UMLAttribute extends UMLObject {
    private String visibility = "public";
    private String type;

    @Override
    public String toString() {
        return "UMLAttribute{" +
                "_id='" + getId() +  '\'' +
                "parentRef='" + getParentRef() + '\'' +
                "visibility='" + visibility + '\'' +
                ", type='" + type + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
