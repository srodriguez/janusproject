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
package io.janusproject.kernel.bic;

import io.sarl.core.ExternalContextAccess;
import io.sarl.core.InnerContextAccess;
import io.sarl.core.SynchronizedCollection;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;

import java.lang.reflect.Method;

/**
 * Implementation of a spawning service.
 * 
 * @author $Author: srodriguez$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class BuiltinCapacityUtil {

	/** Replies the contexts in which the agent is located.
	 * 
	 * @param agent
	 * @return the contexts of the agents.
	 * @throws Exception
	 */
	public static SynchronizedCollection<AgentContext> getContextsOf(Agent agent) throws Exception {
		Method method = Agent.class.getDeclaredMethod("getSkill", Class.class); //$NON-NLS-1$
		boolean isAccessible = method.isAccessible();
		ExternalContextAccess skill;
		try {
			method.setAccessible(true);
			skill = (ExternalContextAccess) method.invoke(agent, ExternalContextAccess.class);
		} finally {
			method.setAccessible(isAccessible);
		}

		return skill.getAllContexts();
	}
	
	/** Replies the inner context of the agent, if it was created.
	 * 
	 * @param agent
	 * @return the inner context, or <code>null</code>.
	 * @throws Exception
	 */
	public static AgentContext getContextIn(Agent agent) throws Exception {
		Method method = Agent.class.getDeclaredMethod("getSkill", Class.class); //$NON-NLS-1$
		boolean isAccessible = method.isAccessible();
		InnerContextAccess skill;
		try {
			method.setAccessible(true);
			skill = (InnerContextAccess) method.invoke(agent, InnerContextAccess.class);
		} finally {
			method.setAccessible(isAccessible);
		}

		if (skill instanceof InnerContextSkill) {
			InnerContextSkill janusSkill = (InnerContextSkill)skill;
			if (janusSkill.hasInnerContext())
				return janusSkill.getInnerContext();
			return null;
		}
		return skill.getInnerContext();
	}

}
