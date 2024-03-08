package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:58
 * MailSendEntity 描述
 */
@Data
@TableName("mail_send_log")
public class MailSendEntity {
    private String msgId;
    private Integer empId;
    //0 消息投递中   1 投递成功   2投递失败
    private Integer status;
    private String routeKey;
    private String exchange;
    private Integer count;
    private Date tryTime;
    private Date createTime;
    private Date updateTime;
}