/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
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
package org.openhab.binding.vwweconnect.internal.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The Vehicle homeLocation representation.
 *
 * @author Jan Gustafsson - Initial contribution
 *
 */
@NonNullByDefault
public class Location {

    private @Nullable String errorCode;
    private @Nullable Position position;

    public @Nullable String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public @Nullable Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("errorCode", errorCode).append("position", position).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errorCode).append(position).toHashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(errorCode, rhs.errorCode).append(position, rhs.position).isEquals();
    }

    @NonNullByDefault
    public class Position {

        private double lat;
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("lat", lat).append("lng", lng).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(lng).append(lat).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Position)) {
                return false;
            }
            Position rhs = ((Position) other);
            return new EqualsBuilder().append(lng, rhs.lng).append(lat, rhs.lat).isEquals();
        }
    }
}