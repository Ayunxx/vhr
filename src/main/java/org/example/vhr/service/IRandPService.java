package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.RandPEntity;
import org.example.vhr.model.vo.RandPVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:34
 * IRandPService 描述
 */
public interface IRandPService extends IService<RandPEntity> {

    IPage<RandPVo> getPage(Long current, Long size, RandPVo randPVo);
}
