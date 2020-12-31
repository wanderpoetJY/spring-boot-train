package com.wander.train;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import com.wander.train.mapper.ExampleMapper;
import com.wander.train.pojo.Example;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class TrainApplicationTests {

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;


//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @Autowired
//    RedisTemplate exampleRedisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    //管理队列，交换机信息
    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
    }

    @Test
    void test01() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

//    @Test
//    public void test02() {
//        stringRedisTemplate.opsForValue().set("test", "hhhhhh");
//    }
//
//    @Test
//    public void test03() {
//        System.out.println(stringRedisTemplate.opsForValue().get("test"));
//    }
//
//    @Test
//    public  void test04(){
//        redisTemplate.opsForValue().set("example1", new Example(17,"李四"));
//    }


    @Test
    public  void test05(){
        rabbitTemplate.convertAndSend("exchange.direct","wander","第二个测试");
    }

    @Test
    public void test06(){
        System.out.println(rabbitTemplate.receiveAndConvert("wander"));
    }

    @Test
    public void test07(){
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("154694103@qq.com");
        simpleMailMessage.setTo("17585698212@163.com");
        simpleMailMessage.setSubject("测试邮件");
        simpleMailMessage.setText("恭喜你，测试成功了!");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void test08() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("测试邮件");
        mimeMessageHelper.setText("第一次测试，测试成功");

        //上传附件
        mimeMessageHelper.addAttachment("测试", new File("E:\\壁纸\\wallhaven-wyo8g6-scaled.jpg"));

        mimeMessageHelper.setFrom("154694103@qq.com");
        mimeMessageHelper.setTo("17585698212@163.com");

        javaMailSender.send(mimeMessage);
    }
}

