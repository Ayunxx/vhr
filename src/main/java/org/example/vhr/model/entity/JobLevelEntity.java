package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:57
 * JobLevelEntity 描述
 */
@Data
@TableName("joblevel")
public class JobLevelEntity implements Serializable {
    private final static long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 职称级别
     */
    private String titleLevel;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 是否扩建
     */
    private Integer enabled;

}