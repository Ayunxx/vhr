package org.example.vhr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.HrEntity;
import org.example.vhr.model.vo.HrVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/4 23:26
 * IHrService 描述
 */
public interface IHrService extends IService<HrEntity>, UserDetailsService {


    List<HrVo> getUserList();

    HrEntity encryption(HrEntity hrEntity);
}
