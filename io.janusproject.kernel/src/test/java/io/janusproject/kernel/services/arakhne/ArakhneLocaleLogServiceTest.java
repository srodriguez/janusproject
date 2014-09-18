/*
 * $Id$
 * 
 * Janus platform is an open-source multiagent platform.
 * More details on http://www.janusproject.io
 * 
 * Copyright (C) 2014 Sebastian RODRIGUEZ, Nicolas GAUD, Stéphane GALLAND.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.janusproject.kernel.services.arakhne;

import io.janusproject.kernel.services.AbstractServiceImplementationTest;
import io.janusproject.services.logging.LogService;

import org.junit.Before;

/** 
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class ArakhneLocaleLogServiceTest extends AbstractServiceImplementationTest<LogService> {

	private ArakhneLocaleLogService service;

	/**
	 */
	public ArakhneLocaleLogServiceTest() {
		super(LogService.class);
	}

	@Override
	protected final LogService getTestedService() {
		return this.service;
	}

	/**
	 */
	@Before
	public void setUp() {
		this.service = new ArakhneLocaleLogService();
	}
	
}
