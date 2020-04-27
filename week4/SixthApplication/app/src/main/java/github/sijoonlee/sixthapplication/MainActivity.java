package github.sijoonlee.sixthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("COLOR_PREFERENCE", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        final RelativeLayout layoutBackground = (RelativeLayout) findViewById(R.id.layoutBackground);

        if(preferences.contains("colorId"))
            layoutBackground.setBackgroundColor(preferences.getInt("colorId", 0));

        RadioGroup radioGroupColors = (RadioGroup) findViewById(R.id.radioGroupColors);

        radioGroupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorCode = 0;
                if (checkedId == R.id.radioBlue)
                    colorCode = Color.BLUE;
                else if (checkedId == R.id.radioGreen)
                    colorCode = Color.GREEN;
                else if (checkedId == R.id.radioYellow)
                    colorCode = Color.YELLOW;

                layoutBackground.setBackgroundColor(colorCode);
                editor.putInt("colorId", colorCode);
                editor.commit();


            }
        });
    }
}
