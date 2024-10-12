package com.example.FiltersForAirTravel.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;

import static org.junit.jupiter.api.Assertions.*;

class MessageSourceConfigTest {

    private MessageSourceConfig messageSourceConfig;

    @BeforeEach
    void setUp() {
        messageSourceConfig = new MessageSourceConfig();
    }

    @Test
    void testMessageSource() {
        MessageSource messageSource = messageSourceConfig.messageSource();
        assertNotNull(messageSource);
        assertEquals("UTF-8", ((org.springframework.context.support.ReloadableResourceBundleMessageSource) messageSource).getDefaultEncoding());
    }
}
