package com.zhangnx.tools.utils;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


@ApiModel(description = "返回信息")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;
    @ApiModelProperty("承载数据")
    private T data;
    @ApiModelProperty(value = "返回消息", required = true)
    private String msg;


    public R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = true;
    }


    private R(int code) {
        this(code, null, ResultCode.getNameByCode(code));
    }

    private R(int code, String msg) {
        this(code,null, msg);
    }

    private R(int code, T data) {
        this(code, data, ResultCode.getNameByCode(code));
    }

    public static <T> R<T> data(T data) {
        return data(data, "操作成功");
    }

    public static <T> R<T> data(T data, String msg) {
        return data(200, data, msg);
    }

    public static <T> R<T> data(int code, T data, String msg) {
        return new R(code, data, data == null ? "暂无承载数据" : msg);
    }

    public static <T> R<T> success(String msg) {
        return new R(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> success(int code) {
        return new R(code);
    }

    public static <T> R<T> success(int code, String msg) {
        return new R(code, msg);
    }

    public static <T> R<T> fail(String msg) {
        return new R(ResultCode.FAILURE.getCode(), msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return new R(code, (Object)null, msg);
    }

    public static <T> R<T> fail(int resultCode) {
        return new R(resultCode);
    }

    public static <T> R<T> status(boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }

    public int getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public R() {
    }


    public enum ResultCode {
        SUCCESS(200, "操作成功"),
        FAILURE(400, "业务异常"),
        UN_AUTHORIZED(401, "请求未授权"),
        CLIENT_UN_AUTHORIZED(401, "客户端请求未授权"),
        NOT_FOUND(404, "404 没找到请求"),
        MSG_NOT_READABLE(400, "消息不能读取"),
        METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),
        MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),
        REQ_REJECT(403, "请求被拒绝"),
        INTERNAL_SERVER_ERROR(500, "服务器异常"),
        PARAM_MISS(400, "缺少必要的请求参数"),
        PARAM_TYPE_ERROR(400, "请求参数类型错误"),
        PARAM_BIND_ERROR(400, "请求参数绑定错误"),
        PARAM_VALID_ERROR(400, "参数校验失败");

        final int code;
        final String name;

        ResultCode(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code) {
            for (ResultCode en : ResultCode.values()) {
                if (en.getCode() == code) {
                    return en.getName();
                }
            }
            return null;
        }
    }
}