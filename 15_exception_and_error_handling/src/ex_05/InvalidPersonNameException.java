package ex_05;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String massage) {
        super(massage);
    }
}