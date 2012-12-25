package br.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class PlayerActivity extends Activity implements OnClickListener {

	private static final String TAG = "ActivityMain";

	private Spinner spinner;
	private String nomeRadio = "";

	private Button buttonPlay;

	private Button buttonStopPlay;
	
	private Intent intent;
	
	private ProgressBar progressBar;
	
	private Thread progressBarThread;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initializeUIElements();
		
		intent = new Intent(this,ServicePlayer.class);
	}

	private void initializeUIElements() {

		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		for (RadioEnum value : RadioEnum.values()) {
			adapter.add(value.getName());
		}

		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				nomeRadio = parent.getItemAtPosition(pos).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		buttonPlay = (Button) findViewById(R.id.buttonPlay);
		buttonPlay.setOnClickListener(this);

		buttonStopPlay = (Button) findViewById(R.id.buttonStopPlay);
		buttonStopPlay.setOnClickListener(this);
		
		//TODO
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		progressBar.setVisibility(View.GONE);
		
	}
	
	public void onClick(View src) {
		
		switch (src.getId()) {
		case R.id.buttonPlay:
			Log.i(TAG, "onClick: starting srvice");
			nomeRadio = spinner.getSelectedItem().toString();
			intent.putExtra("radioName", nomeRadio);
			
			if(isPlayerServiceRunning()){
				stopService(intent);
			}
			
			startService(intent);
			break;
		case R.id.buttonStopPlay:
			Log.d(TAG, "onClick: stopping srvice");
			stopService(intent);
			break;
		}
	}
	
	
	private boolean isPlayerServiceRunning() {
	    ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if ("br.player.ServicePlayer".equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
}