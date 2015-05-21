package com.example.helloavengedsevenfold;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*
 * Class for creating application fragments
 */

public class HelloAvengedSevenfoldFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mPauseButton;
	private Button mStopButton;
	
        /*
         * Creates fragment
         */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

        /*
         * Creates buttons in fragment uses layout from fragment_hello_avenged_sevenfold.xml
         */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_avenged_sevenfold, parent, false);
                //Creates play button
		mPlayButton = (Button)v.findViewById(R.id.helloavengedsevenfold_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});
                //Creates pause button
		mPauseButton = (Button)v.findViewById(R.id.helloavengedsevenfold_pauseButton);
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.pause();
			}
		});
                //Creates stop button
		mStopButton = (Button)v.findViewById(R.id.helloavengedsevenfold_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.stop();	
			}
		});
		return v;
	}
	/*
         * Stops audio on destroy
         */
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}

