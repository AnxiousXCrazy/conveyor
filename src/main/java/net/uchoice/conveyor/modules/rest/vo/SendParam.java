package net.uchoice.conveyor.modules.rest.vo;

import lombok.Data;
import org.w3c.dom.ranges.Range;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */
@Data
public class SendParam extends AuthParam {


    private List<Recipients> recipients;//收件人列表
    private String[] senderModel;//投放类型,站内信 短信 邮件....
    private SendType sendType;//发送类型
    private String content;//消息体内容
    private String title;//邮箱和站内信都有标题
    private String level;//消息级别

    /**
     * 收件人
     */
    protected final class Recipients{
        private String name;//收件人姓名
        private String email;//收件人邮箱
        private long phone;//收件人手机
    }
    protected final class SendType{
        private boolean isRealTime;//是否实时
        private List<DateRange> dateRanges;//非实时，支持多个不同时间段投放，
        private String callBackUrl;//则需要一个回调调HTTP访问地址，参数 ?msgId=xxx && status=success/fail && desc=dada
    }
    protected final class DateRange{
        private Date startDate;
        private Date endDate;
    }
}
