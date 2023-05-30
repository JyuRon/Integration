package com.jyuka.board.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SaleType {
    WAIT("판매 대기"),
    ON("판매중"),
    COMPLETE("판매 완료")
    ;

    private final String name;
}
