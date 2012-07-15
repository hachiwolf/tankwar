package com.timbo.tankwar;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	MediaPlayer player ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		player = MediaPlayer.create(this,R.raw.start_music);
//		player.setLooping(true);
		try {
			player.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.start();
		setContentView(new MySurfaceView(this));
	}
	@Override
	protected void onPause() {
		super.onPause();
		player.stop();
		player.release();
		
	}
	@Override
	protected void onResume() {
		super.onResume();
	}
}
