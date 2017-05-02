/*
 * Copyright 2016-2017 the original author or authors.
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

package org.joinfaces.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.Ordered;

/**
 * {@link ServletContextInitializer} which runs an {@link InitParameterConfigurationPropertiesServletContextConfigurer} {@link #onStartup(ServletContext) on startup}.
 *
 * @param <PC> Type of the properties object
 * @author Lars Grefer
 */
public class InitParameterConfigurationPropertiesServletContextInitializer<PC extends ServletContextInitParameterConfigurationProperties> implements ServletContextInitializer, Ordered {

	private final PC properties;
	private int order;

	public InitParameterConfigurationPropertiesServletContextInitializer(PC properties) {
		this(properties, Ordered.LOWEST_PRECEDENCE);
	}

	public InitParameterConfigurationPropertiesServletContextInitializer(PC properties, int order) {
		this.properties = properties;
		this.order = order;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		new InitParameterConfigurationPropertiesServletContextConfigurer<PC>(servletContext, this.properties)
				.configure();
	}

	@Override
	public int getOrder() {
		return this.order;
	}
}
