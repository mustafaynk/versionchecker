# Version Checker
This library has been developed for learning purposes. With this library, you can check the application version in the Google Play Store .


### Usage

#### Note: You must add Internet permission to AndroidManifest.xml file.

```Java
...

VersionChecker versionChecker = new VersionChecker(MainActivity.this, new VersionChecker.ResultListener() {
                    @Override
                    public void onResult(String version) {
                        if (version != null) {
                            String currentVersion = VersionChecker.getVersionCode(MainActivity.this);
                            Log.i("VersionChecker", "Play Store Version: " + version + " -- Current Version:" + currentVersion);
                            if (!version.equals(currentVersion)) {
                                Log.i("VersionChecker", "New Version Found!");
                            } else {
                                Log.i("VersionChecker", "New version not found!");
                            }
                        } else {
                            Log.i("VersionChecker", "App Not Found in Play Store!");
                            SnackToa.toastError(MainActivity.this, "App Not Found in Play Store!");
                        }
                    }
                });
                versionChecker.execute();
                
...                
```

### Installation

Download the latest JAR or grab via Maven:
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
	
<dependency>
	    <groupId>com.github.mustafaynk</groupId>
	    <artifactId>versionchecker</artifactId>
	    <version>v1.0</version>
</dependency>
```
or Gradle: 
- Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

- Add the dependency
```
dependencies {
	implementation 'com.github.mustafaynk:versionchecker:v1.0'
}
```
