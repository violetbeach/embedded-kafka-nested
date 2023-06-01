package com.violetbeach.embeddedkafka.reproduce.cases;

import com.violetbeach.embeddedkafka.reproduce.support.RestDocsBased;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

class RestDocsEmbeddedKafkaTest extends RestDocsBased {

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/test"));
    }

    @Nested
    class NestedClass {

        @Test
        void test() throws Exception {
            mockMvc.perform(get("/test"));
        }

    }

}

