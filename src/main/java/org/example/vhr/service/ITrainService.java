package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.TrainEntity;
import org.example.vhr.model.vo.TrainVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:42
 * ITrainService 描述
 */
public interface ITrainService extends IService<TrainEntity> {

    IPage<TrainVo> getPageList(Long current, Long size, TrainVo trainVo);
}
