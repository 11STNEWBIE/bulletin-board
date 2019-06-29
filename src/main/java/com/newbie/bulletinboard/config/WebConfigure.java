package com.newbie.bulletinboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        var converter = new ObjectConverter();
        var mediaType = new MediaType("application", "x-www-form-urlencoded", Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                mediaType,
                MediaType.APPLICATION_JSON_UTF8_VALUE
                ));
        converters.add(new ObjectConverter());
    }
}
