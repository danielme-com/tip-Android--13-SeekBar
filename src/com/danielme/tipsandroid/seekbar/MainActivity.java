package com.danielme.tipsandroid.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.danieme.tipsandroid.seekbar.R;

/**
 * 
 * @author danielme.com
 *
 */
public class MainActivity extends Activity
{

	private SeekBar seekBar;
	
	private TextView textViewSeekBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekBar = (SeekBar) findViewById(R.id.seekBar);
		textViewSeekBar = (TextView) findViewById(R.id.textView);
		textViewSeekBar.setText("20");
		

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {            
          
            private Toast toastStart = Toast.makeText(MainActivity.this, getText(R.string.start), Toast.LENGTH_SHORT);
			private Toast toastStop = Toast.makeText(MainActivity.this, getText(R.string.stop), Toast.LENGTH_SHORT);

			@Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                 //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                 textViewSeekBar.setText(progress + 20 + "");                 
            }

           /**
            * El usuario inicia la interacción con la Seekbar.
            */
			@Override
			public void onStartTrackingTouch(SeekBar arg0)
			{
				toastStop.cancel();
				toastStart.setGravity(Gravity.TOP|Gravity.LEFT, 60, 110);
				toastStart.show();
			}

			/**
	         * El usuario finaliza la interacción con la Seekbar.
	        */
			@Override
			public void onStopTrackingTouch(SeekBar arg0)
			{
				toastStart.cancel();
				toastStop.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 110);
				toastStop.show();				
			}
     });
		
	}
}