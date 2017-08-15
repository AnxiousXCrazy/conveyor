package net.uchoice.conveyor.modules.rest;

import com.alibaba.fastjson.JSON;
import net.uchoice.conveyor.modules.rest.vo.*;
import net.uchoice.conveyor.modules.template.entity.ConveyorMsgTemplate;
import net.uchoice.conveyor.modules.template.service.ConveyorMsgTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2017/8/14.
 */
@RestController
@RequestMapping("/sender")
public class MCenterRestController {

    private final Logger logger = LoggerFactory.getLogger(MCenterRestController.class);
    @Autowired
    private ConveyorMsgTemplateService conveyorMsgTemplateService;
    /**
     * @param param {@link TokenParam}
     * @return
     */
    @RequestMapping(value = "token",method = RequestMethod.POST)
    public String token(@RequestParam(value = "param",required = true) String param){
        if(null == param){
            return JSON.toJSONString(Result.fail(404,"request param is null."));
        }
        try {
            TokenParam tokenParam = JSON.parseObject(param, TokenParam.class);
            if(null == tokenParam){
                throw new NullPointerException("TokenParam is null.");
            }
            ConveyorMsgTemplate conveyorMsgTemplate = conveyorMsgTemplateService.get(tokenParam.getTempleteId());
            if(null == conveyorMsgTemplate){
                throw new NullPointerException("Message Templete is null.");
            }
            //conveyorMsgTemplate.getAuditStatus()
            //@TODO 1.检查模板审核状态，禁用状态，有效期状态
            //@TODO 2.审核发送人的用户状态，是否有用该模板的权限

            String token = UUID.randomUUID().toString();//token局部缓存，有效期5分钟 key:templeteId value=token,活跃时更新date
            TokenMemo.compareAndUpdate(TokenValue.instance(conveyorMsgTemplate.getId(),token,new Date()));
            return JSON.toJSONString(Result.success(token));
        }catch (Exception e){
            logger.error("Mcenter token Err,Param:{},Exception:{}",param,e);
            return JSON.toJSONString(Result.fail(500,e.getMessage()));
        }
    }
    @RequestMapping(value = "send",method = RequestMethod.POST)
    public String send(@RequestParam(value = "param",required = true) String param){
        if(null == param){
            return JSON.toJSONString(Result.fail(404,"request param is null."));
        }
        try{
            /**
             * 1.验证请求参数(token,templeteId, md5)
             * 2.生成消息事件，并存储
             * 3.将消息扔进消息处理队列
             * 4.返回消息ID，并返回消息状态，已成功接收，通过回调地址 实现 消息处理成功/失败的通知  ps：实时消息，是否应该实时处理，而非等待队列？
             */
            SendParam sendParam = JSON.parseObject(param,SendParam.class);
            if(null == sendParam){
                throw new NullPointerException("SendParam is null.");
            }
            //请求参数基本验证 @TODO
            //@TODO  token templeteId md5验证
            TokenValue tokenValue = TokenMemo.get(sendParam.getTempleteId());
            if(null == tokenValue){//请求session过期，需要重新获取token
                // return
            }
            //超过5分钟
            if(((new Date()).getTime() - 5*50*1000) > tokenValue.getDelayDate().getTime()){
                TokenMemo.remove(sendParam.getTempleteId());
                // return
            }
            //模板ID匹配不上，
            if(!tokenValue.getTempleteId().equals(sendParam.getTempleteId())){
                // return
            }
            if(!MD5Utils.checkMD5Str(sendParam.getTempleteId(),sendParam.getContent(),sendParam.getMd5Str())){
               // return
            }
        }catch (Exception e){

        }
        return null;//返回处理成功/失败状态信息
    }

}
