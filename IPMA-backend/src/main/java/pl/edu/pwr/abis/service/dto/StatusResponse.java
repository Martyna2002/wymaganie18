package pl.edu.pwr.abis.service.dto;

public enum StatusResponse {
    OK(200),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_ERROR(500);

    private final int code;

    StatusResponse(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
