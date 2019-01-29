/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.verisure.internal.discovery;

import static org.openhab.binding.verisure.VerisureBindingConstants.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResult;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.verisure.handler.VerisureBridgeHandler;
import org.openhab.binding.verisure.handler.VerisureThingHandler;
import org.openhab.binding.verisure.internal.VerisureAlarmJSON;
import org.openhab.binding.verisure.internal.VerisureBroadbandConnectionJSON;
import org.openhab.binding.verisure.internal.VerisureClimateBaseJSON;
import org.openhab.binding.verisure.internal.VerisureDoorWindowJSON;
import org.openhab.binding.verisure.internal.VerisureSession;
import org.openhab.binding.verisure.internal.VerisureSmartPlugJSON;
import org.openhab.binding.verisure.internal.VerisureThingJSON;
import org.openhab.binding.verisure.internal.VerisureUserPresenceJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

/**
 * The discovery service, notified by a listener on the VerisureSession.
 *
 * @author Jarle Hjortland - Initial contribution
 *
 */
@NonNullByDefault
public class VerisureThingDiscoveryService extends AbstractDiscoveryService {
    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Sets
            .union(VerisureBridgeHandler.SUPPORTED_THING_TYPES, VerisureThingHandler.SUPPORTED_THING_TYPES);

    private Logger logger = LoggerFactory.getLogger(VerisureThingDiscoveryService.class);

    private static final int SEARCH_TIME = 60;

    private @Nullable VerisureBridgeHandler verisureBridgeHandler;

    public VerisureThingDiscoveryService(VerisureBridgeHandler bridgeHandler) throws IllegalArgumentException {
        // super(SEARCH_TIME);
        super(SUPPORTED_THING_TYPES, SEARCH_TIME);

        this.verisureBridgeHandler = bridgeHandler;

    }

    @Override
    public void startScan() {
        removeOlderResults(getTimestampOfLastScan());
        logger.debug("VerisureThingDiscoveryService:startScan");

        if (verisureBridgeHandler != null) {
            VerisureSession session = verisureBridgeHandler.getSession();
            if (session != null) {
                HashMap<String, @Nullable VerisureThingJSON> verisureThings = session.getVerisureThings();

                for (Map.Entry<String, @Nullable VerisureThingJSON> entry : verisureThings.entrySet()) {
                    VerisureThingJSON thing = entry.getValue();
                    if (thing != null) {
                        logger.info(thing.toString());
                        onThingAddedInternal(thing);
                    }
                }
            }
        }
    }

    private void onThingAddedInternal(VerisureThingJSON value) {
        logger.debug("VerisureThingDiscoveryService:OnThingAddedInternal");
        ThingUID thingUID = getThingUID(value);
        if (thingUID != null) {
            if (verisureBridgeHandler != null) {
                ThingUID bridgeUID = verisureBridgeHandler.getThing().getUID();
                String label = "ID: " + value.getId();
                if (value.getLocation() != null) {
                    label += ", Location: " + value.getLocation();
                } else if (value.getSiteName() != null) {
                    label += ", Site name: " + value.getSiteName();
                }
                DiscoveryResult discoveryResult = DiscoveryResultBuilder.create(thingUID).withBridge(bridgeUID)
                        .withLabel(label).build();
                logger.debug("thinguid: {}, bridge {}, label {}", thingUID.toString(), bridgeUID, value.getId());
                thingDiscovered(discoveryResult);
            }
        } else {
            logger.debug("discovered unsupported thing of type '{}' with id {}", value.getId(), value.getId());
        }

    }

    public void activate() {
    }

    private @Nullable ThingUID getThingUID(VerisureThingJSON voj) {
        ThingUID thingUID = null;
        if (verisureBridgeHandler != null) {
            ThingUID bridgeUID = verisureBridgeHandler.getThing().getUID();
            if (voj instanceof VerisureAlarmJSON) {
                String type = ((VerisureAlarmJSON) voj).getType();
                if (type != null) {
                    if (type.equals("ARM_STATE")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_ALARM, bridgeUID, id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else if (type.equals("DOOR_LOCK")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_SMARTLOCK, bridgeUID,
                                    id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else {
                        logger.error("Unknown alarm/lock device:" + ((VerisureAlarmJSON) voj).getType());
                    }
                }
            } else if (voj instanceof VerisureUserPresenceJSON) {
                String id = voj.getId();
                if (id != null) {
                    thingUID = new ThingUID(THING_TYPE_USERPRESENCE, bridgeUID, id.replaceAll("[^a-zA-Z0-9_]", "_"));
                }
            } else if (voj instanceof VerisureDoorWindowJSON) {
                String id = voj.getId();
                if (id != null) {
                    thingUID = new ThingUID(THING_TYPE_DOORWINDOW, bridgeUID, id.replaceAll("[^a-zA-Z0-9_]", "_"));
                }
            } else if (voj instanceof VerisureSmartPlugJSON) {
                String id = voj.getId();
                if (id != null) {
                    thingUID = new ThingUID(THING_TYPE_SMARTPLUG, bridgeUID, id.replaceAll("[^a-zA-Z0-9_]", "_"));
                }
            } else if (voj instanceof VerisureClimateBaseJSON) {
                String type = ((VerisureClimateBaseJSON) voj).getType();
                if (type != null) {
                    if (type.equalsIgnoreCase("Smoke detector")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_SMOKEDETECTOR, bridgeUID,
                                    id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else if (type.equalsIgnoreCase("Water detector")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_WATERDETETOR, bridgeUID,
                                    id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else if (type.equalsIgnoreCase("Night Control")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_NIGHT_CONTROL, bridgeUID,
                                    id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else if (type.equalsIgnoreCase("Siren")) {
                        String id = voj.getId();
                        if (id != null) {
                            thingUID = new ThingUID(THING_TYPE_SIREN, bridgeUID, id.replaceAll("[^a-zA-Z0-9_]", "_"));
                        }
                    } else {
                        logger.error("Unknown climate device:" + ((VerisureClimateBaseJSON) voj).getType());
                    }
                }
            } else if (voj instanceof VerisureBroadbandConnectionJSON) {
                String id = voj.getId();
                if (id != null) {
                    thingUID = new ThingUID(THING_TYPE_BROADBAND_CONNECTION, bridgeUID,
                            id.replaceAll("[^a-zA-Z0-9_]", "_"));
                }
            } else {
                logger.error("Unsupported JSON!");
            }
        }
        return thingUID;
    }

}
