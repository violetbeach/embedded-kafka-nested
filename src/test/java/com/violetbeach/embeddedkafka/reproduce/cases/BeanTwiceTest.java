package com.violetbeach.embeddedkafka.reproduce.cases;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.violetbeach.embeddedkafka.reproduce.cases.BeanTwiceTest.ATestConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringJUnitConfig(ATestConfiguration.class)
class BeanTwiceTest {

    private static final AtomicInteger counter = new AtomicInteger();

    @Autowired
    private AClass aClass1;

    @Nested
    class NestedClass {
        @Test
        void equalsInjected(@Autowired AClass aClass2) {
            assertEquals(aClass1, aClass2);
        }

        @Test
        void equalsSize(@Autowired List<AClass> classes) {
            assertEquals(1, classes.size());
        }

        @Test
        void equalsCount() {
            assertEquals(2, counter.get());
        }
    }

    public static class AClass {
    }

    @Configuration(proxyBeanMethods = false)
    static class ATestConfiguration {
        @Bean
        public AClass aClass() {
            counter.incrementAndGet();
            return new AClass();
        }
    }
}