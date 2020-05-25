package com.ynk.versionchecker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ynk.appversionchecker.VersionChecker;

import muyan.snacktoa.SnackToa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VersionChecker versionChecker = new VersionChecker(MainActivity.this, new VersionChecker.ResultListener() {
                    @Override
                    public void onResult(String version) {
                        if (version != null) {
                            String currentVersion = VersionChecker.getVersionCode(MainActivity.this);
                            Log.i("VersionChecker", "Play Store Version: " + version + " -- Current Version:" + currentVersion);
                            if (!version.equals(currentVersion)) {
                                Log.i("VersionChecker", "New Version Found!");
                                SnackToa.snackBarFloating(findViewById(android.R.id.content), MainActivity.this, "New Version Avaliable", new SnackToa.snackbarUndoClick() {
                                    @Override
                                    public void onClick(View v) {
                                        VersionChecker.openPlayStore(MainActivity.this);
                                    }
                                });
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
            }
        });

    }

}
