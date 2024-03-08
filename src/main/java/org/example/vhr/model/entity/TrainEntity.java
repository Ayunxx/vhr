package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 16:02
 * TrainEntity 描述
 */
@Data
@TableName("emp_train")
public class TrainEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键 id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 培训日期
     */
    private Date trainDate;

    /**
     * 培训内容
     */
    private String trainContent;

    /**
     * 备注
     */
    private String remark;


    @TableField(exist = false)
    private String empName;

    @TableLogic
    private Integer delFlag;
}
