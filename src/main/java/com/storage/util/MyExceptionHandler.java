package com.storage.util;

import com.storage.exception.UnAuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice(annotations= {ResponseBody.class, RestController.class, Validated.class, Valid.class})
@ResponseBody
public class MyExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        return responseException("缺少请求参数");
    }
    @ExceptionHandler(UnAuthorizationException.class)
    public Object handleMissingServletRequestParameterException(UnAuthorizationException e) {
        log.error("鉴权异常", e);
        return responseException(e.getMessage());
    }
    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return responseException("参数传入方式有误");
    }

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数验证失败", e.getMessage());
        BindingResult result = e.getBindingResult();
        return responseException(validMsg(result));
    }

    private String validMsg(BindingResult result){
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return message;
    }

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(BindException.class)
    public Object handleBindException(BindException e) {
        log.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();

        return responseException(validMsg(result));
    }

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Object handleServiceException(ConstraintViolationException e) {
        log.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return responseException(message);
    }

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(ValidationException.class)
    public Object handleValidationException(ValidationException e) {
        log.error("参数验证失败", e);
        return responseException(e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return responseException(e.getMessage());
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("不支持当前媒体类型", e);
        return responseException("不支持当前媒体类型");
    }

//    /**
//     * 401
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(UnAuthorizationException.class)
//    public Object unAuthorizationException(UnAuthorizationException e) {
//        log.error("鉴权异常", e);
//        return responseException(ResponseCodeEnum.AUTH_UNACCESS,e.getMsg());
//    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object handleException(DataIntegrityViolationException e) {
        log.error("操作数据库出现异常:", e);
        return responseException("操作数据库出现异常：字段重复、有外键关联等等");
    }

    /**
     * 500 - Internal Server Error
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Object handleServiceException(IllegalArgumentException e) {
        log.error("参数异常:", e);
        return responseException( e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error("异常",e);
        return responseException(e.getMessage());
    }

    public Result responseException(String msg){
        return Result.failed(msg);
    }

}