package com.topolski.shop.model;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class Basket {
    List<Item> items;

    public Basket() {
        items = new LinkedList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public BigDecimal getPriceSum() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getTaxSum() {
        return items.stream()
                .map(Item::getTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getDiscountSum() {
        return items.stream()
                .map(Item::getDiscountPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getDiscountTaxSum() {
        return items.stream()
                .map(Item::getDiscountTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
