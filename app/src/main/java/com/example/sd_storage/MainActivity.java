package com.example.sd_storage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] verNames, dates;
    ListView lstversions;

    int[] logo = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.ginger, R.drawable.honeycomb, R.drawable.ice};

    ArrayList<AndroidVersion> versions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Android Version");

        verNames = getResources().getStringArray(R.array.verName);
        dates = getResources().getStringArray(R.array.rDate);

        for(int i = 0; i < verNames.length; i++){
            versions.add(new AndroidVersion(logo[i], verNames[i], dates[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, versions);
        lstversions = findViewById(R.id.lvAndroid);
        lstversions.setAdapter(adapter);
        lstversions.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,final int i, long id) {
        //Toast.makeText(this, verNames[i], Toast.LENGTH_LONG).show();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(verNames[i]);
        dialog.setMessage(dates[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, verNames[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();

    }
}
