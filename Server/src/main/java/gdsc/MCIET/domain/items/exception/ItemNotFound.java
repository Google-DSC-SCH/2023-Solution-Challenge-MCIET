package gdsc.MCIET.domain.items.exception;

import gdsc.MCIET.global.error.exception.ErrorCode;
import gdsc.MCIET.global.error.exception.MCIETException;

public class ItemNotFound extends MCIETException {

    public static final MCIETException EXCEPTION = new ItemNotFound();

    public ItemNotFound() {
        super(ErrorCode.ITEM_NOT_FOUND);
    }
}
