package edu.example.lifecycleexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	public void setButtons() {
		Button onCreate = (Button) findViewById(R.id.on_create);
		Button onDestroy = (Button) findViewById(R.id.on_destroy);
		Button onPause = (Button) findViewById(R.id.on_pause);
		Button onStart = (Button) findViewById(R.id.on_start);
		Button onStop = (Button) findViewById(R.id.on_stop);
		Button onResume = (Button) findViewById(R.id.on_resume);
		
		onCreate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_create_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
		
		onStop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_stop_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
		
		onDestroy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_destroy_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
		
		onPause.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_pause_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
		
		onResume.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_resume_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
		
		onStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.on_start_layout);
				Button backButton = (Button) findViewById(R.id.go_back);
				backButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						setContentView(R.layout.activity_main);
						setButtons();
					}
				});
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("De: onCreate(). Eu sou o android. Estou criando uma nova Activity.");
		setContentView(R.layout.activity_main);
		setButtons();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("De: onStart(). I feel so Alive. I'm ready to start!");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("De: onDestroy(). Perdão Android, eu imploro, miséricórdia! O Iphone me seduziu, mas é sua liberdade "
				+ "que eu amo");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("De: onStop(). A aplicação foi parada. The end is close, "
				+ "fella. My Activity feels it's gonna die :'(");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("De: onResume(). Aplicação resumida. Eu adoro quando você me foca assim, Android.");
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("De: onPause(). A aplicação foi pausada. Com carinho, Android.");
	}
}
