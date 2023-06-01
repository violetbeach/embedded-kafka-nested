package com.violetbeach.embeddedkafka.reproduce.support;

import com.violetbeach.embeddedkafka.module.context.EmbeddedKafka;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@EmbeddedKafka
@SpringBootTest
@Import(WireMockConfiguration.class)
public class WireMockBased {
}
