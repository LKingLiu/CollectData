package com.lking.collect.data.ui.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;

/**
 * @author : Lking
 *         CreateTime: 2017/9/26
 *         Email ： 1599863094@qq.com
 *         explain ：
 */
public final class ViewTools {

    /**
     * 检查权限
     */
    public static boolean checkPermission(final Activity activity, ArrayList<String> permissionsList) {
        //判断手机是否是6.0以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < permissionsList.size(); i++) {
                if (ContextCompat.checkSelfPermission(activity, permissionsList.get(i)) == PackageManager.PERMISSION_GRANTED) {
                    permissionsList.remove(i);
                    i--;
                }
            }
        }
        if (permissionsList.size() > 0) {//有权限没有给，返回false
            ActivityCompat.requestPermissions(activity,permissionsList.toArray(new String[permissionsList.size()]),1);
            return false;
        }
        return true;
    }


}


