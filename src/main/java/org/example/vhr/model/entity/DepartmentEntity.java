package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/7 15:55
 * DepartmentEntity 描述
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("department")
public class DepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id 自增
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id
     */
    private Integer parentId;
    /**
     * 部门path
     */
    private String departPath;
    /**
     * 是否可用
     */
    private Integer enabled;
    /**
     * 是否为父部们
     */
    private Integer isParent;

    private Date createTime;

    private Date upDateTime;

    @TableLogic
    private Integer delFlag;

}