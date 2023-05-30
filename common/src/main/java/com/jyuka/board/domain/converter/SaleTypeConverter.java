package com.jyuka.board.domain.converter;

import com.jyuka.board.constant.SaleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SaleTypeConverter implements AttributeConverter<SaleType, String> {
    @Override
    public String convertToDatabaseColumn(SaleType attribute) {
        return attribute.getName();
    }

    @Override
    public SaleType convertToEntityAttribute(String dbData) {
        return SaleType.valueOf(dbData);
    }
}
