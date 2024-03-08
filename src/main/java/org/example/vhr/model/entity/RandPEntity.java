package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 16:00
 * RandPEntity 描述
 */
@Data
@TableName("emp_rewardandpunish")
public class RandPEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * eid 员工id
     */
    private Integer eid;

    /**
     * 奖惩时间
     */
    private Date ecDate;

    /**
     * 原因
     */
    private String ecReason;

    /**
     * 奖惩分数
     */
    private Integer ecPoint;

    /**
     * 类型
     */
    private String ecType;

    /**
     * 备注
     */
    private String remark;

    @TableLogic
    private Integer delFlag;

}