package com.example.alertdialog23032021;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppDialog {
    private static Dialog mDialog = null;
    public static void createDialogRegister(Context context, OnListenerDataRegister onListenerDataRegister){
        mDialog = new Dialog(context, R.style.ThemeOverlay_AppCompat_Dialog_Alert);
        mDialog.setContentView(R.layout.appdialog);

        EditText edtUser = mDialog.findViewById(R.id.editTextUserName);
        EditText edtPassword = mDialog.findViewById(R.id.editTextPassWord);
        Button btnCancel = mDialog.findViewById(R.id.buttonCancel);
        Button btnRegister = mDialog.findViewById(R.id.buttonRegister);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (onListenerDataRegister != null){
                    onListenerDataRegister.onGetData(username,password);
                }
                mDialog.dismiss();
            }
        });

        mDialog.show();
    }
}
