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
package io.janusproject.services;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.common.util.concurrent.Service;

/** This class enables to log information by ensuring
 * that the values of the parameters are not evaluated
 * until the information should be really log, according
 * to the log level.
 * <p>
 * The LogService considers the parameters of the functions as:<ul>
 * <li>the <var>messageKey</var> is the name of the message in the property file;</li>
 * <li>the <var>message</var> parameters are the values that will replace the
 * strings {0}, {1}, {2}... in the text extracted from the ressource property;</li>
 * <li>the parameter <var>propertyType</var> is the class from which the filename of
 * the property file will be built.</li>
 * </ul>
 * <p>
 * If a <code>Throwable</code> is passed as parameter, the text of the
 * exception is retreived.
 * <p>
 * If a <code>LogParam</code> is passed as parameter, the <code>toString</code>
 * function will be invoked.
 * <p>
 * For all the other objects, the {@link #toString()} function is invoked.
 * 
 * 
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public interface LogService extends Service {

	/** Log an information message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #fineInfo(String, Object...)
	 * @see #finerInfo(String, Object...)
	 */
	public void info(String messageKey, Object... message);

	/** Log an information message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #fineInfo(Class, String, Object...)
	 * @see #finerInfo(Class, String, Object...)
	 */
	public void info(Class<?> propertyType, String messageKey, Object... message);

	/** Log a fine information message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #info(String, Object...)
	 * @see #finerInfo(String, Object...)
	 */
	public void fineInfo(String messageKey, Object... message);

	/** Log an information message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #info(Class, String, Object...)
	 * @see #finerInfo(Class, String, Object...)
	 */
	public void fineInfo(Class<?> propertyType, String messageKey, Object... message);

	/** Log a finer information message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #info(String, Object...)
	 * @see #fineInfo(String, Object...)
	 */
	public void finerInfo(String messageKey, Object... message);

	/** Log a finer information message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 * @see #info(Class, String, Object...)
	 * @see #fineInfo(Class, String, Object...)
	 */
	public void finerInfo(Class<?> propertyType, String messageKey, Object... message);

	/** Log a debug message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void debug(String messageKey, Object... message);

	/** Log a debug message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void debug(Class<?> propertyType, String messageKey, Object... message);

	/** Log a warning message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void warning(Class<?> propertyType, String messageKey, Object... message);

	/** Log a warning message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void warning(String messageKey, Object... message);

	/** Log an error message.
	 * 
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void error(String messageKey, Object... message);

	/** Log an error message.
	 * 
	 * @param propertyType - type that is used to retreive the property file.
	 * @param messageKey - key of the message in the properties.
	 * @param message
	 */
	public void error(Class<?> propertyType, String messageKey, Object... message);

	/** Log the given record.
	 * 
	 * @param record
	 */
	public void log(LogRecord record);
	
	/** Replies the logger.
	 * 
	 * @return the logger.
	 */
	public Logger getLogger();
	
	/** Change the logger.
	 * 
	 * @param logger
	 */
	public void setLogger(Logger logger);
	
	/** Change the filter that permits to output particular logs.
	 * 
	 * @param filter
	 */
	public void setFilter(Filter filter);

	/** Replies the filter that permits to output particular logs.
	 * 
	 * @return the filter
	 */
	public Filter getFilter();
	
	/** Check if a message of the given level would actually be logged
     * by this logger.  This check is based on the Loggers effective level,
     * which may be inherited from its parent.
     *
     * @param   level   a message logging level
     * @return  true if the given message level is currently being logged.
     */
	public boolean isLoggeable(Level level);

	/** Utility to put objec that us asynchronously evaluated by
	 * the {@link LogService}.
	 * 
	 * @author $Author: sgalland$
	 * @version $FullVersion$
	 * @mavengroupid $GroupId$
	 * @mavenartifactid $ArtifactId$
	 * @see LogService
	 */
	public interface LogParam {
		
		@Override
		public abstract String toString();
		
	}

}
