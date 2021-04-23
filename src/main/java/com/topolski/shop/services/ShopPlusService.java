package com.topolski.shop.services;

import com.topolski.shop.model.Basket;
import com.topolski.shop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Service
@Profile("plus")
public class ShopPlusService implements Shop{
    @Value("${minPriceValue}")
    private int minPriceValue;
    @Value("${maxPriceValue}")
    private int maxPriceValue;
    @Value("${tax}")
    private int tax;
    private final Basket basket;
    private final MessageService messageService;

    @Autowired
    public ShopPlusService(Basket basket, MessageService messageService) {
        this.basket = basket;
        this.messageService = messageService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        addItem("Rower", getRandomDecimal());
        addItem("Resorek", getRandomDecimal());
        addItem("Klocki", getRandomDecimal());
        addItem("Lalka", getRandomDecimal());
        addItem("Misio", getRandomDecimal());
        showItems();
    }
    private double getRandomDecimal() {
        return  (new Random().nextInt((maxPriceValue - minPriceValue) + 1) + minPriceValue) / 100.0;
    }

    @Override
    public void addItem(String name, double price) {
        basket.addItem(Item.builder()
                .name(name)
                .price(BigDecimal.valueOf(price)
                        .setScale(2, RoundingMode.HALF_UP))
                .tax(tax)
                .build());
    }

    @Override
    public void showItems() {
        final String REGEX = "%-20s %7s %7s %8s %n";
        System.out.printf(REGEX,
                messageService.getTextProductName(),
                messageService.getTextPrice(),
                messageService.getTextTax(),
                messageService.getTextTogether());
        basket.getItems().forEach(o ->
                System.out.printf(REGEX,
                        o.getName(),
                        o.getPrice(),
                        o.getTax(),
                        o.getPrice().add(o.getTax())));
        System.out.printf(REGEX,
                messageService.getTextSum(),
                basket.getPriceSum(),
                basket.getTaxSum(),
                basket.getPriceSum().add(basket.getTaxSum()));
    }
}
