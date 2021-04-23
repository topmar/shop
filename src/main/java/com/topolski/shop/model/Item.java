package com.topolski.shop.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
public class Item {
    private final String name;
    private final BigDecimal price;
    private final int tax;
    private final int discount;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTax() {
        return price.multiply(BigDecimal.valueOf(tax))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public int getDiscount() {
        return discount;
    }

    public BigDecimal getDiscountPrice() {
        return price.subtract(price.multiply(BigDecimal.valueOf(discount))
                .divide(BigDecimal.valueOf(100))
                .setScale(2,RoundingMode.HALF_UP));
    }

    public BigDecimal getDiscountTax() {
        return getDiscountPrice().multiply(BigDecimal.valueOf(tax))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }

}
