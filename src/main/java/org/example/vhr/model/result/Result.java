package org.example.vhr.model.result;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import lombok.Data;

/**
 * @author 阿运
 * @date 2024/3/1 0:30
 * Result 通用响应体封装类。
 * @param <T> 响应数据的类型
 */


@Data
//@ApiModel(value = "全局统一返回结果")
public class Result<T> {

    //@ApiModelProperty(value = "返回码")
    private Integer code;

    //@ApiModelProperty(value = "返回消息")
    private String message;

    //@ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){}

    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> build(Integer code, String message) {
        Result<T> result = build(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    /**
     * 操作成功
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    public static<T> Result<T> UNAUTHORIZED(T data){
        Result<T> result = build(data);
        return build(data,ResultCodeEnum.UNAUTHORIZED);
    }

    public static<T> Result<T> FORBIDDEN(T data){
        Result<T> result = build(data);
        return build(null,ResultCodeEnum.FORBIDDEN);
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    public boolean isOk() {
        if(this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue()) {
            return true;
        }
        return false;
    }

    public String asJson() {
        return JSON.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
