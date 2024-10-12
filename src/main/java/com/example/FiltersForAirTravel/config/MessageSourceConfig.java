package com.example.FiltersForAirTravel.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Конфигурационный класс для настройки {@code MessageSource}, используемого
 * для интернационализации (i18n) сообщений в приложении.
 *
 * <p>Отмечен аннотацией {@link Configuration}, что указывает на то, что этот
 * класс содержит определения бинов Spring.
 */
@Configuration
public class MessageSourceConfig {

    /**
     * Создает и настраивает бин {@link MessageSource}, который загружает
     * сообщения из файлов ресурсов для целей интернационализации.
     *
     * <p>Используется {@link ReloadableResourceBundleMessageSource}, который позволяет
     * автоматически перезагружать файлы сообщений без перезагрузки приложения.
     *
     * @return бин {@link MessageSource}, настроенный для загрузки сообщений
     *         из ресурса с базовым именем "classpath:messages" и кодировкой UTF-8
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
