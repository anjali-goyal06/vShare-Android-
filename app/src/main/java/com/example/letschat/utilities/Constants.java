package com.example.letschat.utilities;

import java.util.HashMap;

public class Constants {

    public static final String KEY_COLLECTION_USERS = "users";
    public static final String KEY_FULL_NAME = "fName";
    public static final String KEY_EMAIL = "email";

    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_FCM_TOKEN = "fcm_token";

    public static final String KEY_PREFERENCE_NAME = "videoMeetingPreference";

    public static final String KEY_COLLECTION_CHATS = "chats";
    public static final String KEY_MESSAGES = "messages";

    public static final String KEY_VIDEO = "video";
    public static final String KEY_AUDIO = "audio";

    public static final String REMOTE_MSG_AUTHORIZATION = "Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE = "Content-Type";

    public static final String REMOTE_MSG_TYPE = "type";
    public static final String REMOTE_MSG_INVITATION = "invitation";
    public static final String REMOTE_MSG_MEETING_TYPE = "meetingType";
    public static final String REMOTE_MSG_INVITER_TOKEN = "inviterToken";
    public static final String REMOTE_MSG_DATA = "data";
    public static final String REMOTE_MSG_REGISTRATION_IDS = "registration_ids";

    public static final String REMOTE_MSG_INVITATION_RESPONSE = "invitationResponse";

    public static final String REMOTE_MSG_INVITATION_ACCEPTED = "accepted";
    public static final String REMOTE_MSG_INVITATION_REJECTED = "rejected";
    public static final String REMOTE_MSG_INVITATION_CANCELLED = "cancelled";
    public static final String REMOTE_CONNECTION_INVITATION = "connectionInvitation";

    public static final String REMOTE_MSG_MEETING_ROOM = "meetingRoom";

    //    Return type HashMap
    public static HashMap<String, String> getRemoteMessageHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(
                Constants.REMOTE_MSG_AUTHORIZATION,
                "key=AAAAiCV1eeY:APA91bELWCWngkpwUjwotRKo3TuXmFiIz912SCibtu0k9K7nT3BrjxPMlQ_D4icubD3mT51MjoOrcUz4S4KdlzEGpe2fh4OUf77yHDJ902yXwp1MgOhfrmSLPT7Z8KolZdop89fK1mGj"
        );
        headers.put(Constants.REMOTE_MSG_CONTENT_TYPE, "application/json");
        return headers;
    }


}
