package com.example.alertdialog23032021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mBtnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);
        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Hãy chọn 1 con vật yêu thích");
                builder.setTitle("Bạn có thông báo mới");
                builder.setMessage("Có phiên bản update mới");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bạn chọn có", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bạn chọn không", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bạn chọn Hủy", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

    }
}