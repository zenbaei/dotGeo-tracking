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

import org.eclipse.persistence.transaction.JTATransactionController;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import javax.transaction.TransactionManager;

/**
 *
 */
public class EclipseLinkOSGiTransactionController extends JTATransactionController {

    @Override
    protected TransactionManager acquireTransactionManager() throws Exception {
        Bundle bundle = FrameworkUtil.getBundle(EclipseLinkOSGiTransactionController.class);
        BundleContext ctx = bundle.getBundleContext();

        if (ctx != null) {
            ServiceReference ref = ctx.getServiceReference(TransactionManager.class.getName());

            if (ref != null) {
                TransactionManager manager = (TransactionManager) ctx.getService(ref);
                return manager;
            }
        }

        return super.acquireTransactionManager();
    }

}

