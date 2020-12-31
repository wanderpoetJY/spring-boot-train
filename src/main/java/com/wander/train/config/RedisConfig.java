//package com.wander.train.config;
//
//import java.util.LinkedHashSet;
//import java.util.List;
//
//import com.wander.train.pojo.Example;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
//import org.springframework.boot.autoconfigure.cache.CacheProperties;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
///**
// * redis配置类
// *
// * @author admin 2020/12/24/ 15:46
// */
//@Configuration
//public class RedisConfig {
//
//    //redis默认使用的是jdk系列化，这个配置可以针对某一类进行自己进行自己想要的序列化。
//
//    @Bean
//    public RedisTemplate<Object, Example> exampleRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Example> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Example.class));
//        return template;
//    }
//
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//        return template;
//    }
//
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration() {
//        RedisSerializer<Example> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Example.class);
//        RedisSerializationContext.SerializationPair<Example> serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);
//        return RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(serializationPair);
//    }
//
//
//
//    @Primary
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
//                .cacheDefaults(redisCacheConfiguration());
//        return builder.build();
//    }
//
//
//
//}
//
