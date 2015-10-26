package com.johnsandroidstudiotutorials.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		defineButtons();
	}

	public void defineButtons() {
		findViewById(R.id.basic_toast_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.gravity_toast_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.duration_toast_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.combo_toast_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.custom_toast_0_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.custom_toast_1_button).setOnClickListener(buttonClickListener);
		findViewById(R.id.physical_toast_button).setOnClickListener(buttonClickListener);
	}

	private View.OnClickListener buttonClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			switch (view.getId()) {
				case R.id.basic_toast_button:
					basicToast();
					break;
				case R.id.gravity_toast_button:
					gravityToast();
					break;
				case R.id.duration_toast_button:
					durationToast();
					break;
				case R.id.combo_toast_button:
					comboToast();
					break;
				case R.id.custom_toast_0_button:
					customToast0();
					break;
				case R.id.custom_toast_1_button:
					customToast1();
					break;
				case R.id.physical_toast_button:
					physicalToast();
					break;
			}
		}
	};

	private void basicToast() {
		Toast.makeText(MainActivity.this, "Basic Toast", Toast.LENGTH_SHORT).show();
		/* You could also use Toast.Length_Long
		*
         */
	}

	private void gravityToast() {
		Toast toast = Toast.makeText(getApplicationContext(), "Your toast message.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
		toast.show();
	}

	private void durationToast() {
		Toast toast = Toast.makeText(getApplicationContext(), "Your toast message.", Toast.LENGTH_SHORT);
		//toast.setDuration();
		toast.show();

	}

	private void comboToast() {
		Toast toast = Toast.makeText(getApplicationContext(), "Your toast message.", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
		// toast.setDuration();
		toast.show();
	}

	private void customToast0() {
		//Inflating our custom layout in the LayoutInflater
		LayoutInflater customInflater = getLayoutInflater();
		View customToastLayout = customInflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toast_layout_container));

		//Getting our defined text view from the custom_layout_container
		TextView customText = (TextView) customToastLayout.findViewById(R.id.custom_toast_text);
		customText.setText("This is Custom Toast");

		//create the object for the toast and the duration of the display
		Toast customToast = new Toast(getApplicationContext());
		customToast.setDuration(Toast.LENGTH_SHORT);
		customToast.setView(customToastLayout);
		customToast.setGravity(Gravity.TOP | Gravity.CENTER,0,0);
		customToast.show();
	}

	private void customToast1() {
		//Inflating our custom layout in the LayoutInflater
		LayoutInflater customInflater = getLayoutInflater();
		View customToastLayout = customInflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toast_layout_container));

		//Getting our defined text view from the custom_layout_container
		TextView customText = (TextView) customToastLayout.findViewById(R.id.custom_toast_text);
		customText.setText("This is Custom Toast");

		//create the object for the toast and the duration of the display
		Toast customToast = new Toast(getApplicationContext());
		customToast.setDuration(Toast.LENGTH_LONG);
		customToast.setView(customToastLayout);
		customToast.setGravity(Gravity.RIGHT | Gravity.CENTER,0,0);
		customToast.show();
	}

	private void physicalToast() {
		Toast.makeText(MainActivity.this, "Error 6%255#55$52 \n this feature is not yet available", Toast.LENGTH_SHORT).show();
	}
}
