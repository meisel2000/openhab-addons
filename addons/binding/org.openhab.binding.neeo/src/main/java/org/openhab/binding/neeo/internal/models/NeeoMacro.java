/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.neeo.internal.models;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The model representing an Neeo Macro (serialize/deserialize json use only)
 *
 * @author Tim Roberts - Initial contribution
 */
@NonNullByDefault
public class NeeoMacro {

    /** The macro key */
    @Nullable
    private String key;

    /** The component type */
    @Nullable
    private String componentType;

    /** The macro name */
    @Nullable
    private String name;

    /** The macro label */
    @Nullable
    private String label;

    /** The associated device name */
    @Nullable
    private String deviceName;

    /** The associated room name */
    @Nullable
    private String roomName;

    /**
     * Gets the macro key
     *
     * @return the key
     */
    @Nullable
    public String getKey() {
        return key;
    }

    /**
     * Gets the component type
     *
     * @return the component type
     */
    @Nullable
    public String getComponentType() {
        return componentType;
    }

    /**
     * Gets the macro name
     *
     * @return the name
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Gets the macro label
     *
     * @return the label
     */
    @Nullable
    public String getLabel() {
        return label;
    }

    /**
     * Gets the associated device name
     *
     * @return the device name
     */
    @Nullable
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Gets the associated room name
     *
     * @return the room name
     */
    @Nullable
    public String getRoomName() {
        return roomName;
    }

    @Override
    public String toString() {
        return "NeeoMacro [key=" + key + ", componentType=" + componentType + ", name=" + name + ", label=" + label
                + ", deviceName=" + deviceName + ", roomName=" + roomName + "]";
    }

}
