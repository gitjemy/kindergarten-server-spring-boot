package com.jems.Kindergarten.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jems.Kindergarten.model.KidDetail;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Component
@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<KidDetail, String> {

    public final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(KidDetail meta) {
        try {
            return objectMapper.writeValueAsString(meta);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public KidDetail convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, KidDetail.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }

}