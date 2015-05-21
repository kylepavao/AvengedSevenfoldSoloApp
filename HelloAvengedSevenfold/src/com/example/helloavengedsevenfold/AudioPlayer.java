package com.example.helloavengedsevenfold;

import android.content.Context;
import android.media.MediaPlayer;

/*
 * Class used to create an object to play audio
 */
public class AudioPlayer {
	private MediaPlayer mPlayer;
	private int playTime;
	
        /*
         * Resets audio clip to 0th second
         */
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
        /*
         * Pauses audio clip
         */
	public void pause() {
		playTime = mPlayer.getCurrentPosition();
		mPlayer.pause();
	}
	
        /*
         * Plays audio clip
         */
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
