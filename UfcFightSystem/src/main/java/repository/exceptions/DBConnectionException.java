package repository.exceptions;

public class DBConnectionException extends RuntimeException{
    public DBConnectionException(Throwable cause) {
        super("DB-Connection Failed",cause);
    }
}
