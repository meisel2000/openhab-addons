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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The Trips status representation.
 *
 * @author Jan Gustafsson - Initial contribution
 *
 */
@NonNullByDefault
public class Trips {

    private @Nullable String errorCode;
    private @Nullable RtsViewModel rtsViewModel;

    public @Nullable String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public @Nullable RtsViewModel getRtsViewModel() {
        return rtsViewModel;
    }

    public void setRtsViewModel(RtsViewModel rtsViewModel) {
        this.rtsViewModel = rtsViewModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("errorCode", errorCode).append("rtsViewModel", rtsViewModel).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errorCode).append(rtsViewModel).toHashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Trips)) {
            return false;
        }
        Trips rhs = ((Trips) other);
        return new EqualsBuilder().append(errorCode, rhs.errorCode).append(rtsViewModel, rhs.rtsViewModel).isEquals();
    }

    @NonNullByDefault
    public class RtsViewModel {

        private int daysInMonth;
        private int firstWeekday;
        private int month;
        private int year;
        private int firstTripYear;
        private @Nullable List<TripStatistic> tripStatistics = null;
        private @Nullable LongTermData longTermData;
        private @Nullable Object cyclicData;
        private @Nullable ServiceConfiguration serviceConfiguration;
        private boolean tripFromLastRefuelAvailable;

        public int getDaysInMonth() {
            return daysInMonth;
        }

        public void setDaysInMonth(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }

        public int getFirstWeekday() {
            return firstWeekday;
        }

        public void setFirstWeekday(int firstWeekday) {
            this.firstWeekday = firstWeekday;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getFirstTripYear() {
            return firstTripYear;
        }

        public void setFirstTripYear(int firstTripYear) {
            this.firstTripYear = firstTripYear;
        }

        public @Nullable List<TripStatistic> getTripStatistics() {
            return tripStatistics;
        }

        public void setTripStatistics(List<TripStatistic> tripStatistics) {
            this.tripStatistics = tripStatistics;
        }

        public @Nullable LongTermData getLongTermData() {
            return longTermData;
        }

        public void setLongTermData(LongTermData longTermData) {
            this.longTermData = longTermData;
        }

        public @Nullable Object getCyclicData() {
            return cyclicData;
        }

        public void setCyclicData(Object cyclicData) {
            this.cyclicData = cyclicData;
        }

        public @Nullable ServiceConfiguration getServiceConfiguration() {
            return serviceConfiguration;
        }

        public void setServiceConfiguration(ServiceConfiguration serviceConfiguration) {
            this.serviceConfiguration = serviceConfiguration;
        }

        public boolean isTripFromLastRefuelAvailable() {
            return tripFromLastRefuelAvailable;
        }

        public void setTripFromLastRefuelAvailable(boolean tripFromLastRefuelAvailable) {
            this.tripFromLastRefuelAvailable = tripFromLastRefuelAvailable;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("daysInMonth", daysInMonth).append("firstWeekday", firstWeekday)
                    .append("month", month).append("year", year).append("firstTripYear", firstTripYear)
                    .append("tripStatistics", tripStatistics).append("longTermData", longTermData)
                    .append("cyclicData", cyclicData).append("serviceConfiguration", serviceConfiguration)
                    .append("tripFromLastRefuelAvailable", tripFromLastRefuelAvailable).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(firstWeekday).append(firstTripYear).append(longTermData)
                    .append(serviceConfiguration).append(daysInMonth).append(month).append(year).append(cyclicData)
                    .append(tripFromLastRefuelAvailable).append(tripStatistics).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof RtsViewModel)) {
                return false;
            }
            RtsViewModel rhs = ((RtsViewModel) other);
            return new EqualsBuilder().append(firstWeekday, rhs.firstWeekday).append(firstTripYear, rhs.firstTripYear)
                    .append(longTermData, rhs.longTermData).append(serviceConfiguration, rhs.serviceConfiguration)
                    .append(daysInMonth, rhs.daysInMonth).append(month, rhs.month).append(year, rhs.year)
                    .append(cyclicData, rhs.cyclicData)
                    .append(tripFromLastRefuelAvailable, rhs.tripFromLastRefuelAvailable).isEquals();
        }
    }

    @NonNullByDefault
    public class LongTermData {

        private int tripId;
        private double averageElectricConsumption = BaseVehicle.UNDEFINED;
        private double averageFuelConsumption = BaseVehicle.UNDEFINED;
        private double averageCngConsumption = BaseVehicle.UNDEFINED;
        private double averageSpeed = BaseVehicle.UNDEFINED;
        private int tripDuration = BaseVehicle.UNDEFINED;
        private double tripLength = BaseVehicle.UNDEFINED;
        private @Nullable String timestamp;
        private @Nullable String tripDurationFormatted;
        private @Nullable Object recuperation;
        private double averageAuxiliaryConsumption = BaseVehicle.UNDEFINED;
        private double totalElectricConsumption = BaseVehicle.UNDEFINED;
        private @Nullable String longFormattedTimestamp;

        public int getTripId() {
            return tripId;
        }

        public void setTripId(int tripId) {
            this.tripId = tripId;
        }

        public double getAverageElectricConsumption() {
            return averageElectricConsumption;
        }

        public void setAverageElectricConsumption(double averageElectricConsumption) {
            this.averageElectricConsumption = averageElectricConsumption;
        }

        public double getAverageFuelConsumption() {
            return averageFuelConsumption;
        }

        public void setAverageFuelConsumption(double averageFuelConsumption) {
            this.averageFuelConsumption = averageFuelConsumption;
        }

        public double getAverageCngConsumption() {
            return averageCngConsumption;
        }

        public void setAverageCngConsumption(double averageCngConsumption) {
            this.averageCngConsumption = averageCngConsumption;
        }

        public double getAverageSpeed() {
            return averageSpeed;
        }

        public void setAverageSpeed(double averageSpeed) {
            this.averageSpeed = averageSpeed;
        }

        public int getTripDuration() {
            return tripDuration;
        }

        public void setTripDuration(int tripDuration) {
            this.tripDuration = tripDuration;
        }

        public double getTripLength() {
            return tripLength;
        }

        public void setTripLength(double tripLength) {
            this.tripLength = tripLength;
        }

        public @Nullable String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public @Nullable String getTripDurationFormatted() {
            return tripDurationFormatted;
        }

        public void setTripDurationFormatted(String tripDurationFormatted) {
            this.tripDurationFormatted = tripDurationFormatted;
        }

        public @Nullable Object getRecuperation() {
            return recuperation;
        }

        public void setRecuperation(Object recuperation) {
            this.recuperation = recuperation;
        }

        public double getAverageAuxiliaryConsumption() {
            return averageAuxiliaryConsumption;
        }

        public void setAverageAuxiliaryConsumption(double averageAuxiliaryConsumption) {
            this.averageAuxiliaryConsumption = averageAuxiliaryConsumption;
        }

        public double getTotalElectricConsumption() {
            return totalElectricConsumption;
        }

        public void setTotalElectricConsumption(double totalElectricConsumption) {
            this.totalElectricConsumption = totalElectricConsumption;
        }

        public @Nullable String getLongFormattedTimestamp() {
            return longFormattedTimestamp;
        }

        public void setLongFormattedTimestamp(String longFormattedTimestamp) {
            this.longFormattedTimestamp = longFormattedTimestamp;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("tripId", tripId)
                    .append("averageElectricConsumption", averageElectricConsumption)
                    .append("averageFuelConsumption", averageFuelConsumption)
                    .append("averageCngConsumption", averageCngConsumption).append("averageSpeed", averageSpeed)
                    .append("tripDuration", tripDuration).append("tripLength", tripLength)
                    .append("timestamp", timestamp).append("tripDurationFormatted", tripDurationFormatted)
                    .append("recuperation", recuperation)
                    .append("averageAuxiliaryConsumption", averageAuxiliaryConsumption)
                    .append("totalElectricConsumption", totalElectricConsumption)
                    .append("longFormattedTimestamp", longFormattedTimestamp).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(averageElectricConsumption).append(tripLength)
                    .append(averageFuelConsumption).append(averageAuxiliaryConsumption).append(tripId)
                    .append(averageSpeed).append(recuperation).append(totalElectricConsumption)
                    .append(averageCngConsumption).append(longFormattedTimestamp).append(tripDuration)
                    .append(tripDurationFormatted).append(timestamp).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof LongTermData)) {
                return false;
            }
            LongTermData rhs = ((LongTermData) other);
            return new EqualsBuilder().append(averageElectricConsumption, rhs.averageElectricConsumption)
                    .append(tripLength, rhs.tripLength).append(averageFuelConsumption, rhs.averageFuelConsumption)
                    .append(averageAuxiliaryConsumption, rhs.averageAuxiliaryConsumption).append(tripId, rhs.tripId)
                    .append(averageSpeed, rhs.averageSpeed).append(recuperation, rhs.recuperation)
                    .append(totalElectricConsumption, rhs.totalElectricConsumption)
                    .append(averageCngConsumption, rhs.averageCngConsumption)
                    .append(longFormattedTimestamp, rhs.longFormattedTimestamp).append(tripDuration, rhs.tripDuration)
                    .append(tripDurationFormatted, rhs.tripDurationFormatted).append(timestamp, rhs.timestamp)
                    .isEquals();
        }
    }

    @NonNullByDefault
    public class AggregatedStatistics {

        private int tripId;
        private double averageElectricConsumption;
        private double averageFuelConsumption;
        private double averageCngConsumption;
        private double averageSpeed;
        private int tripDuration;
        private double tripLength;
        private @Nullable String timestamp;
        private @Nullable String tripDurationFormatted;
        private @Nullable Object recuperation;
        private double averageAuxiliaryConsumption;
        private double totalElectricConsumption;
        private @Nullable Object longFormattedTimestamp;

        public int getTripId() {
            return tripId;
        }

        public void setTripId(int tripId) {
            this.tripId = tripId;
        }

        public double getAverageElectricConsumption() {
            return averageElectricConsumption;
        }

        public void setAverageElectricConsumption(double averageElectricConsumption) {
            this.averageElectricConsumption = averageElectricConsumption;
        }

        public double getAverageFuelConsumption() {
            return averageFuelConsumption;
        }

        public void setAverageFuelConsumption(double averageFuelConsumption) {
            this.averageFuelConsumption = averageFuelConsumption;
        }

        public double getAverageCngConsumption() {
            return averageCngConsumption;
        }

        public void setAverageCngConsumption(double averageCngConsumption) {
            this.averageCngConsumption = averageCngConsumption;
        }

        public double getAverageSpeed() {
            return averageSpeed;
        }

        public void setAverageSpeed(double averageSpeed) {
            this.averageSpeed = averageSpeed;
        }

        public int getTripDuration() {
            return tripDuration;
        }

        public void setTripDuration(int tripDuration) {
            this.tripDuration = tripDuration;
        }

        public double getTripLength() {
            return tripLength;
        }

        public void setTripLength(double tripLength) {
            this.tripLength = tripLength;
        }

        public @Nullable String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public @Nullable String getTripDurationFormatted() {
            return tripDurationFormatted;
        }

        public void setTripDurationFormatted(String tripDurationFormatted) {
            this.tripDurationFormatted = tripDurationFormatted;
        }

        public @Nullable Object getRecuperation() {
            return recuperation;
        }

        public void setRecuperation(Object recuperation) {
            this.recuperation = recuperation;
        }

        public double getAverageAuxiliaryConsumption() {
            return averageAuxiliaryConsumption;
        }

        public void setAverageAuxiliaryConsumption(double averageAuxiliaryConsumption) {
            this.averageAuxiliaryConsumption = averageAuxiliaryConsumption;
        }

        public double getTotalElectricConsumption() {
            return totalElectricConsumption;
        }

        public void setTotalElectricConsumption(double totalElectricConsumption) {
            this.totalElectricConsumption = totalElectricConsumption;
        }

        public @Nullable Object getLongFormattedTimestamp() {
            return longFormattedTimestamp;
        }

        public void setLongFormattedTimestamp(Object longFormattedTimestamp) {
            this.longFormattedTimestamp = longFormattedTimestamp;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("tripId", tripId)
                    .append("averageElectricConsumption", averageElectricConsumption)
                    .append("averageFuelConsumption", averageFuelConsumption)
                    .append("averageCngConsumption", averageCngConsumption).append("averageSpeed", averageSpeed)
                    .append("tripDuration", tripDuration).append("tripLength", tripLength)
                    .append("timestamp", timestamp).append("tripDurationFormatted", tripDurationFormatted)
                    .append("recuperation", recuperation)
                    .append("averageAuxiliaryConsumption", averageAuxiliaryConsumption)
                    .append("totalElectricConsumption", totalElectricConsumption)
                    .append("longFormattedTimestamp", longFormattedTimestamp).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(averageElectricConsumption).append(tripLength)
                    .append(averageFuelConsumption).append(averageAuxiliaryConsumption).append(tripId)
                    .append(averageSpeed).append(recuperation).append(totalElectricConsumption)
                    .append(averageCngConsumption).append(longFormattedTimestamp).append(tripDuration)
                    .append(tripDurationFormatted).append(timestamp).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof AggregatedStatistics)) {
                return false;
            }
            AggregatedStatistics rhs = ((AggregatedStatistics) other);
            return new EqualsBuilder().append(averageElectricConsumption, rhs.averageElectricConsumption)
                    .append(tripLength, rhs.tripLength).append(averageFuelConsumption, rhs.averageFuelConsumption)
                    .append(averageAuxiliaryConsumption, rhs.averageAuxiliaryConsumption).append(tripId, rhs.tripId)
                    .append(averageSpeed, rhs.averageSpeed).append(recuperation, rhs.recuperation)
                    .append(totalElectricConsumption, rhs.totalElectricConsumption)
                    .append(averageCngConsumption, rhs.averageCngConsumption)
                    .append(longFormattedTimestamp, rhs.longFormattedTimestamp).append(tripDuration, rhs.tripDuration)
                    .append(tripDurationFormatted, rhs.tripDurationFormatted).append(timestamp, rhs.timestamp)
                    .isEquals();
        }
    }

    @NonNullByDefault
    public class ServiceConfiguration {

        private boolean electricConsumption;
        private boolean triptypeShort;
        private boolean auxiliaryConsumption;
        private boolean fuelOverallConsumption;
        private boolean triptypeCyclic;
        private boolean electricOverallConsumption;
        private boolean triptypeLong;
        private boolean cngOverallConsumption;
        private boolean recuperation;

        public boolean isElectricConsumption() {
            return electricConsumption;
        }

        public void setElectricConsumption(boolean electricConsumption) {
            this.electricConsumption = electricConsumption;
        }

        public boolean isTriptypeShort() {
            return triptypeShort;
        }

        public void setTriptypeShort(boolean triptypeShort) {
            this.triptypeShort = triptypeShort;
        }

        public boolean isAuxiliaryConsumption() {
            return auxiliaryConsumption;
        }

        public void setAuxiliaryConsumption(boolean auxiliaryConsumption) {
            this.auxiliaryConsumption = auxiliaryConsumption;
        }

        public boolean isFuelOverallConsumption() {
            return fuelOverallConsumption;
        }

        public void setFuelOverallConsumption(boolean fuelOverallConsumption) {
            this.fuelOverallConsumption = fuelOverallConsumption;
        }

        public boolean isTriptypeCyclic() {
            return triptypeCyclic;
        }

        public void setTriptypeCyclic(boolean triptypeCyclic) {
            this.triptypeCyclic = triptypeCyclic;
        }

        public boolean isElectricOverallConsumption() {
            return electricOverallConsumption;
        }

        public void setElectricOverallConsumption(boolean electricOverallConsumption) {
            this.electricOverallConsumption = electricOverallConsumption;
        }

        public boolean isTriptypeLong() {
            return triptypeLong;
        }

        public void setTriptypeLong(boolean triptypeLong) {
            this.triptypeLong = triptypeLong;
        }

        public boolean isCngOverallConsumption() {
            return cngOverallConsumption;
        }

        public void setCngOverallConsumption(boolean cngOverallConsumption) {
            this.cngOverallConsumption = cngOverallConsumption;
        }

        public boolean isRecuperation() {
            return recuperation;
        }

        public void setRecuperation(boolean recuperation) {
            this.recuperation = recuperation;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("electricConsumption", electricConsumption)
                    .append("triptypeShort", triptypeShort).append("auxiliaryConsumption", auxiliaryConsumption)
                    .append("fuelOverallConsumption", fuelOverallConsumption).append("triptypeCyclic", triptypeCyclic)
                    .append("electricOverallConsumption", electricOverallConsumption)
                    .append("triptypeLong", triptypeLong).append("cngOverallConsumption", cngOverallConsumption)
                    .append("recuperation", recuperation).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(triptypeCyclic).append(triptypeShort).append(electricConsumption)
                    .append(cngOverallConsumption).append(triptypeLong).append(auxiliaryConsumption)
                    .append(electricOverallConsumption).append(fuelOverallConsumption).append(recuperation)
                    .toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof ServiceConfiguration)) {
                return false;
            }
            ServiceConfiguration rhs = ((ServiceConfiguration) other);
            return new EqualsBuilder().append(triptypeCyclic, rhs.triptypeCyclic)
                    .append(triptypeShort, rhs.triptypeShort).append(electricConsumption, rhs.electricConsumption)
                    .append(cngOverallConsumption, rhs.cngOverallConsumption).append(triptypeLong, rhs.triptypeLong)
                    .append(auxiliaryConsumption, rhs.auxiliaryConsumption)
                    .append(electricOverallConsumption, rhs.electricOverallConsumption)
                    .append(fuelOverallConsumption, rhs.fuelOverallConsumption).append(recuperation, rhs.recuperation)
                    .isEquals();
        }
    }

    @NonNullByDefault
    public class TripStatistic {

        private @Nullable AggregatedStatistics aggregatedStatistics;
        private @Nullable List<TripStatisticDetail> tripStatistics;

        public @Nullable AggregatedStatistics getAggregatedStatistics() {
            return aggregatedStatistics;
        }

        public void setAggregatedStatistics(AggregatedStatistics aggregatedStatistics) {
            this.aggregatedStatistics = aggregatedStatistics;
        }

        public @Nullable List<TripStatisticDetail> getTripStatistics() {
            return tripStatistics;
        }

        public void setTripStatistics(List<TripStatisticDetail> tripStatistics) {
            this.tripStatistics = tripStatistics;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("aggregatedStatistics", aggregatedStatistics)
                    .append("tripStatistics", tripStatistics).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(tripStatistics).append(aggregatedStatistics).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof TripStatistic)) {
                return false;
            }
            TripStatistic rhs = ((TripStatistic) other);
            return new EqualsBuilder().append(tripStatistics, rhs.tripStatistics)
                    .append(aggregatedStatistics, rhs.aggregatedStatistics).isEquals();
        }
    }

    @NonNullByDefault
    public class TripStatisticDetail {

        private int tripId;
        private double averageElectricConsumption = BaseVehicle.UNDEFINED;
        private double averageFuelConsumption = BaseVehicle.UNDEFINED;
        private double averageCngConsumption = BaseVehicle.UNDEFINED;
        private double averageSpeed = BaseVehicle.UNDEFINED;
        private int tripDuration = BaseVehicle.UNDEFINED;
        private double tripLength = BaseVehicle.UNDEFINED;
        private @Nullable String timestamp;
        private @Nullable String tripDurationFormatted;
        private @Nullable Object recuperation;
        private int averageAuxiliaryConsumption = BaseVehicle.UNDEFINED;
        private int totalElectricConsumption = BaseVehicle.UNDEFINED;
        private @Nullable String longFormattedTimestamp;

        public int getTripId() {
            return tripId;
        }

        public void setTripId(int tripId) {
            this.tripId = tripId;
        }

        public double getAverageElectricConsumption() {
            return averageElectricConsumption;
        }

        public void setAverageElectricConsumption(double averageElectricConsumption) {
            this.averageElectricConsumption = averageElectricConsumption;
        }

        public double getAverageFuelConsumption() {
            return averageFuelConsumption;
        }

        public void setAverageFuelConsumption(double averageFuelConsumption) {
            this.averageFuelConsumption = averageFuelConsumption;
        }

        public double getAverageCngConsumption() {
            return averageCngConsumption;
        }

        public void setAverageCngConsumption(double averageCngConsumption) {
            this.averageCngConsumption = averageCngConsumption;
        }

        public double getAverageSpeed() {
            return averageSpeed;
        }

        public void setAverageSpeed(double averageSpeed) {
            this.averageSpeed = averageSpeed;
        }

        public int getTripDuration() {
            return tripDuration;
        }

        public void setTripDuration(int tripDuration) {
            this.tripDuration = tripDuration;
        }

        public double getTripLength() {
            return tripLength;
        }

        public void setTripLength(double tripLength) {
            this.tripLength = tripLength;
        }

        public @Nullable String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public @Nullable String getTripDurationFormatted() {
            return tripDurationFormatted;
        }

        public void setTripDurationFormatted(String tripDurationFormatted) {
            this.tripDurationFormatted = tripDurationFormatted;
        }

        public @Nullable Object getRecuperation() {
            return recuperation;
        }

        public void setRecuperation(Object recuperation) {
            this.recuperation = recuperation;
        }

        public int getAverageAuxiliaryConsumption() {
            return averageAuxiliaryConsumption;
        }

        public void setAverageAuxiliaryConsumption(int averageAuxiliaryConsumption) {
            this.averageAuxiliaryConsumption = averageAuxiliaryConsumption;
        }

        public int getTotalElectricConsumption() {
            return totalElectricConsumption;
        }

        public void setTotalElectricConsumption(int totalElectricConsumption) {
            this.totalElectricConsumption = totalElectricConsumption;
        }

        public @Nullable String getLongFormattedTimestamp() {
            return longFormattedTimestamp;
        }

        public void setLongFormattedTimestamp(String longFormattedTimestamp) {
            this.longFormattedTimestamp = longFormattedTimestamp;
        }

        public @Nullable ZonedDateTime getStartTimestamp() {
            String formattedTime = longFormattedTimestamp;
            if (formattedTime != null) {
                String[] splitStrings = formattedTime.split(",");
                String dateString = splitStrings[1].trim() + ", " + splitStrings[2].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy, HH:mm", Locale.getDefault());
                LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
                ZonedDateTime zdt = dateTime.atZone(ZoneId.systemDefault());

                return zdt.minusMinutes(tripDuration);
            }
            return null;
        }

        public @Nullable ZonedDateTime getEndTimestamp() {
            String formattedTime = longFormattedTimestamp;
            if (formattedTime != null) {
                String[] splitStrings = formattedTime.split(",");
                String dateString = splitStrings[1].trim() + ", " + splitStrings[2].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy, HH:mm", Locale.getDefault());
                LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
                ZonedDateTime zdt = dateTime.atZone(ZoneId.systemDefault());

                return zdt;
            }
            return null;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("tripId", tripId)
                    .append("averageElectricConsumption", averageElectricConsumption)
                    .append("averageFuelConsumption", averageFuelConsumption)
                    .append("averageCngConsumption", averageCngConsumption).append("averageSpeed", averageSpeed)
                    .append("tripDuration", tripDuration).append("tripLength", tripLength)
                    .append("timestamp", timestamp).append("tripDurationFormatted", tripDurationFormatted)
                    .append("recuperation", recuperation)
                    .append("averageAuxiliaryConsumption", averageAuxiliaryConsumption)
                    .append("totalElectricConsumption", totalElectricConsumption)
                    .append("longFormattedTimestamp", longFormattedTimestamp).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(averageElectricConsumption).append(tripLength)
                    .append(averageFuelConsumption).append(averageAuxiliaryConsumption).append(tripId)
                    .append(averageSpeed).append(recuperation).append(totalElectricConsumption)
                    .append(averageCngConsumption).append(longFormattedTimestamp).append(tripDuration)
                    .append(tripDurationFormatted).append(timestamp).toHashCode();
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof TripStatisticDetail)) {
                return false;
            }
            TripStatisticDetail rhs = ((TripStatisticDetail) other);
            return new EqualsBuilder().append(averageElectricConsumption, rhs.averageElectricConsumption)
                    .append(tripLength, rhs.tripLength).append(averageFuelConsumption, rhs.averageFuelConsumption)
                    .append(averageAuxiliaryConsumption, rhs.averageAuxiliaryConsumption).append(tripId, rhs.tripId)
                    .append(averageSpeed, rhs.averageSpeed).append(recuperation, rhs.recuperation)
                    .append(totalElectricConsumption, rhs.totalElectricConsumption)
                    .append(averageCngConsumption, rhs.averageCngConsumption)
                    .append(longFormattedTimestamp, rhs.longFormattedTimestamp).append(tripDuration, rhs.tripDuration)
                    .append(tripDurationFormatted, rhs.tripDurationFormatted).append(timestamp, rhs.timestamp)
                    .isEquals();
        }

    }
}