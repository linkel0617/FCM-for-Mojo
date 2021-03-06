package moe.shizuku.fcmformojo.model;

import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by rikka on 2017/8/15.
 */

@Keep
public class RegistrationId {

    private String id;
    private String name;
    private long time;

    public RegistrationId(String id, String name, long time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public static RegistrationId create() {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (!TextUtils.isEmpty(token)) {
            return new RegistrationId(token, Build.MODEL, System.currentTimeMillis());
        } else {
            return null;
        }
    }
}
