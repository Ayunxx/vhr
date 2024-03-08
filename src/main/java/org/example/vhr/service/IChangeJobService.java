package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.ChangeJobEntity;
import org.example.vhr.model.vo.ChangeJobVo;

/**
 * @author 阿运
 * @date 2024/3/7 15:36
 * IChangeJobService 描述
 */
public interface IChangeJobService extends IService<ChangeJobEntity> {
    IPage<ChangeJobVo> getPage(Long current, Long size, ChangeJobVo changeJobVo);
}
