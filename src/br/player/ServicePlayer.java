package br.player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServicePlayer extends Service {
	private static final String TAG = "ServicePlayer";
	MediaPlayer player;

	private String radioName = "";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		Bundle extras = intent.getExtras();
		radioName = (String) extras.get("radioName");
		Log.i("radioName from service", radioName);

		Uri uri;

		// Get the url from this radio
		uri = Uri.parse(Radios.getRadio(radioName));

		// TODO -- overhead here...
		player = MediaPlayer.create(this, uri);

		player.setLooping(false); // Set looping

		player.start();
		
		// We want this service to continue running until it is explicitly
		// stopped, so return sticky.
		return START_REDELIVER_INTENT;
	}
}
