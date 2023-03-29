package gdsc.MCIET.domain.cuisine.exception;

import gdsc.MCIET.global.error.exception.ErrorCode;
import gdsc.MCIET.global.error.exception.MCIETException;

public class CuisineNotFound extends MCIETException {

    public static final MCIETException EXCEPTION = new CuisineNotFound();

    public CuisineNotFound() {
        super(ErrorCode.CUISINE_NOT_FOUND);
    }
}
