package com.example.mvpchow10.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import java.io.File;

public class Installutil {
    public static final int UNKNOWN_CODE = 2019;
    public static void installApk(Context context, String path) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startInstallO(context, path);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            startInstallN(context, path);
        } else {
            startInstall(context, path);
        }
    }

    //6.0
    private static void startInstall(Context context, String path) {
        Intent install = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("file://"+path);
        install.setDataAndType(uri, "application/vnd.android.package-archive");
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(install);
    }

    //7.0
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void startInstallN(Context context, String path) {
        Uri apkUrl = FileProvider.getUriForFile(context, "com.example.download.provider", new File(path));
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        install.setDataAndType(apkUrl, "application/vnd.android.package-archive");
        context.startActivity(install);
    }

    //8.0
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void startInstallO(final Context context, String path) {
        boolean isGranted = context.getPackageManager().canRequestPackageInstalls();
        if (isGranted) startInstallN(context, path);
        else new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("安装应用需要打开未知来源权限,请去设置中开启权限")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                        Activity act = (Activity) context;
                        act.startActivityForResult(intent, UNKNOWN_CODE);
                    }
                }).show();
    }


}
