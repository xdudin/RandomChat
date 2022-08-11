package com.example.random_chat.config.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.charset.StandardCharsets;

@ReadingConverter
public class ByteArrayToStringConverter implements Converter<byte[], String> {

    @Override
    public String convert(byte[] source) {
        return new String(source, StandardCharsets.US_ASCII);
    }
}
