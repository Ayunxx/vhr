package org.example.vhr.model.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 阿运
 * @date 2024/3/7 15:47
 * RoleVo 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id;

    private String roleName;

    private String roleKey;

    private Integer status;


    private String remark;

    @TableLogic
    private Integer delFlag;

}