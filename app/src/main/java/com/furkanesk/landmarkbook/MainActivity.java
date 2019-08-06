package com.furkanesk.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView;
        listView = findViewById(R.id.listview);
        final ArrayList<String> liste = new ArrayList<String>();
        liste.add("İstanbul");
        liste.add("Ankara");
        liste.add("İzmir");

        Bitmap istanbulimage = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.istanbul);
        Bitmap ankaraimage = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ankara);
        Bitmap izmirimage = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.izmir);

        final ArrayList<Bitmap> cityguideImages = new ArrayList<>();

        cityguideImages.add(istanbulimage);
        cityguideImages.add(ankaraimage);
        cityguideImages.add(izmirimage);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,liste);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);

                intent.putExtra("name", liste.get(i));
                selectedImage = cityguideImages.get(i);

                startActivity(intent);

            }
        });
    }
}
