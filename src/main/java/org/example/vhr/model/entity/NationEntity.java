package org.example.vhr.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 阿运
 * @date 2024/3/7 15:59
 * NationEntity 描述
 */
@Data
@TableName("nation")
public class NationEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id;

    private String name;
}
