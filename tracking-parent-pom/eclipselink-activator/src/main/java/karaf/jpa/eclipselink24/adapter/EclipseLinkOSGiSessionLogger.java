/**
 *
 * Copyright 2013 lb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package karaf.jpa.eclipselink24.adapter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;

import com.google.common.collect.Maps;

/**
 *
 */
public class EclipseLinkOSGiSessionLogger extends AbstractSessionLog implements SessionLog
{
    private static final Logger LOGGER  = Logger.getLogger("ECLIPSELINK");
    private static final Map<String,Logger> LOGGERS = Maps.newHashMap();

    /**
     * c-tor
     */
    public EclipseLinkOSGiSessionLogger() {
        this(1);
    }

    /**
     * c-tor
     *
     * @param level
     */
    public EclipseLinkOSGiSessionLogger(int level) {
        setLevel(1);
    }

    /**
     *
     */
    @Override
    public void log(SessionLogEntry sle) {
        Logger lg  = getLogger(sle);
        String msg = getMessage(sle);

        if(lg != null && StringUtils.isNotBlank(msg)) {
            switch(sle.getLevel()) {
                case SessionLog.SEVERE  : lg.error(msg); break;
                case SessionLog.WARNING : lg.warn (msg); break;
                case SessionLog.INFO    : lg.info (msg); break;
                case SessionLog.FINE    : lg.debug(msg); break;
                case SessionLog.FINER   : lg.trace(msg); break;
                case SessionLog.FINEST  : lg.trace(msg); break;
                case SessionLog.ALL     : lg.trace(msg); break;
                default                 : lg.debug(msg); break;
            }
        }
    }

    /**
     *
     * @param sle
     * @return
     */
    private String getMessage(SessionLogEntry sle) {
        StringBuilder msg = new StringBuilder();
        //msg.append(getSupplementDetailString(sle))
        msg.append(formatMessage(sle));

        return msg.toString();
    }

    /**
     *
     * @param sle
     * @return
     */
    private Logger getLogger(SessionLogEntry sle) {
        String ns = sle.getNameSpace();
        if(StringUtils.isNotBlank(ns)) {
            ns = ns.toUpperCase();

            if(!LOGGERS.containsKey(ns)) {
                LOGGERS.put(ns,Logger.getLogger("JPA-" + ns));
            }

            return LOGGERS.get(ns);
        }

        return LOGGER;
    }
}
