package com.example.fastjson1224;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2022/3/5 19:39
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 第一种实现方式
     * @param converters 转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        // 0、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 1、添加fastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
//WriteNullStringAsEmpty 这几个设置是返回null是还是给前端显示 不然fastjson默认不回显为null的字段
        fastConverter.setFastJsonConfig(fastJsonConfig);


        converters.add(fastConverter);
    }



}
