# android-projectHackathon

Android application with completely built in 36hrs hackathon . This app is hosted from free hosting site.

## Prerequisite(Beginner's Guide)
We need to setup environment to develop the app.

1. Java Development Kit [JDK-Latest Version](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html) 
   - Download this to setup the java environment on your machine.(Select agree license and then download accordingly to your system)
2. Android SDK [Android SDK](https://developer.android.com/studio/index.html)
   - Download the latest version by following this link and install the packaged and tools. 
   
## Coding 

Add the dependencies and permission in the grade and manifest in the porject 
```
compile 'com.mcxiaoke.volley:library-aar:1.0.0'
compile 'com.android.support:cardview-v7:25.3.1'
compile 'com.android.support:recyclerview-v7:25.3.1'
compile 'com.alimuzaffar.lib:animated-edit-text:1.0'
compile 'com.android.support:appcompat-v7:25.3.0'
compile 'com.roughike:bottom-bar:2.3.1'
```

Volley depencies added to transfer data and interact with server similar to api. 
bottom bar is made simple to get the 5 bottom bar navigation .

Add this google play services dependencies in gradle(Module : app)
>classpath 'com.google.gms:google-services:3.1.0'
add the reference plugin apply to gradle (Module : project)
>apply plugin: 'com.google.gms.google-services'

These permission to be added in the manifest file to give access to the internet and read write files.
```
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
   
```
Enjoy developing and share :grey_exclamation: Enjoy Developing :thumbsup:
