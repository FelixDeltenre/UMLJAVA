public class UMLAssociationEnd extends UMLObject {
    private String reference;
    private String visibility;
    private String multiplicity;

    @Override
    public String toString() {
        return "UMLAssociationEnd{" +
                "_id='" + getId() + '\'' +
                ", parentRef='" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", reference='" + reference + '\'' +
                ", visibility='" + visibility + '\'' +
                ", multiplicity='" + multiplicity + '\'' +
                '}';
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(String multiplicity) {
        this.multiplicity = multiplicity;
    }
}
