/**
 * Phresco libraries
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photon.phresco.tools;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.tools.config.Configuration;
import com.photon.phresco.tools.config.ConfigurationFactory;

public class ConfigTest {
	
	ConfigurationFactory fac = null;
	
	@Before
    public void setUp() {
		fac = ConfigurationFactory.getInstance(new File("src/test/resources/config.xml"));
	}
	
	@After
    public void tearDown() {
    }
	
	@Test
	public void testEnvironment() {
		List<Configuration> configurations = fac.getConfiguration("Dev", null, null);
		assertEquals(5, configurations.size());
	}
	
	@Test
	public void testDefaultEnvironment() {
		assertEquals("Production", fac.getDefaultEnvName());
		List<Configuration> configurations = fac.getDefaultEnv();
		assertEquals(5, configurations.size());
	}
	
	@Test
	public void testConfigurationByType() {
		List<Configuration> configurations = fac.getConfiguration("Dev", "database", null);
		assertEquals(2, configurations.size());
	}
	
	
}
