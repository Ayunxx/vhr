package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.entity.TrainEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.TrainVo;
import org.example.vhr.service.ITrainService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 18:42
 * TrainController 描述
 */
@RestController
@RequestMapping("/train")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:train')")
public class TrainController {

    @Resource
    private ITrainService trainService;


    /**
     * 获取全部培训记录
     */
    @PreAuthorize("hasAnyAuthority('system:train:list','system:train')")
    @PostMapping("/getTrainList/{current}/{size}")
    public Result getTrainList(@PathVariable Long current,
                               @PathVariable Long size,
                               @RequestBody TrainVo trainVo

    ){

        IPage<TrainVo> pageList = trainService.getPageList(current, size,trainVo);


        return Result.ok(pageList);
    }


    /**
     * 添加
     * @param trainEntity 前端传过来的对象
     * @return
     */
    @PostMapping("/addTrain")
    public Result addTrain(@RequestBody TrainEntity trainEntity){

        boolean flag = trainService.save(trainEntity);

        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteTrainById/{id}")
    public Result deleteTrainById(@PathVariable Integer id){

        boolean flag = trainService.removeById(id);

        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getTrainById/{id}")
    public Result getTrainById(@PathVariable Integer id) {
        TrainEntity trainEntityById = trainService.getById(id);

        return Result.ok(trainEntityById);
    }

    /**
     * 修改
     * @param trainEntity
     * @return
     */
    @PostMapping("/updateTrain")
    public Result updateTrain(@RequestBody TrainEntity trainEntity){

        boolean flag = trainService.updateById(trainEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
