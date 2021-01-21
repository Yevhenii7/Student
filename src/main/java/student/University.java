package student;

import java.util.ArrayList;
import java.util.List;

public class University {
    String name;
    List<Faculty> faculties;

    public University(String name) {
        faculties = new ArrayList<>();
        this.name = name;
    }

    public List<Faculty> getFaculties() throws MyException {
        if (faculties.isEmpty()){
            throw  new MyException("Faculties are not in university");
        }
        return faculties;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
