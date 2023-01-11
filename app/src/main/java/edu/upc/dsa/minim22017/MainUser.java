package edu.upc.dsa.minim22017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainUser extends AppCompatActivity {

    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Toast.makeText(getApplicationContext(), sharedPreferences.getString("username",""),Toast.LENGTH_LONG).show();
        String avatar1 = sharedPreferences.getString("username","");

        avatar = findViewById(R.id.avatar);

        Picasso.get().load(sharedPreferences.getString("username","")).into(avatar);
    }
}