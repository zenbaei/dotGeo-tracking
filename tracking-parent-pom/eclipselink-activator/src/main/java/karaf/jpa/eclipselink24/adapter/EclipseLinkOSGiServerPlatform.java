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

import org.eclipse.persistence.platform.server.ServerPlatformBase;
import org.eclipse.persistence.sessions.DatabaseSession;


/**
 *
 */
public class EclipseLinkOSGiServerPlatform extends ServerPlatformBase {

    /**
     * c-tor
     *
     * @param databaseSession
     */
    public EclipseLinkOSGiServerPlatform(DatabaseSession databaseSession) {
        super(databaseSession);
    }

    @Override
    public Class getExternalTransactionControllerClass() {
        return EclipseLinkOSGiTransactionController.class;
    }
}
