package com.nocholla.usercredentialsnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    // Notification
    private NotificationManagerCompat notificationManager;

    // Widgets
    private EditText inputUsername;
    private EditText inputPassword;
    private Button btnLogin;

    /**
     * @method onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        // Widgets
        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);

        // Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputUsername.getText().toString();
                Log.d("DEBUG USERNAME", username);

                final String password = inputPassword.getText().toString();
                Log.d("DEBUG PASSWORD", password);

                // Username = edureka & Password = edureka123 Validation
                if(username.matches("edureka") && password.matches("edureka123")) {
                    // Notification On Success
                    loginSuccessNotification();
                } else {
                    // Notification On Fail
                    loginFailNotification();
                }

                // Wrong Username
                if(!username.matches("edureka")) {
                    inputUsername.setError(getString(R.string.error_wrong_username));
                }

                // Wrong Password
                if(!password.matches("edureka123")) {
                    inputPassword.setError(getString(R.string.error_wrong_password));
                }

                // Username Empty Validation
                if (TextUtils.isEmpty(username)) {
                    inputUsername.setError(getString(R.string.error_enter_username));

                    return;
                }

                // Password Empty Validation
                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError(getString(R.string.error_enter_password));

                    return;
                }
            }
        });

    }

    /**
     * @method loginSuccessNotification - Channel 1
     */
    public void loginSuccessNotification() {

        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.smiley_face)
                .setContentTitle(getString(R.string.notification_login_success_title))
                .setContentText(getString(R.string.notification_login_success))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }

    /**
     * @method loginFailNotification - Channel 1
     */
    public void loginFailNotification() {

        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.sad_face)
                .setContentTitle(getString(R.string.notification_login_fail_title))
                .setContentText(getString(R.string.notification_login_fail))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }

    /**
     * @method loginSuccessNotification - Channel 2
     */
//    public void loginSuccessNotification() {
//
//        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)
//                .setSmallIcon(R.drawable.smiley_face)
//                .setContentTitle(getString(R.string.notification_login_success_title))
//                .setContentText(getString(R.string.notification_login_success))
//                .setPriority(NotificationCompat.PRIORITY_LOW)
//                .build();
//
//        notificationManager.notify(2, notification);
//    }

    /**
     * @method loginFailNotification - Channel 2
     */
//    public void loginFailNotification() {
//
//        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)
//                .setSmallIcon(R.drawable.sad_face)
//                .setContentTitle(getString(R.string.notification_login_fail_title))
//                .setContentText(getString(R.string.notification_login_fail))
//                .setPriority(NotificationCompat.PRIORITY_LOW)
//                .build();
//
//        notificationManager.notify(2, notification);
//    }

}

