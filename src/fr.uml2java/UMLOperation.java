import java.util.ArrayList;
import java.util.List;

public class UMLOperation extends UMLObject {
    private List<UMLParameter> parameterList;

    @Override
    public String toString() {
        return "UMLOperation{" +
                "_id='" + getId() + '\'' +
                ", parentRef'" + getParentRef() + '\'' +
                ", name='" + getName() + '\'' +
                ", parameterList=" + parameterList +
                '}';
    }

    public void addParameter(UMLParameter umlParameter) {
        parameterList.add(umlParameter);
    }

    public UMLOperation() {
        parameterList = new ArrayList<>();
    }

    public List<UMLParameter> getParameterList() {
        return parameterList;
    }

}
