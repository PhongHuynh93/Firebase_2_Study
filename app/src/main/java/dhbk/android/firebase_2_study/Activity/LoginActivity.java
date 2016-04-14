package dhbk.android.firebase_2_study.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dhbk.android.firebase_2_study.Help.FirebaseConfig;
import dhbk.android.firebase_2_study.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseConfig.getFirebaseInitialize(this);


    }
}
