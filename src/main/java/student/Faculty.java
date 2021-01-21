package student;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String name;
    List<Group> groups;


    public Faculty(String name) {
        groups = new ArrayList<>();
        this.name = name;
    }


    public List<Group> getGroups() throws MyException {
        if (groups.isEmpty()){
            throw new MyException("Groups are not in a faculty");
        }
        return groups;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
