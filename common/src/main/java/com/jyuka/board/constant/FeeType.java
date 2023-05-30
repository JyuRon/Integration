package com.jyuka.board.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum FeeType {

    DIRECT("유저간 교환", BigDecimal.valueOf(0.1)),
    NORMAL("일반(5%)", BigDecimal.valueOf(0.05)),
    MVP("PC방,MVP(3%)", BigDecimal.valueOf(0.03))
    ;

    private final String feeName;
    private final BigDecimal fee;
}
