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

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.ContextCustomizerFactory;
import org.springframework.test.context.MergedContextConfiguration;

import java.util.List;

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

	@Override
	public ContextCustomizer createContextCustomizer(Class<?> testClass,
			List<ContextConfigurationAttributes> configAttributes) {
		return new ContextCustomizer() {
			@Override
			public void customizeContext(ConfigurableApplicationContext context, MergedContextConfiguration mergedConfig) {

			}
		};
//		EmbeddedKafka embeddedKafka =
//				AnnotatedElementUtils.findMergedAnnotation(testClass, EmbeddedKafka.class);
//		return embeddedKafka != null ? new EmbeddedKafkaContextCustomizer(embeddedKafka) : null;
	}

}
