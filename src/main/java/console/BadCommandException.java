package console;

public class BadCommandException extends Exception{

    public BadCommandException() {}

    public BadCommandException(String text) {
        super(text);
    }
}
