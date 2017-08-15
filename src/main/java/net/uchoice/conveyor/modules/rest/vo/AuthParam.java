package net.uchoice.conveyor.modules.rest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/15.
 */
@Data
public class AuthParam implements Serializable {
    private String token;//回执token
    private String md5Str;//md5加密的信息
    private String templeteId;//模板ID
}
