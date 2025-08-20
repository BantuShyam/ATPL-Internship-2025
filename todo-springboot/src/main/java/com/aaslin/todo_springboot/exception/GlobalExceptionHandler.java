package com.aaslin.todo_springboot.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle duplicate title (unique constraint violation)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolation(DataIntegrityViolationException ex, Model model) {
        String message = "Todo title already exists! Please choose a different title.";
        model.addAttribute("errorMessage", message);
        return "error"; // templates/error.html
    }

    // Fallback for any other errors
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Something went wrong. Please try again later.");
        return "error";
    }
}
