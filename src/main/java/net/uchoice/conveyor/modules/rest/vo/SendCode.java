package net.uchoice.conveyor.modules.rest.vo;

/**
 * Created by admin on 2017/8/15.
 */
public enum  SendCode {
    SUCCESS(200,"处理成功.");

    private int code;
    private String description;

    private SendCode(int code,String description){
        this.code = code;
        this.description = description;
    }
}
