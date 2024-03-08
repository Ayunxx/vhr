package org.example.vhr.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:37
 * ChangeJobVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeJobVo implements Serializable {
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
    private Integer afterJobId;

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

    private String name;

    private String workId;

    private String afterDepartName;

    private String afterJobName;

    private String beforeDepartName;

    private String beforeJobName;
}