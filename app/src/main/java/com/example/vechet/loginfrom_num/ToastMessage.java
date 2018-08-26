package com.example.vechet.loginfrom_num;

import android.content.Context;
import android.widget.Toast;

public class ToastMessage {
    public static void showMessage(Context context, String smg){
        Toast.makeText(context, smg, Toast.LENGTH_SHORT).show();
    }
}
