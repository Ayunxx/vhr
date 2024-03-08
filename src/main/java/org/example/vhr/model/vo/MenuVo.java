package org.example.vhr.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/5 0:55
 * MenuVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo implements Serializable {
    private final static long serialVersionUID = 1L;

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

    private String roleId;

    private String menuId;

    private String roleName;

    private String roleKey;
}

