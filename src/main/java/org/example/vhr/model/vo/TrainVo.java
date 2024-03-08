package org.example.vhr.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:49
 * TrainVo 描述
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
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

    /**
     * 员工姓名
     */
    private String empName;


    private String workId;
}