package org.example.vhr.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 阿运
 * @date 2024/3/7 15:48
 * SalaryVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryVo implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * eid 员工id
     */
    private Integer eid;

    /**
     * 基本工资
     */
    private Integer basicSalary;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 午餐补助
     */
    private Integer lunchSalary;

    /**
     * 交通补助
     */
    private Integer trafficSalary;

    /**
     * 应发工资
     */
    private Integer allSalary;

    private String remark;

    private String workID;

    private String empName;
}