package net.uchoice.conveyor.modules.rest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/15.
 */
@Data
public class TokenParam implements Serializable {

    private String templeteId;//信息模版ID
    private String userName;//用户名
    private String password;//密码
    private String authKey;//申请成功后，给等key
}
