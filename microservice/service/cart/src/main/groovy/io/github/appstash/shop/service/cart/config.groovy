package io.github.appstash.shop.service.cart

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
@EnableAutoConfiguration
@ComponentScan
class ApplicationConfiguration extends WebMvcConfigurationSupport {

    @Bean
    RedisConnectionFactory connectionFactory(){
        new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate() {
        new StringRedisTemplate(connectionFactory())
    }
}