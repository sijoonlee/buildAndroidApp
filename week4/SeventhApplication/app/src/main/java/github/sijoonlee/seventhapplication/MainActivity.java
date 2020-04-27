package github.sijoonlee.seventhapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import github.sijoonlee.seventhapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView_small = (ImageView) findViewById(R.id.imageView_small);
        imageView_small.setImageResource(R.drawable.goodjob);
        final ImageView imageView_large = (ImageView) findViewById(R.id.imageView_large);
        imageView_large.setImageResource(R.drawable.goodjob);

        SeekBar tuner = (SeekBar) findViewById(R.id.seekBar_tuner);
        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageView_large.setColorFilter(Color.argb(255,0,lastProgress,255-lastProgress));
            }
        });
    }
}
