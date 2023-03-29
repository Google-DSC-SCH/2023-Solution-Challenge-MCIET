package gdsc.MCIET.domain.memo.exception;

import gdsc.MCIET.domain.cuisine.exception.CuisineNotFound;
import gdsc.MCIET.global.error.exception.ErrorCode;
import gdsc.MCIET.global.error.exception.MCIETException;

public class MemoNotFound extends MCIETException {

    public static final MCIETException EXCEPTION = new MemoNotFound();

    public MemoNotFound() {
        super(ErrorCode.MEMO_NOT_FOUND);
    }
}
