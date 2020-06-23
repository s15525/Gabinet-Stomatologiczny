package diagramClass;

import java.util.LinkedList;
import java.util.List;

public abstract class ObjectPlus4 extends ObjectPlusPlus {
    private List<String> rolesXOR = new LinkedList<>();

    public void addAndRole(String xorRoleName) {
        rolesXOR.add(xorRoleName);
    }

    public void addLinkAnd(String roleName, String reverseRoleName, ObjectPlusPlus targetObject){
        super.addLink(roleName, reverseRoleName, targetObject);
    }
}
