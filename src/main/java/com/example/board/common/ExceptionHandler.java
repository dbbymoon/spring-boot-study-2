package com.example.board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    private Logger log = LoggerFactory.getLogger("board");

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception){
        ModelAndView mv = new ModelAndView("/error/error_default");
        mv.addObject("exception",exception);
        log.error("exception", exception);
        return mv;
    }
}
