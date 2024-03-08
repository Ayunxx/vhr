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
 * @date 2024/3/7 15:39
 * ChangeJobEntity 描述
 */
@Data
@TableName("emp_changejob")
public class ChangeJobEntity implements Serializable {
    private final static long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 调整后的部门
     */
    private Integer afterDepId;

    /**
     * 调整后的职位
     */
    private Integer afterPosId;

    /**
     * 调整时间
     */
    private Date removeDate;

    /**
     * 调整原因
     */
    private  String reason;

    /**
     * 备注
     */
    private String remark;

    @TableLogic
    private Integer delFlag;

}
