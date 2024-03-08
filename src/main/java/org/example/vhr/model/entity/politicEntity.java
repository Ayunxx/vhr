package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 阿运
 * @date 2024/3/8 11:47
 * politicEntity 描述
 */

@Data
@TableName("politicsstatus")
public class politicEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;



}