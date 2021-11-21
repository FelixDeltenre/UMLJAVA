public class UMLParameter extends UMLObject {
    private String type;
    private String direction;

    @Override
    public String toString() {
        return "UMLParameter{" +
                "_id='" + getId() + '\'' +
                "parentRef='" + getParentRef() + '\'' +
                "name='" + getName() + '\'' +
                "type='" + type + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
