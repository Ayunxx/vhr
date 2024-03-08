package org.example.vhr.model.result;

import lombok.Getter;

/**
 * @author 阿运
 * @date 2024/3/1 0:31
 * ResultCodeEnum
 * 枚举定义了API操作的结果状态码及其对应的描述信息。
 * 通过这些预定义的状态码和消息，可以统一API响应格式，提高接口的可读性和易用性。
 */

@Getter
public enum ResultCodeEnum {
    // 操作成功
    SUCCESS(200, "成功"),
    // 操作失败
    FAIL(201, "失败"),
    // 参数错误
    PARAM_ERROR(202, "参数不正确"),
    // 服务端异常
    SERVICE_ERROR(203, "服务异常"),
    // 数据异常
    DATA_ERROR(204, "数据异常"),
    // 数据版本异常，通常用于乐观锁在并发更新时
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    // 用户未登录
    LOGIN_AUTH(208, "未登录"),
    // 权限不足
    PERMISSION(209, "没有权限"),

    // 验证码错误
    CODE_ERROR(210, "验证码错误"),

    // 用户认证失败，需要重新登录
    UNAUTHORIZED(401, "用户认证失败，请重新登录"),

    // 用户权限不足，禁止访问
    FORBIDDEN(403, "您的权限不足，无法访问");

    // 状态码
    private final Integer code;
    // 对应的消息文本
    private final String message;

    // 枚举构造函数，用于初始化每个枚举实例的状态码和消息
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
