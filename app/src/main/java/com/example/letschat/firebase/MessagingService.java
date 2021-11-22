package com.example.letschat.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.letschat.R;
import com.example.letschat.activities.IncomingInvitationActivity;
import com.example.letschat.activities.MainActivity;
import com.example.letschat.utilities.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String type = remoteMessage.getData().get(Constants.REMOTE_MSG_TYPE);

        if (type != null) {
            if (type.equals(Constants.REMOTE_MSG_INVITATION)) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"My notification")
                        .setSmallIcon(R.drawable.ic_video)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.image_home))
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.image_home))
                                .bigLargeIcon(null))
                        .setContentTitle(remoteMessage.getData().get(Constants.KEY_FULL_NAME) + " is Calling ")
                        .setContentText(remoteMessage.getData().get(Constants.KEY_FULL_NAME) + " just called you out for a video call on vShare  !! ");

                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }

//                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                  manager.notify(0, builder.build());


                Intent intent = new Intent(getApplicationContext(), IncomingInvitationActivity.class);

                intent.putExtra(
                        Constants.REMOTE_MSG_MEETING_TYPE,
                        remoteMessage.getData().get(Constants.REMOTE_MSG_MEETING_TYPE)
                );
                intent.putExtra(
                        Constants.KEY_FULL_NAME,
                        remoteMessage.getData().get(Constants.KEY_FULL_NAME)
                );
                intent.putExtra(
                        Constants.KEY_EMAIL,
                        remoteMessage.getData().get(Constants.KEY_EMAIL)
                );
                intent.putExtra(
                        Constants.REMOTE_MSG_INVITER_TOKEN,
                        remoteMessage.getData().get(Constants.REMOTE_MSG_INVITER_TOKEN)
                );
                intent.putExtra(
                        Constants.REMOTE_MSG_MEETING_ROOM,
                        remoteMessage.getData().get(Constants.REMOTE_MSG_MEETING_ROOM)
                );
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

          //      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1,builder.build());



                // startActivity(intent);
            }
            else if (type.equals(Constants.REMOTE_MSG_INVITATION_RESPONSE)) {
                Intent intent = new Intent(Constants.REMOTE_MSG_INVITATION_RESPONSE);
                intent.putExtra(
                        Constants.REMOTE_MSG_INVITATION_RESPONSE,
                        remoteMessage.getData().get(Constants.REMOTE_MSG_INVITATION_RESPONSE)
                );
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
            }else if(type.equals(Constants.REMOTE_CONNECTION_INVITATION)){

            }
        }
    }
}