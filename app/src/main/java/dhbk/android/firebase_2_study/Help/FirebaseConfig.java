package dhbk.android.firebase_2_study.Help;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by huynhducthanhphong on 4/14/16.
 */
public class FirebaseConfig {
    private static final String FIREBASE_URL = "https://test-fb-phong093.firebaseio.com";
    private static final String FIREBASE_CHILD = "chat";

    public static void getFirebaseInitialize(Context context) {
        Firebase.setAndroidContext(context);
    }

    public static Firebase getFirebaseReference() {
        return new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
    }
}
