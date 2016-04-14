package dhbk.android.firebase_2_study.Help;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by huynhducthanhphong on 4/14/16.
 */
public class FirebaseConfig {
    public static void getFirebaseInitialize(Context context) {
        Firebase.setAndroidContext(context);
    }
}
