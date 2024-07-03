package com.fffx.project.common;


import lombok.Data;
import lombok.Getter;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回给前端数据的统一包装
 * @param <T> 基本类型或vo类
 */
@ApiModel(description = "统一的response")
@Data
public class Response<T> {

    @ApiModelProperty(value = "状态码", required = true, example = "0", allowableValues = "range[0, infinity]")
    private int code;

    @ApiModelProperty(value = "响应信息", required = true, example = "success")
    private String msg;

    @ApiModelProperty(value = "返回的数据")
    private T data;


    public Response(ResponseStatus status) {
        this(status, status.getMsg());
    }

    public Response(ResponseStatus status, String msg) {
        this.code = status.getCode();
        this.msg = StringUtils.isNotBlank(msg) ? msg : status.getMsg();
    }

    public Response<T> addStatusAndMsg(ResponseStatus status, String msg) {
        add(null, status, msg);
        return this;
    }

    public Response<T> add(T data, ResponseStatus status, String msg) {
        if (data != null) this.data = data;
        this.code = status.getCode();
        this.msg = StringUtils.isNotBlank(msg) ? msg : status.getMsg();
        return this;
    }

    public enum ResponseStatus {

        FAILED(-1, "failed"),

        /**
         * 0 ~ 100
         */
        SUCCESS(0, "success"),
        NO_PERMISSION(30, "没有权限"),
        FORBIDDEN_OPERATOR(40, "禁止操作"),
        PARSER_ERR(50, "解析异常"),

        /**
         * 100 ~ 400 参数相关异常
         */
        PARAM_ERR(101, "参数异常"),
        SERVER_PARAM_ERR(105, "服务参数异常"),
        PARAM_NULL_ERR(110, "入参为空"),
        NETWORK_ERR(112, "网络相关异常"),
        NOT_SUPPORT_ENGINE(121, "当前操作不支持该接口"),
        NOT_SUPPORT(122, "不支持操作"),

        /**
         * 500 ~ 800 系统相关异常
         */
        TIMEOUT_ERR(501, "调用超时"),
        DB_OP_ERR(502, "数据库操作异常"),
        DB_DATA_ERR(503, "数据库数据异常"),
        REFRESH_ERR(506, "刷新数据异常"),
        HTTP_EXECUTE_ERR(515, "HTTP请求异常"),
        THIRD_PART_EXCEPTION(525, "第三方组件异常"),
        SERVER_BUSY(540, "当前服务忙"),

        /**
         * 未知异常，用于兜底
         */
        UNKNOWN_ERR(-100, "未知异常"),
        ;

        @Getter
        private int code;
        @Getter
        private String msg;

        ResponseStatus(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static ResponseStatus valueOfCode(int code) {
            for (ResponseStatus value : ResponseStatus.values()) {
                if (value.code == code) {
                    return value;
                }
            }
            return UNKNOWN_ERR;
        }
    }
}
