package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.*;
import org.example.vhr.model.vo.EmployeeVo;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 18:22
 * IEmployeeService 描述
 */
public interface IEmployeeService extends IService<EmployeeEntity> {


    EmployeeEntity checkWorkId(EmployeeEntity employeeEntity);


    IPage<EmployeeVo> getListPage(Long current, Long size, EmployeeVo employeeVo);

    List<NationEntity> getNation();

    List<DepartmentEntity> getDepartment();

    List<JobLevelEntity> getJobLevel();

    List<PositionEntity> getPosition();
}