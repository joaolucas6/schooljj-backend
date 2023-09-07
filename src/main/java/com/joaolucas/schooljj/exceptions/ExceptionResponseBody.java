package com.joaolucas.schooljj.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponseBody(String error, int errorCode, String message, LocalDateTime timestamp) {
}
