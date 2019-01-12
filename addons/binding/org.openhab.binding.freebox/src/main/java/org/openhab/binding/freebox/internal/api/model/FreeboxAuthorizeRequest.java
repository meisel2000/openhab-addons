/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.freebox.internal.api.model;

/**
 * The {@link FreeboxAuthorizeRequest} is the Java class used to map the
 * structure used by the request of the request authorization API
 * https://dev.freebox.fr/sdk/os/login/#
 *
 * @author Laurent Garnier - Initial contribution
 */
public class FreeboxAuthorizeRequest {
    private String appId;
    private String appName;
    private String appVersion;
    private String deviceName;

    public FreeboxAuthorizeRequest(String appId, String appName, String appVersion, String deviceName) {
        this.appId = appId;
        this.appName = appName;
        this.appVersion = appVersion;
        this.deviceName = deviceName;
    }
}
