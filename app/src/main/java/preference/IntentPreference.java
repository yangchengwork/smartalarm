package preference;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

/**
 * Created by tom on 10/01/18.
 */

public class IntentPreference extends WearPreference {
    String mIntent;

    public IntentPreference(Context context, AttributeSet attrs){
        super(context, attrs);
        final int defResId = attrs.getAttributeResourceValue(NAMESPACE_ANDROID, "action", -1);
        if(defResId != -1){
            mIntent = context.getResources().getString(defResId);
        }else{
            mIntent = attrs.getAttributeValue(NAMESPACE_ANDROID, "action");
        }
    }

    @Override
    void onPreferenceClick(@NonNull Context context) {
        context.startActivity(new Intent(mIntent));
    }
}
