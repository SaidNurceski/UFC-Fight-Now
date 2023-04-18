package repository.exceptions;

public class InsertIntoDBException extends RuntimeException {
    public InsertIntoDBException(Throwable cause) {
        super( "Inserting Into DB failed" ,cause);
    }
}
