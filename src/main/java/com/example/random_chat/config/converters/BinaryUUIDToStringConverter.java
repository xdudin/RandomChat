package com.example.random_chat.config.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

@ReadingConverter
public class BinaryUUIDToStringConverter implements Converter<byte[], UUID> {

    @Override
    public UUID convert(byte[] source) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(source);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}
