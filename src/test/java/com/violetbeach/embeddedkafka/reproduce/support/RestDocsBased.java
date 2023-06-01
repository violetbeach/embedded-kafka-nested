package com.violetbeach.embeddedkafka.reproduce.support;

import com.violetbeach.embeddedkafka.module.context.EmbeddedKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@EmbeddedKafka
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@SpringBootTest
public class RestDocsBased {

    @Autowired
    protected MockMvc mockMvc;

}
