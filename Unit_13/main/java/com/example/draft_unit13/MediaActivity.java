package com.example.draft_unit13;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MediaActivity extends MyActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        super.current_item = R.id.item_media;

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player == null)
            return;
        player.release();
        player = null;
        Toast.makeText(this, "MediaPlayer Released", Toast.LENGTH_LONG).show();
    }
}