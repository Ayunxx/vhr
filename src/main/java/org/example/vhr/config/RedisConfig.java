package org.example.vhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;

/**
 * @author 阿运
 * @date 2024/2/29 23:23
 * RedisConfig Redis配置类 用于配置RedisTemplate，以便在应用中方便地操作Redis
 */

@Configuration // 表明这是一个Spring配置类
public class RedisConfig {

    // 定义一个Bean，返回配置好的RedisTemplate实例
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        // 创建一个泛型为<String, Object>的RedisTemplate实例
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置连接工厂，这允许RedisTemplate与Redis数据库建立连接
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 创建JSON序列化器，用于序列化value值，以便于存储更复杂的对象结构
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        // 设置键（key）的序列化方式为字符串序列化
        redisTemplate.setKeySerializer(RedisSerializer.string());
        // 设置哈希键（hash key）的序列化方式也为字符串序列化
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        // 设置值（value）的序列化方式为JSON序列化，以支持对象等复杂类型的存储
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        // 设置哈希值（hash value）的序列化方式也为JSON序列化
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        // 返回配置好的RedisTemplate实例
        return redisTemplate;
    }
}