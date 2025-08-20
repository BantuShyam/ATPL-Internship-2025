package com.aaslin.todo_springboot.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        String message = "Something went wrong!";

        if (exception != null) {
            Throwable ex = (Throwable) exception;
            message = ex.getMessage();  // ✅ show real cause (like duplicate entry error)
        } else if (statusCode != null) {
            message = "Error code: " + statusCode.toString();
        }

        model.addAttribute("errorMessage", message);
        return "error"; // maps to templates/error.html
    }
}
