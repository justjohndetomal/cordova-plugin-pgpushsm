package com.adobe.phonegap.push;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.android.gms.tasks.OnSuccessListener;

public class PushInstanceIDListenerService extends FirebaseMessagingService implements PushConstants {
  public static final String LOG_TAG = "Push_InsIdService";

  @Override
  public void onNewToken (String s) {
    super.onNewToken(s);

    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
      @Override
      public void onComplete(@NonNull Task<String> task) {
        if (!task.isSuccessful()) {
          return;
        }
        // Get new FCM registration token
        String refreshedToken = task.getResult();

        Log.d(LOG_TAG, "Refreshed token: " + refreshedToken);
      }
    });
  }
}
