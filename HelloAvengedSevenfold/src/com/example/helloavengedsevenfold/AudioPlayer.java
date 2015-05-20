package com.example.helloavengedsevenfold;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	private int playTime;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void pause() {
		playTime = mPlayer.getCurrentPosition();
		mPlayer.pause();
	}
		
	public void play(Context c) {
			stop();
			mPlayer = MediaPlayer.create(c, R.raw.bat_country_solo);
			mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {
					stop();
				}
			});
			mPlayer.seekTo(playTime);
			mPlayer.start();
	}
}
