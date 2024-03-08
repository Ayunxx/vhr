package org.example.vhr.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:46
 * RandPVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandPVo implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键id
     */
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

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 工号
     */
    private String workId;
}
