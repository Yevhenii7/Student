package student;

import java.util.Map;

public class StudentManager {

    //Посчитать средний балл по всем предметам студента
    public static Double getAverageRatingInAllSubjectsOfStudent(Student students, int min, int max) throws MyException {
        double averageRating = 0;
        for (Integer mark : students.getRating().values()) {
            averageRating += mark;
        }
        averageRating /= students.subjectsNumber();
        if (averageRating < min || averageRating > max) throw new IllegalArgumentException();//Оценка ниже 0 или выше 10
        return averageRating;
    }

    //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
    public static Double getAverageRatingInSubjectInGroupInFaculty(String subject, Faculty faculty) throws MyException {
        //из факультета мы извлекаем лист групп
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

    //  Посчитать средний балл по предмету для всего университета
    public static Double getAverageRatingInSubjectInAllUniversity(String subject, University university) throws MyException {
        return university
                .getFaculties()
                .stream()//используем flatmap для того чтобы раскрыть из каждой группы стрим со студентами
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
