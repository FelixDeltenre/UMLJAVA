public class UMLAssociation extends UMLObject {
    private UMLAssociationEnd end1;
    private UMLAssociationEnd end2;

    @Override
    public String toString() {
        return "UMLAssociation{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", end1=" + end1 +
                ", end2=" + end2 +
                '}';
    }

    public UMLAssociationEnd getEnd1() {
        return end1;
    }

    public void setEnd1(UMLAssociationEnd end1) {
        this.end1 = end1;
    }

    public UMLAssociationEnd getEnd2() {
        return end2;
    }

    public void setEnd2(UMLAssociationEnd end2) {
        this.end2 = end2;
    }
}
