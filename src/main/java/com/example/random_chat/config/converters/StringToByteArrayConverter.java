package com.example.random_chat.config.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.nio.charset.StandardCharsets;

@WritingConverter
public class StringToByteArrayConverter implements Converter<String, byte[]> {

    @Override
    public byte[] convert(String source) {
        return source.getBytes(StandardCharsets.US_ASCII);
    }
}
