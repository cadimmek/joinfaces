/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.butterfaces;

import de.larmic.butterfaces.util.ReflectionUtil;

import org.joinfaces.javaxfaces.JavaxFacesSpringBootAutoConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot Auto Configuration of ButterFaces.
 * @author Marcelo Fernandes
 */
@Configuration
@EnableConfigurationProperties(ButterfacesProperties.class)
@ConditionalOnClass(ReflectionUtil.class)
@AutoConfigureBefore(JavaxFacesSpringBootAutoConfiguration.class)
@ConditionalOnWebApplication
public class ButterfacesSpringBootAutoConfiguration {

	@Autowired
	private ButterfacesProperties butterfacesProperties;

	@Bean
	public ServletContextInitializer butterfacesServletContextInitializer() {
		return new ButterfacesServletContextInitializer(this.butterfacesProperties);
	}
}
