package com.mall.goods.adapter.in.web.handlers;

import com.mall.goods.common.Result;
import com.mall.goods.common.enums.Resp;
import com.mall.goods.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 * 统一处理所有异常，避免重复和冲突
 *
 * @author wuyunbin
 * @since 2025-07-02
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 获取当前请求
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }
    
    /**
     * 记录异常日志
     */
    private void logException(String type, Exception e) {
        HttpServletRequest request = getRequest();
        String requestURI = request != null ? request.getRequestURI() : "unknown";
        log.error("【{}】URI: {}, 异常: {}", type, requestURI, e.getMessage(), e);
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Object> handleBusinessException(BusinessException e) {
        Resp resp = e.getResp();
        if (resp == null) {
            log.info("业务异常（无枚举）：{}", e.getMessage());
            return Result.fail(Result.HTTP_OK, "USER99000", e.getMessage(), null);
        }
        
        log.info("业务异常：{}", resp.getMessage());
        return Result.fail(Result.HTTP_OK, resp.getCode(), resp.getMessage(), null);
    }

    /**
     * 处理参数校验异常 - @Valid
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleValidationException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        log.info("参数校验失败: {}", errorMessage);
        
        // 收集详细的字段错误信息
        Map<String, Object> fieldErrorMap = new HashMap<>();
        fieldErrors.forEach(error -> 
            fieldErrorMap.put(error.getField(), error.getDefaultMessage())
        );
        
        Result<Object> result = Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), errorMessage, null);
        result.setExtra(fieldErrorMap);
        return result;
    }
    
    /**
     * 处理绑定异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleBindException(BindException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
                
        log.info("参数绑定失败: {}", errorMessage);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), errorMessage, null);
    }

    /**
     * 处理约束违反异常 - @Validated
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleConstraintViolationException(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        log.warn("约束违反异常: {}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("非法参数异常: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), e.getMessage(), null);
    }

    /**
     * 处理运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleRuntimeException(RuntimeException e) {
        logException("运行时异常", e);
        return Result.fail(Result.HTTP_INTERNAL_ERROR, "USER99001", "系统繁忙，请稍后再试", null);
    }

    /**
     * 处理一般异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleException(Exception e) {
        logException("系统异常", e);
        return Result.fail(Result.HTTP_INTERNAL_ERROR, "USER99999", "系统异常，请联系管理员", null);
    }

    /**
     * 处理HTTP消息不可读异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.info("HTTP消息不可读: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.JSON_FORMAT_ERROR);
    }

    /**
     * 处理缺少请求头异常
     */
    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleMissingRequestHeaderException(MissingRequestHeaderException e) {
        log.info("缺少请求头: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.BAD_REQUEST.getCode(), "缺少请求头: " + e.getHeaderName(), null);
    }
    
    /**
     * 处理请求方法不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.info("请求方法不支持: {}", e.getMessage());
        return Result.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), "USER00405", "请求方法不支持: " + e.getMethod(), null);
    }
    
    /**
     * 处理媒体类型不支持异常
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public Result<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.info("媒体类型不支持: {}", e.getMessage());
        return Result.fail(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "USER00415", "媒体类型不支持: " + e.getContentType(), null);
    }
    
    /**
     * 处理媒体类型不接受异常
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Result<Object> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
        log.info("媒体类型不接受: {}", e.getMessage());
        return Result.fail(HttpStatus.NOT_ACCEPTABLE.value(), "USER00406", "媒体类型不接受", null);
    }
    
    /**
     * 处理缺少路径变量异常
     */
    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleMissingPathVariableException(MissingPathVariableException e) {
        log.info("缺少路径变量: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, "USER00410", "缺少路径变量: " + e.getVariableName(), null);
    }
    
    /**
     * 处理缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.info("缺少请求参数: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, "USER00411", "缺少请求参数: " + e.getParameterName(), null);
    }
    
    /**
     * 处理类型不匹配异常
     */
    @ExceptionHandler({TypeMismatchException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleTypeMismatchException(Exception e) {
        log.info("类型不匹配: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, "USER00412", "参数类型不匹配: " + e.getMessage(), null);
    }
    
    /**
     * 处理缺少Servlet请求部分异常
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        log.info("缺少请求部分: {}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, "USER00413", "缺少请求部分: " + e.getRequestPartName(), null);
    }
    
    /**
     * 处理资源未找到异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<Object> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.info("资源未找到: {}", e.getMessage());
        return Result.notFound();
    }
    
    /**
     * 处理文件上传大小超限异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public Result<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.info("文件上传大小超限: {}", e.getMessage());
        return Result.fail(HttpStatus.PAYLOAD_TOO_LARGE.value(), "USER00413", "上传文件过大", null);
    }
    
    /**
     * 处理转换不支持异常
     */
    @ExceptionHandler(ConversionNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleConversionNotSupportedException(ConversionNotSupportedException e) {
        logException("转换不支持异常", e);
        return Result.fail(Result.HTTP_INTERNAL_ERROR, "USER99002", "数据转换异常", null);
    }
}