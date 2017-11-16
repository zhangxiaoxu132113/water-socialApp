package com.water.db.controller.commons;

import com.water.utils.exception.ResourceNotFoundExeception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrwater on 2017/11/16.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = ResourceNotFoundExeception.class)
    public void handle404(Throwable e) {
    }

//    @ExceptionHandler
//    @ResponseBody
//    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
//        LOGGER.error("API Exception! ", e);
//        BaseRespWriter writer = new BaseRespWriter();
//        writer.setErrMsg("API Exception!");
//        outputMessage(response, JSON.toJSONString(writer));
//    }

    private void outputMessage(HttpServletResponse response, String errMsg) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        ServletOutputStream os = response.getOutputStream();
        os.write(errMsg.getBytes("utf-8"));
    }
}
