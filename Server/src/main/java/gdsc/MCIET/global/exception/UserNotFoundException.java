package gdsc.MCIET.global.exception;

import gdsc.MCIET.global.error.exception.ErrorCode;
import gdsc.MCIET.global.error.exception.MCIETException;

public class UserNotFoundException extends MCIETException {

    public static final MCIETException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
