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
 * @date 2024/3/7 15:52
 * ChangeSalaryEntity 描述
 */
@Data
@TableName("sal_changesalary")
public class ChangeSalaryEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 调薪日期
     */
    private Date asDate;

    /**
     * 调前薪资
     */
    private Integer beforeSalary;

    /**
     * 调后薪资
     */
    private Integer afterSalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;

    @TableLogic
    private Integer delFlag;

}