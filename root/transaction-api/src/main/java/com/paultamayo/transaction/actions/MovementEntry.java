package com.paultamayo.transaction.actions;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record MovementEntry(Long numberAccount, BigDecimal value) {
}
