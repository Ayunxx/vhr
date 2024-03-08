package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.EmployeeMapper;
import org.example.vhr.model.entity.*;
import org.example.vhr.model.vo.EmployeeVo;
import org.example.vhr.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 18:25
 * EmployeeServiceImpl 描述
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeEntity checkWorkId(EmployeeEntity employeeEntity) {
        String workid = employeeEntity.getWorkID();
        Boolean flag = employeeMapper.getWorkId(workid);
        if (flag==null){
            return employeeEntity;
        } else {
            return null;
        }
    }

    @Override
    public IPage<EmployeeVo> getListPage(Long current, Long size, EmployeeVo employeeVo) {


        //构建条件
        String workid = employeeVo.getWorkId();
        String name = employeeVo.getName();
        QueryWrapper<EmployeeEntity> employeeEntityQueryWrapper = new QueryWrapper<>();
        employeeEntityQueryWrapper.eq("del_flag",0);
        if (StringUtils.hasText(workid)) {
            employeeEntityQueryWrapper.like("e.workID",workid);
        }
        if (StringUtils.hasText(name)) {
            employeeEntityQueryWrapper.like("e.name",name);
        }
        Page<EmployeeEntity> entityPage = new Page<>(current,size);
        return employeeMapper.getList(entityPage,employeeEntityQueryWrapper);
    }

    @Override
    public List<NationEntity> getNation() {

        return employeeMapper.getNationList();
    }

    @Override
    public List<DepartmentEntity> getDepartment() {

        return employeeMapper.getDepartmentList();
    }

    @Override
    public List<JobLevelEntity> getJobLevel() {
        return employeeMapper.getJobLevelList();
    }

    @Override
    public List<PositionEntity> getPosition() {
        return employeeMapper.getPositionList();
    }


}