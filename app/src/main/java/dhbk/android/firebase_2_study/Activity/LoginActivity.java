package dhbk.android.firebase_2_study.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

import dhbk.android.firebase_2_study.Help.FirebaseConfig;
import dhbk.android.firebase_2_study.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();
    private Firebase mFirebaseReference;
    private EditText mEditTextEmail;
    private EditText mEitTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseConfig.getFirebaseInitialize(this);
        mFirebaseReference = FirebaseConfig.getFirebaseReference();

        initializeView();
    }

    private void initializeView() {
        // đăng ký
        findViewById(R.id.button_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, null, getString(R.string.register_progress_dialog), true);
                mFirebaseReference.createUser(mEditTextEmail.getText().toString(), mEitTextPassword.getText().toString(),  new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    // dk thành công
                    public void onSuccess(Map<String, Object> result) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Thanh cong ", Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "Successfully created user account with uid: " + result.get("uid"));
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                        progressDialog.dismiss();
                        Log.i(TAG, "Error " + firebaseError.getMessage());
                    }

                });
            }
        });

        // đăng nhập
        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, " ", getString(R.string.login_progress_dialog), true);
                mFirebaseReference.authWithPassword(mEditTextEmail.getText().toString(), mEitTextPassword.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        progressDialog.dismiss();
                        Log.i(TAG, "Login success " + "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // there was an error
                        progressDialog.dismiss();
                        Log.i(TAG, "Login failed! " +firebaseError.getMessage());
                    }
                });
            }
        });
        mEditTextEmail = (EditText) findViewById(R.id.edit_txt_mail);
        mEitTextPassword = (EditText) findViewById(R.id.edit_txt_pass);
    }

}
