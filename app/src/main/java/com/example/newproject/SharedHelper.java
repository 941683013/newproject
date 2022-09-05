package com.example.newproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SharedHelper {

    SharedPreferences sp;

    private Context mContext;

    public SharedHelper() {
    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
        sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
    }

    public void saveStatus(boolean status) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("status", status);
        editor.commit();
    }

    public boolean getStatus() {
        Map mp = read();
        return (boolean) mp.get("Status");
    }
    // 等待实现
    public void saveLoginUser(User user) {


    }


    //定义一个保存数据的方法
    public void save(String username, String passwd) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("passwd", passwd);
        editor.commit();
        Toast.makeText(mContext, "信息已写入SharedPreference中", Toast.LENGTH_SHORT).show();
    }

    //定义一个读取SP文件的方法
    public Map<String, Boolean> read() {
        Map<String, Boolean> data = new HashMap<String, Boolean>();
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("status", sp.getBoolean("status", false));
        return data;
    }
}
