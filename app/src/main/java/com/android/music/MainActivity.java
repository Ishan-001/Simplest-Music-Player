package com.android.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String status = "paused";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView button = findViewById(R.id.button);

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.music);
        mPlayer.setLooping(true);

        button.setOnClickListener(v -> {
            switch (status){
                case "paused":
                    mPlayer.start();
                    setStatus("playing");
                    button.setImageResource(R.drawable.ic_pause);
                    break;

                case "playing":
                    mPlayer.pause();
                    setStatus("paused");
                    button.setImageResource(R.drawable.ic_play);
                    break;
            }
        });
    }

    public void setStatus(String mStatus){
        status = mStatus;
    }
}