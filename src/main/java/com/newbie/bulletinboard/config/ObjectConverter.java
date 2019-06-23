package com.newbie.bulletinboard.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

public class ObjectConverter extends AbstractHttpMessageConverter {
    private static final FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected boolean supports(Class clazz) {
        return (MemberDTO.class == clazz);
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        var read = formHttpMessageConverter.read(null, inputMessage);
        return mapper.convertValue(read, MemberDTO.class);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
