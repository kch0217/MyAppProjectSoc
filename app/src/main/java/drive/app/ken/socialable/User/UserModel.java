package drive.app.ken.socialable.User;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ken on 7/4/2015.
 */
public class UserModel {

    private Context context;
    private static UserModel usermodel = new UserModel();
    private SharedPreferences prefs;


    private UserModel(){

    }

    public static UserModel getUserModel(){
        return usermodel;
    }



    public void setContext(Context myContext)
    {
        this.context = myContext;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Map<String, Object> getAllInfo(){

        Map<String, Object> allInfo = new HashMap<>();
        allInfo.put("Name", prefs.getString("Name", ""));
        allInfo.put("Age", prefs.getInt("Age", -1));
        allInfo.put("Gender", prefs.getString("Gender", ""));
        allInfo.put("Interest", prefs.getString("Interest", ""));
        allInfo.put("Phone", prefs.getString("Phone", ""));


        return allInfo;
    }

    public String getPhoneNumber(){
        TelephonyManager tel = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tel.getLine1Number();
    }

    public void saveAllInfo(Map<String, Object> data){

        SharedPreferences.Editor prefed = prefs.edit();
        prefed.putString("Name", (String)data.get("Name"));
        prefed.putInt("Age", (Integer) data.get("Age"));
        prefed.putString("Gender", (String) data.get("Gender"));
        prefed.putString("Interest", (String) data.get("Interest"));
        prefed.putString("Phone", (String) data.get("Phone"));
        prefed.commit();
    }

    public String getInterest(){
        String interest = prefs.getString("Interest", "");
        Log.i(null, "Getting Interest: "+interest);
        return interest;
    }

// save the setting of enabling the notification of passive searching
    public void saveSetting(boolean allowed){
        SharedPreferences.Editor prefed = prefs.edit();
        prefed.putBoolean("allowPassiveSearching", allowed);
        prefed.commit();
    }

    // load the setting of enabling the notification of passive searching
    public Map<String, Object> getSetting(){
        Map<String, Object> data= new HashMap<>();
        data.put("allowPassiveSearching", prefs.getBoolean("allowPassiveSearching", false));
        return data;
    }


    public void wipeAlldata(){
        SharedPreferences.Editor prefed =prefs.edit();
        prefed.clear();
        prefed.commit();
    }
}
