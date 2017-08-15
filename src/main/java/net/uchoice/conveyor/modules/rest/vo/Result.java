package net.uchoice.conveyor.modules.rest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/15.
 */
@Data
public class Result<T> implements Serializable{

    private int code;//状态码，错误码
    private boolean success;//是否成功
    private String description;//失败描述
    private T data;//数据对象

    public static Result create(){
        return new Result();
    }
    public static Result fail(int code,String description){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setDescription(description);
        return result;
    }
    public static <T>Result success(T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
}
