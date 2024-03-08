package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 阿运
 * @date 2024/3/8 13:44
 * EmpSalaryEntity 描述
 */

@Data
@TableName("emp_salary")
public class EmpSalaryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer eid;

    private Integer sid;
}