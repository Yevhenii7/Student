package student;

public class Running {
    public static void main(String[] args) throws MyException {


        Student student1 = new Student("Sergeev Sergei Sergeevich", 20);
        student1.setRate("MATH", 5);
        student1.setRate("HISTORY", 6);
        student1.setRate("PHYSIC", 6);

        Student student2 = new Student("Petrov Petr Petrovovich", 22);
        student2.setRate("MATH", 7);
        student2.setRate("HISTORY", 6);
        student2.setRate("CHEMISTRY", 5);

        Student student3 = new Student("Alexeev Alex Vladimirovich", 21);
        student3.setRate("MATH", 5);
        student3.setRate("HISTORY", 4);
        student3.setRate("CHEMISTRY", 3);

        Student student4 = new Student("Vadimovich Vadim Alexandrovich", 19);
        student4.setRate("MATH", 7);
        student4.setRate("HISTORY", 6);
        student4.setRate("CHEMISTRY", 5);

        Group group1 = new Group("ФК-071");
        group1.students.add(student1);
        group1.students.add(student3);

        Group group2 = new Group("ПМ-081");
        group2.students.add(student2);
        group2.students.add(student4);


        Faculty faculty1 = new Faculty("PHYSICS FACULTY");
        faculty1.groups.add(group1);

        Faculty faculty2 = new Faculty("HISTORY FACULTY");
        faculty2.groups.add(group2);

        University university = new University("Ukrainian University");
        university.faculties.add(faculty1);
        university.faculties.add(faculty2);
        System.out.println(university.name);

        System.out.println("Average grade in all subjects of the student: \n" + student1);
        System.out.println("Average grade: \n" + StudentManager.getAverageRatingInAllSubjectsOfStudent(student1, 0, 10));

        System.out.println("Average grade in a specific subject in a specific group and in a specific faculty: \n"
                + StudentManager.getAverageRatingInSubjectInGroupInFaculty("HISTORY", faculty1));

        System.out.println("Average grade in a subject for the whole university: \n"
                + StudentManager.getAverageRatingInSubjectInAllUniversity("HISTORY", university));


    }
}
