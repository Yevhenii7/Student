package student;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    List<Student> students;

    public Group(String name) {
        students = new ArrayList<>();
        this.name = name;
    }

    public List<Student> getStudents() throws MyException {
        if (students.isEmpty()) {
            throw new MyException("Students are not in a group");
        }
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + "\n" +
                ", students=" + students +
                '}';
    }
}
