package org.example.vhr.model.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 阿运
 * @date 2024/3/5 0:15
 * HrEntity 描述
 */



@Data
@TableName("hr")
public class HrEntity {
    /**
     * hrId
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String hrName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 住宅电话
     */
    private String telephone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 账户是否可用
     */
    private  Integer status;

    /**
     * 用户名
     */
    private  String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String userface;

    /**
     * 备注
     * */
    private String remark;

    @TableLogic
    private Integer delFlag;
}
