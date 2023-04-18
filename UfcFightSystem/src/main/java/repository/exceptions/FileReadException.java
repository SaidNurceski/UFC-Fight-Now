package repository.exceptions;

public class FileReadException extends  RuntimeException{
    public FileReadException(Throwable cause) {
        super("Reading File failed",cause);
    }
}
