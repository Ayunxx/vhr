package org.example.vhr;

import jakarta.annotation.Resource;
import org.example.vhr.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VhrApplicationTests {

    @Resource
    JwtUtils jwtUtils;
    @Test
    void contextLoads() {
    }


    @Test
    void jwt() {
        System.out.println(jwtUtils);
    }


}
