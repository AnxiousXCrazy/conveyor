package net.uchoice.conveyor.modules.rest.vo;

import com.google.common.collect.Maps;
import org.apache.poi.ss.formula.functions.T;

import java.util.Date;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by admin on 2017/8/15.
 */
public final class TokenMemo {

    private final static ConcurrentMap<String,TokenValue> TOKEN_MEMO_CONCURRENT_MAP = Maps.newConcurrentMap();


    public static void compareAndUpdate(TokenValue tokenValue){
        TOKEN_MEMO_CONCURRENT_MAP.put(tokenValue.getTempleteId(),tokenValue);
    }

    public static TokenValue get(String key){
        return TOKEN_MEMO_CONCURRENT_MAP.containsKey(key) ? TOKEN_MEMO_CONCURRENT_MAP.get(key) : null;
    }
    public static void remove(String key){
        if(TOKEN_MEMO_CONCURRENT_MAP.containsKey(key)){
            TOKEN_MEMO_CONCURRENT_MAP.remove(key);
        }
    }
}
