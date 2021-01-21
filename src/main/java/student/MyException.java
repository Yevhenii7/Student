package student;

public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
        System.out.println(message);

    }


}
