package io.ribot.app.ui;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import io.ribot.app.data.DataManager;
import io.ribot.app.ui.base.BaseActivity;
import io.ribot.app.ui.main.MainActivity;
import io.ribot.app.ui.signin.SignInActivity;

public class LauncherActivity extends BaseActivity {

    @Inject
    protected DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        Intent intent;
        if (mDataManager.getPreferencesHelper().getAccessToken() != null) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = SignInActivity.newStartIntent(this, false);
        }
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        finish();
    }
}
