package org.example.vhr.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Resource;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.HrVo;
import org.example.vhr.service.IHrService;
import org.example.vhr.utils.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 阿运
 * @date 2024/3/7 18:29
 * HrController 描述
 */
@RestController
@CrossOrigin
public class HrController {

    @Resource
    JwtUtils jwtUtils;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @GetMapping("/hr/info")
    public Result info(@RequestParam String token){
        DecodedJWT verity;

//        //解析token
        try {
            verity = jwtUtils.resolveJwt(token);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        HrVo hrVo = jwtUtils.toHrVo(verity);
        String redisKey = "tokenId:" + hrVo.getId();
        HrVo loginUser = (HrVo) redisTemplate.opsForValue().get(redisKey);
        return Result.ok(loginUser);
    }

}