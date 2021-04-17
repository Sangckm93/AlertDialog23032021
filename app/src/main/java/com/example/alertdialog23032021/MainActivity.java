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
                createAlertDialog();
            }
        });
    // non access modifier
        // final
    }
    private void createAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Hãy chọn 1 con vật yêu thích");
//                builder.setTitle("Bạn có thông báo mới");
//                builder.setMessage("Có phiên bản update mới");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        // single choice

        String [] arrAnimals = {"Mèo","Chó","Rùa","Gà","Vịt"};

//                builder.setSingleChoiceItems(arrAnimals, -1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int position) {
//                        Toast.makeText(MainActivity.this, arrAnimals[position], Toast.LENGTH_SHORT).show();
//                    }
//                });
        // Mutiple choice
        boolean [] arrChecked= {false, false, false, false, false};
        builder.setMultiChoiceItems(arrAnimals, arrChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Đã chọn con "+ arrAnimals[which], Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Bỏ chọn ", Toast.LENGTH_SHORT).show();
                }
            }
        });
//                selectedItems = new ArrayList();  // Where we track the selected items
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                // Set the dialog title
//                builder.setTitle(R.string.pick_toppings)
//                        // Specify the list array, the items to be selected by default (null for none),
//                        // and the listener through which to receive callbacks when items are selected
//                        .setMultiChoiceItems(R.array.toppings, null,
//                                new DialogInterface.OnMultiChoiceClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which,
//                                                        boolean isChecked) {
//                                        if (isChecked) {
//                                            // If the user checked the item, add it to the selected items
//                                            selectedItems.add(which);
//                                        } else if (selectedItems.contains(which)) {
//                                            // Else, if the item is already in the array, remove it
//                                            selectedItems.remove(Integer.valueOf(which));
//                                        }
//                                    }
//                                })
        //
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String animals = "";
//                        Toast.makeText(MainActivity.this, "Bạn chọn có", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < arrChecked.length; i++) {
                    if (arrChecked[i]){
                        animals += arrAnimals[i] + ",";
                    }
                }
                animals = animals.substring(0, animals.length()-1);
                Toast.makeText(MainActivity.this, "Ban da chon "+ animals, Toast.LENGTH_SHORT).show();
            }
        });
//                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "Bạn chọn không", Toast.LENGTH_SHORT).show();
//                    }
//                });

        builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bạn chọn Hủy", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}