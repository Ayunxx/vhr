package org.example.vhr.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:46
 * EmployeeVo 描述
 */
@Data
public class EmployeeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private Integer id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 婚姻状况
     */
    private String wedlock;
    /**
     * 民族
     */
    private Integer nationId;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门
     */
    private String departmentName;
    /**
     * 职称ID
     */
    private String jobLevelName;
    /**
     * 职位ID
     */
    private String posName;
    /**
     * 聘用形式
     */
    private String engageForm;
    /**
     * 最高学历
     */
    private String tiptopDegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期
     */
    private Date beginDate;
    /**
     * 在职状态
     */
    private String workState;
    /**
     * 工号
     */
    private String workId;
    /**
     * 合同期限
     */
    private String contractTerm;
    /**
     * 转正日期
     */
    private Date conversionTime;
    /**
     * 离职日期
     */
    private Date notworkDate;
    /**
     * 合同起始日期
     */
    private Date beginContract;
    /**
     * 合同终止日期
     */
    private Date endContract;
    /**
     * 工龄
     */
    private Integer workAge;

    //民族名称
    private String nationName;

    private String polName;

}
