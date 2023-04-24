package student;

import java.util.Map;

public class StudentManager {

    //Calculate the average score for all student subjects
    public static Double getAverageRatingInAllSubjectsOfStudent(Student students, int min, int max) throws MyException {
        double averageRating = 0;
        for (Integer mark : students.getRating().values()) {
            averageRating += mark;
        }
        averageRating /= students.subjectsNumber();
        if (averageRating < min || averageRating > max) throw new IllegalArgumentException();//Оценка ниже 0 или выше 10
        return averageRating;
    }

    //Calculate the average score for a particular subject in a particular group and at a particular faculty
    public static Double getAverageRatingInSubjectInGroupInFaculty(String subject, Faculty faculty) throws MyException {
        //from the faculty we extract the list of groups
        return faculty.
                getGroups()
                .stream()
                .flatMap(group -> {
                    try {
                        return group.getStudents().stream();
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .mapToInt(student -> {
                    try {
                        return student.getRating().get(subject);
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    return 0;
                })
                .average()
                .orElse(0);

    }

    //  Calculate the average grade in the subject for the entire university
    public static Double getAverageRatingInSubjectInAllUniversity(String subject, University university) throws MyException {
        return university
                .getFaculties()
                .stream()//use flatmap to uncover a stream with students from each group
                .flatMap(faculty -> {
                    try {
                        return faculty.getGroups().stream();
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .flatMap(group -> {
                    try {
                        return group.getStudents().stream();
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .mapToInt(student -> {
                    try {
                        return student.getRating().get(subject);
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    return 0;
                })
                .average()
                .orElse(0);

    }

}
