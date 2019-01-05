##Verisure Binding##

This is an OpenHAB binding for Versiure Alarm system, by Securitas Direct

This binding uses the rest API behind the myverisure pages https://mypages.verisure.com/login.html

The binding supports several installations via the configuration parameter numberOfInstallations that defaults to 1.

Be aware that Verisure don't approve if you update to often, I have gotten no complaints running with a 10 minutes update interval, but officially you should use 30 minutes.

###Supported Things###

This binding supports the following thing types:

* Bridge
* Alarm
* Smoke Detector (climate) 
* Water Detector (climate)
* Siren (climate)
* Night Control
* Yaleman SmartLock
* SmartPlug
* Door/Window Status
* User Presence Status
* Broadband Connection Status


###Binding Configuration###
You will have to configure the bridge with username and password, these must be the same values as used when logging into https://mypages.verisure.com. You can also configure your pin-code to be able to lock/unlock the SmartLock and arm/unarm the alarm. It is also possible to configure the number of installations you have, default is 1.

###Discovery###
After the configuration of the Verisure Bridge all of the available Sensors, Alarms, SmartPlugs and SmartLocks will be discovered and placed as things in the inbox.

###Thing Configuration###
Only the bridge require manual configuration. The devices and sensors should not be added by hand, let the discovery/inbox initially configure these.

###Supported Things and Channels###
Verisure Alarm ([alarm]) support the following channels:

<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>status</td><td>String</td><td>This channel reports the overall alarm status (armed/unarmed).</td></tr>
<tr><td>numericStatus</td><td>Number</td><td>This channel reports the alarm status as a number.</td></tr>
<tr><td>alarmStatus</td><td>String</td><td>This channel reports the specific alarm status (Armed away, Armed home or Disarmed).</td></tr>
<tr><td>timestamp</td><td>String</td><td>This channel reports the last time alarm was changed.</td></tr>
<tr><td>changedByUser</td><td>String</td><td>This channel reports the user that last changed the state of the alarm.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
<tr><td>setAlarmStatus</td><td>Number</td><td>This channel is used to arm/disarm the alarm.</td></tr>
</table>

Verisure Smoke Detector ([smokeDetector]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>humidity</td><td>Number</td><td>This channel reports the current humidity in percentage.</td></tr>
<tr><td>temperature</td><td>Number</td><td>This channel reports the current temperature in celsius.</td></tr>
<tr><td>lastupdate</td><td>String</td><td>This channel reports the last time this sensor was updates.</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>


Verisure Water Detector ([waterDetector]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>humidity</td><td>Number</td><td>This channel reports the current humidity in percentage.</td></tr>
<tr><td>temperature</td><td>Number</td><td>This channel reports the current temperature in celsius.</td></tr>
<tr><td>lastupdate</td><td>String</td><td>This channel reports the last time this sensor was updates.</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>

Verisure Siren ([siren]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>humidity</td><td>Number</td><td>This channel reports the current humidity in percentage.</td></tr>
<tr><td>temperature</td><td>Number</td><td>This channel reports the current temperature in celsius.</td></tr>
<tr><td>lastupdate</td><td>String</td><td>This channel reports the last time this sensor was updates.</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>

Verisure Night Control ([nightControl]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>humidity</td><td>Number</td><td>This channel reports the current humidity in percentage.</td></tr>
<tr><td>temperature</td><td>Number</td><td>This channel reports the current temperature in celsius.</td></tr>
<tr><td>lastupdate</td><td>String</td><td>This channel reports the last time this sensor was updates.</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>


Verisure Yaleman SmartLock ([smartLock]) support the following channels:

<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>status</td><td>String</td><td>This channel reports the lock status.</td></tr>
<tr><td>numericStatus</td><td>Number</td><td>This channel reports the lock status as a number.</td></tr>
<tr><td>smartLockStatus</td><td>Number</td><td>This channel reports the lock status as a number.</td></tr>
<tr><td>timestamp</td><td>String</td><td>This channel reports the last time lock was changed (not a Date).</td></tr>
<tr><td>changedByUser</td><td>String</td><td>This channel reports the user that last changed the state of the lock.</td></tr>
<tr><td>autoRelockEnabled</td><td>String</td><td>This channel reports the status of the Auto-lock function.</td></tr>
<tr><td>smartLockVolume</td><td>String</td><td>This channel reports the current volume level setting.</td></tr>
<tr><td>smartLockVoiceLevel</td><td>String</td><td>This channel reports the current voice level setting.</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
<tr><td>setSmartLockStatus</td><td>Number</td><td>This channel is used to lock/unlock.</td></tr>
<tr><td>setAutoRelock</td><td>Number</td><td>This channel is used to set Auto-lock on/off.</td></tr>
<tr><td>setSmartLockVolume</td><td>Number</td><td>This channel is used to set the volume level.</td></tr>
<tr><td>setSmartLockVoiceLevel</td><td>Number</td><td>This channel is used to set the voice level.</td></tr>
</table>

Verisure SmartPlug ([smartPlug]) support the following channels:

<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>status</td><td>String</td><td>This channel reports the lock status.</td></tr>
<tr><td>hazardous</td><td>Number</td><td>This channel reports if the smart plug is configured as hazardous.</td></tr>
<tr><td>smartPlugStatus</td><td>Number</td><td>This channel reports the status of the smart plug (on/off).</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
<tr><td>setSmartPlugStatus</td><td>Number</td><td>This channel is used to turn smart plug on/off.</td></tr>
</table>

Verisure DoorWindow Sensor ([doorWindowSensor]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>state</td><td>String</td><td>This channel reports the if the door/window is open or closed (OPEN/CLOSE).</td></tr>
<tr><td>location</td><td>String</td><td>This channel reports the location.</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>

Verisure User Presence ([userPresence]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>webAccount</td><td>String</td><td>This channel reports the user's email.</td></tr>
<tr><td>userLocationStatus</td><td>String</td><td>This channel reports the user presence (HOME/AWAY).</td></tr>
<tr><td>userLocationName</td><td>String</td><td>This channel reports the name of the location (can be null).</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>

Verisure Broadband Connection ([broadbandConnection]) support the following channels:
 
<table>
<tr><td><b>Channel Type ID</b></td> <td><b>Item Type</b></td> <td><b>Description</b></td> </tr>
<tr><td>timestamp</td><td>String</td><td>This channel reports the last time lock was changed (not a Date).</td></tr>
<tr><td>hasWiFi</td><td>String</td><td>This channel reports if user has WiFi connection.</td></tr>
<tr><td>status</td><td>String</td><td>This channel reports the broadband connection status. (Online/Offline)</td></tr>
<tr><td>siteName</td><td>String</td><td>This channel reports the name of the site.</td></tr>
<tr><td>siteId</td><td>Number</td><td>This channel reports the site ID of the site.</td></tr>
</table>


###Full Example###

```
Bridge verisure:bridge:1 "My Versirue" [pin="YYYYYY", username="XXXXXXX",password="ZZZZZZ"]
```