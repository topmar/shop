package com.topolski.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private final MessageSource messageSource;
    @Value("${language}")
    private String language;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    public String getTextProductName() {
        return messageSource.getMessage("product_name", new Object[]{}, Locale.forLanguageTag(language));
    }
    public String getTextPrice() {
        return messageSource.getMessage("price", new Object[]{}, Locale.forLanguageTag(language));
    }
    public String getTextSum() {
        return messageSource.getMessage("sum", new Object[]{}, Locale.forLanguageTag(language));
    }

    public String getTextTax() {
        return messageSource.getMessage("tax", new Object[]{}, Locale.forLanguageTag(language));
    }
    public String getTextTogether() {
        return messageSource.getMessage("together", new Object[]{}, Locale.forLanguageTag(language));
    }
    public String getTextDiscount() {
        return messageSource.getMessage("discount", new Object[]{}, Locale.forLanguageTag(language));
    }
}
