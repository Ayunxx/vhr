package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:26
 * AssessmentEntity 描述
 */
@Data
@TableName("emp_assessment")
public class AssessmentEntity implements Serializable {
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
     * 考核时间
     */
    private Date appDate;

    /**
     * 考核结果
     */
    private String appResult;

    /**
     * 考核内容
     */
    private String appContent;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer delFlag;

}