package gdsc.MCIET.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //404 Not_Found : Resource 를 찾을 수 없음
    USER_NOT_FOUND(NOT_FOUND.value(),  "User Not Found."),
    CUISINE_NOT_FOUND(NOT_FOUND.value(), "Cuisine Not Found."),
    ITEM_NOT_FOUND(NOT_FOUND.value(), "Item Not Found"),
    MEMO_NOT_FOUND(NOT_FOUND.value(), "Memo Not Found."),
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND.value(), "로그아웃 된 사용자입니다"),
    NO_ERROR_TYPE(NOT_FOUND.value(), "오류 발생"),

    //400 BAD_REQUEST : 잘못된 요청
    INVALID_REFRESH_TOKEN(BAD_REQUEST.value(), "리프레시 토큰이 유효하지 않습니다"),
    INVALID_ACCESS_TOKEN(BAD_REQUEST.value(), "Access 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(BAD_REQUEST.value(), "리프레시 토큰의 유저 정보가 일치하지 않습니다"),

    //401 UNAUTHORIZED : 인증되지 않은 사용자
    INVALID_AUTH_TOKEN(UNAUTHORIZED.value(), "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED.value(), "현재 내 계정 정보가 존재하지 않습니다"),

    //409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재
    DUPLICATE_RESOURCE(CONFLICT.value(), "데이터가 이미 존재합니다"),

    //500
    INTERNAL_SERVER_ERROR(500,"server-error");

    private int status;
    private String reason;
}
