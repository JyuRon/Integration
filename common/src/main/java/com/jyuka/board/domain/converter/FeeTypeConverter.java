package com.jyuka.board.domain.converter;

import com.jyuka.board.constant.FeeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FeeTypeConverter implements AttributeConverter<FeeType, String> {
    @Override
    public String convertToDatabaseColumn(FeeType attribute) {
        return attribute.name();
    }

    @Override
    public FeeType convertToEntityAttribute(String dbData) {
        return FeeType.valueOf(dbData);
    }
}
