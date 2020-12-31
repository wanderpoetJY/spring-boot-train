package com.wander.train.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * druid数据源配置
 *
 * @author admin 2020/12/23/ 10:11
 */
@Configuration
public class DruidConfig {

    //配置数据池

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDatasource(){
        return new DruidDataSource();
    }

    //配置Druid监控：（1）配置管理后台的servlet；（2)配置监控的filter

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){

        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow", "");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js, *.css, /druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
