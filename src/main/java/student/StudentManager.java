package student;

import java.util.Map;

public class StudentManager {

    //Посчитать средний балл по всем предметам студента
    public static Double getAverageRatingInAllSubjectsOfStudent(Student students, int min, int max) {
//Отсутствие студентов в группе
        if (students.equals(null)) throw new NullPointerException("Exception: student is not in group!");
        double averageRating = 0;
        for (Integer mark : students.getRating().values()) {
            averageRating += mark;
        }
        averageRating /= students.subjectsNumber();
        if (averageRating < min || averageRating > max) throw new IllegalArgumentException();//Оценка ниже 0 или выше 10
        return averageRating;
    }

    //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
    public static Double getAverageRatingInSubjectInGroupInFaculty(String subject, Faculty faculty) {
        //из факультета мы извлекаем лист групп
        return faculty.
                getGroups()
                .stream()
                .flatMap(group -> group.getStudents().stream())
                .mapToInt(student -> {
                    try {
                        return student.getRating().get(subject);
                    } catch (MyException e) {
                        throw new MyException();
                    }

                })
                .average()
                .orElse(0);

    }

    //  Посчитать средний балл по предмету для всего университета
    public static Double getAverageRatingInSubjectInAllUniversity(String subject, University university) {
        return university
                .getFaculties()
                .stream()//используем flatmap для того чтобы раскрыть из каждой группы стрим со студентами
                .flatMap(faculty -> faculty.getGroups().stream())
                .flatMap(group -> group.getStudents().stream())
                .mapToInt(student -> student.getRating().get(subject))
                .average()
                .orElse(0);

    }

    public static boolean checkSubjectIsEmpty() {

    }
}
