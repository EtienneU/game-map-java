package exception;

public class DeplacementException extends Exception {

    DeplacementException(String message) {
        super(message);
        System.out.println(message);
    }
}
