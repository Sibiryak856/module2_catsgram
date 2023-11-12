package ru.yandex.practicum.catsgram.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.service.FaultResponse;

@ControllerAdvice
public class DefaultAdvise {

    @ExceptionHandler({UserAlreadyExistException.class, InvalidEmailException.class})
    public ResponseEntity<FaultResponse> handleException(Exception e) {
        FaultResponse response = new FaultResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}