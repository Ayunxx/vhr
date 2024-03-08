package org.example.vhr.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:30
 * AssessmentVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentVo implements Serializable {
    private final static long serialVersionUID = 1L;

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

    private String name;

    private String workId;
}