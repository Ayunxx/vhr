package org.example.vhr.model.entity;

/**
 * @author 阿运
 * @date 2024/3/7 15:58
 * MailConstants 描述
 */
public class MailConstants {
    public static final Integer DELIVERING = 0;//消息投递中
    public static final Integer SUCCESS = 1;//消息投递成功
    public static final Integer FAILURE = 2;//消息投递失败
    public static final Integer MAX_TRY_COUNT = 3;//最大重试次数
    public static final Integer MSG_TIMEOUT = 1;//消息超时时间
    public static final String MAIL_QUEUE_NAME = "ayun.mail.queue";
    public static final String MAIL_EXCHANGE_NAME = "ayun.mail.exchange";
    public static final String MAIL_ROUTING_KEY_NAME = "ayun.mail.routing.key";
}