package org.example.vhr.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 阿运
 * @date 2024/3/7 16:01
 * RoleMenuEntity 描述
 */

@Data
public class RoleMenuEntity implements Serializable {
    private  final  static  long serialVersionUID = 1L;

    private Integer roleId;

    private Integer menuId;

    private Integer status;

}