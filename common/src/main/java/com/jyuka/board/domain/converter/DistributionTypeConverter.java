package com.jyuka.board.domain.converter;

import com.jyuka.board.constant.DistributionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DistributionTypeConverter implements AttributeConverter<DistributionType, String> {
    @Override
    public String convertToDatabaseColumn(DistributionType attribute) {
        return attribute.name();
    }

    @Override
    public DistributionType convertToEntityAttribute(String dbData) {
        return DistributionType.valueOf(dbData);
    }
}
