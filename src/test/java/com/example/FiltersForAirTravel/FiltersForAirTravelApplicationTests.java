package com.example.FiltersForAirTravel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестов для приложения {@code FiltersForAirTravel}.
 *
 * <p>Используется для проверки загрузки контекста Spring и наличия основных
 * бинов, необходимых для корректного функционирования приложения.
 *
 * <p>Класс аннотирован как {@link SpringBootTest}, что означает, что тесты
 * запускаются в контексте Spring Boot для обеспечения полной интеграции компонентов.
 */
@SpringBootTest
class FiltersForAirTravelApplicationTests {

	/**
	 * Контекст приложения Spring, автоматически инжектируемый с помощью {@link Autowired}.
	 *
	 * <p>Используется для проверки загрузки контекста и наличия необходимых бинов.
	 */
	@Autowired
	private ApplicationContext context;

	/**
	 * Тест проверяет, что контекст Spring загружается корректно.
	 *
	 * <p>Если контекст не загружается, тест завершится ошибкой.
	 */
	@Test
	void contextLoads() {
		assertNotNull(context, "Контекст Spring должен быть загружен");
	}

	/**
	 * Тест проверяет, что основные бины загружены в контекст Spring.
	 *
	 * <p>Проверяются следующие бины: {@code flightServiceImpl}, {@code flightController},
	 * {@code flightRepositoryImpl}, {@code compositeFlightFilter}.
	 */
	@Test
	void testBeansLoaded() {
		assertTrue(context.containsBean("flightServiceImpl"), "Bean FlightServiceImpl должен быть загружен");
		assertTrue(context.containsBean("flightController"), "Bean FlightController должен быть загружен");
		assertTrue(context.containsBean("flightRepositoryImpl"), "Bean FlightRepositoryImpl должен быть загружен");
		assertTrue(context.containsBean("compositeFlightFilter"), "Bean CompositeFlightFilter должен быть загружен");
	}

	/**
	 * Тест проверяет, что конфигурационный бин {@code AppConfig} загружается для текущего профиля.
	 *
	 * <p>Если бин {@code AppConfig} не загружен, тест завершится ошибкой.
	 */
	@Test
	void testAppConfigBeanLoaded() {
		assertTrue(context.containsBean("appConfig"), "Bean AppConfig должен быть загружен");
	}
}
