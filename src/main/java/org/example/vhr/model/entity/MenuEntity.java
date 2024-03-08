package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/5 0:57
 * MenuEntity 描述
 */
@Data
@TableName("menu")
public class MenuEntity implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String component;

    private String path;

    private String status;

    private String perms;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private  Date updateTime;

    private String remark;

    @TableLogic
    private Integer delFlag;


}