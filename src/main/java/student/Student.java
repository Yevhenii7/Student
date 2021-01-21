package student;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private final Map<String, Integer> rating;
    private final String name;
    private final int age;


    public Student(String name, int age) {
        super(age);
        rating = new HashMap<>();
        this.name = name;
        this.age = age;
    }


    public void setRate(String subject, Integer rate) {
        rating.put(subject, rate);
    }

    public int subjectsNumber() {
        return rating.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "rating=" + rating +
                ", name='" + name + "\n" +
                '}';
    }


    public Map<String, Integer> getRating() throws MyException {
        if (rating.isEmpty()) {
            throw new MyException("No subject");
        }
        return rating;
    }
}
