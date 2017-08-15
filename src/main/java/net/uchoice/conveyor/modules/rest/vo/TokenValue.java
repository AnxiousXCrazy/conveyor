package net.uchoice.conveyor.modules.rest.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by admin on 2017/8/15.
 */
@Data
public class TokenValue {
    private String templeteId;
    private String token;
    private Date delayDate;//5分钟失效，活跃一次，更新一次该时间

    public static TokenValue instance(String templeteId,String token,Date delayDate){
        TokenValue tokenValue = new TokenValue();
        tokenValue.setDelayDate(delayDate);
        tokenValue.setTempleteId(templeteId);
        tokenValue.setToken(token);
        return tokenValue;
    }
}
