##Verisure Binding##

This is an OpenHAB binding for Versiure Alarm system, by Securitas Direct

This binding uses the rest API behind the myverisure pages https://mypages.verisure.com/login.html

The binding supports several installations via the configuration parameter numberOfInstallations that defaults to 1.

Be aware that Verisure don't approve if you update to often, I have gotten no complaints running with a 10 minutes update interval, but officially you should use 30 minutes.

###Supported Things###

This binding supports the following thing types:

* Bridge
* Alarm
* Smart Plug
* Smoke Detector (climate) 
* Water Detector (climate)
* Siren (climate)
* Yaleman SmartLock
* User Presence Status
* Door/Window Status
* Broadband Connection Status
* Night Control

###Binding Configuration###
You will have to configure the bridge with username and password, these must be the same values as used when logging into https://mypages.verisure.com. You can also configure your pin-code to be able to lock/unlock the SmartLock and arm/unarm the alarm.

###Discovery###
After the configuration of the Verisure Bridge all of the available Sensors, Alarms.SmartPlugs and Locks will be reported in the inbox.

###Thing Configuration###
Only the bridges require manual configuration. The devices and sensors should not be added by hand, let the discovery/inbox initially configure these.

###Channels###
Alarm ([bridge]) support the following channels:

<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>status</td><td>String</td><td>This channel reports th alarm status.</td></tr>
<tr><td>numericStatus</td><td>Number</td><td>This channel reports the lock status as a number.</td></tr>
<tr><td>alarmStatus</td><td>String</td><td>This channel reports the alarm status.</td></tr>
<tr><td>timestamp</td><td>String</td><td>This channel reports the last time alarm was changed (not a Date).</td></tr>
<tr><td>changedByUser</td><td>String</td><td>This channel reports the username that changed the state of the alarm.</td></tr>
<tr><td>setAlarmStatus</td><td>Number</td><td>This channel is used to arm/disarm the alarm.</td></tr>
</table>

SmartLock ([smartLock]) support the following channels:

<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>status</td><td>String</td><td>This channel reports the lock status.</td></tr>
<tr><td>numericStatus</td><td>Number</td><td>This channel reports the lock status as a number.</td></tr>
<tr><td>timestamp</td><td>String</td><td>This channel reports the last time lock was changed (not a Date).</td></tr>
<tr><td>changedByUser</td><td>String</td><td>This channel reports the username that changed the state of the lock.</td></tr>
<tr><td>setSmartLockStatus</td><td>Number</td><td>This channel is used to lock/unlock.</td></tr>
</table>

ClimateDevice ([climateDevice]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>humidity</td><td>Number</td><td>This channel reports the current humidity in percentage.</td></tr>
<tr><td>temperature</td><td>Number</td><td>This channel reports the current temperature in celsius.</td></tr>
<tr><td>lastupdate</td><td>String</td><td>This channel reports the last time this sensor was updates (not a Date).</td></tr>
</table>

DoorWindow ([doorwindow]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>state</td><td>String</td><td>This channel reports the if the door/window is open or closed.</td></tr>
<tr><td>label</td><td>String</td><td>This channel reports the name of the door/window.</td></tr>
</table>

UserPresence ([userPresence]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>webAccount</td><td>String</td><td>This channel reports the users email.</td></tr>
<tr><td>locationStatus</td><td>String</td><td>This channel reports the status (home/away).</td></tr>
<tr><td>locationName</td><td>String</td><td>This channel reports the name of the location, can be null.</td></tr>
</table>
###Full Example###

```
Bridge verisure:bridge:1 "My Versirue" [pin="YYYYYY", username="XXXXXXX",password="ZZZZZZ"]
```