/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.violetbeach.embeddedkafka.module.context;

import org.junit.jupiter.engine.discovery.predicates.IsNestedTestClass;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.ContextCustomizerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The {@link ContextCustomizerFactory} implementation to produce a
 * {@link EmbeddedKafkaContextCustomizer} if a {@link EmbeddedKafka} annotation
 * is present on the test class.
 *
 * @author Artem Bilan
 *
 * @since 1.3
 */
public class EmbeddedKafkaContextCustomizerFactory implements ContextCustomizerFactory {

	private final IsNestedTestClass isNestedTestClass = new IsNestedTestClass();

	@Override
	public ContextCustomizer createContextCustomizer(Class<?> testClass,
			List<ContextConfigurationAttributes> configAttributes) {
		EmbeddedKafka embeddedKafka =
				AnnotatedElementUtils.findMergedAnnotation(testClass, EmbeddedKafka.class);
		if(embeddedKafka != null) {
			return new EmbeddedKafkaContextCustomizer(embeddedKafka);
		}

		Class<?> search = testClass;
		while(isNestedTestClass.test(search)) {
			search = search.getDeclaringClass();
			embeddedKafka = AnnotatedElementUtils.findMergedAnnotation(search, EmbeddedKafka.class);
			if(embeddedKafka != null) {
				return new EmbeddedKafkaContextCustomizer(embeddedKafka);
			}
		}
		return null;
	}

}
