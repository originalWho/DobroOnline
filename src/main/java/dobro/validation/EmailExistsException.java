package dobro.validation;

/**
 * Created by Artur on 4/22/16.
 */
public class EmailExistsException extends Throwable {

    public EmailExistsException(String message) {
        super(message);
    }
}
