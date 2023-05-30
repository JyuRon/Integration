package com.jyuka.board.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DistributionType {
    NOT_RECEIVED("미수령"),
    RECEIVE("수령"),
    ABSENCE("미참여")
    ;

    private final String name;
}
