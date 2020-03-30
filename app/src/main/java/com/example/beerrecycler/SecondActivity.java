package com.example.beerrecycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView saTVtitle,
             saTVdesc;
    ImageView saIVimg;

    String saTitle, saDesc, label;
    int saImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        saTVtitle = findViewById(R.id.saTVtitle);
        saTVdesc = findViewById(R.id.saTVdesc);
        saIVimg = findViewById(R.id.saIVimg);

        getData();
        setData();

        setTitle(label);

    }

    private void getData() {
        if(
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("description") &&
                getIntent().hasExtra("image")
        ) {
            saTitle = getIntent().getStringExtra("title");
            saDesc = getIntent().getStringExtra("description");
            saImg = getIntent().getIntExtra("image", 1);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        saTVtitle.setText(saTitle);
        saTVdesc.setText(saDesc);
        saIVimg.setImageResource(saImg);
        label = saTitle + " Details";
    }
}