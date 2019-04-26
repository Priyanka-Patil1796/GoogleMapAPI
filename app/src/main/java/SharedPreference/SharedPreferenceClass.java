package SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass
{
    public static final String mypreference = "mypref";
    public Context context;

    public SharedPreferenceClass(Context context)
    {
        this.context=context;
    }

    public void setStr(String key, Double value)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, String.valueOf(value));
        editor.apply();
    }

    public String getStr(String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(mypreference, 0);
        return prefs.getString(key,"");
    }
}
