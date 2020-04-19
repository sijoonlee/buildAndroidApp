package github.sijoonlee.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonMilesToKm = (Button) findViewById(R.id.buttonMilesToKm);
        Button buttonKmToMiles = (Button) findViewById(R.id.buttonKmToMiles);
        final EditText textFieldMiles = findViewById(R.id.editTextMiles);
        final EditText textFieldKm = findViewById(R.id.editTextKm);

        buttonMilesToKm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double vMiles = Double.valueOf(textFieldMiles.getText().toString());
                double vKm = vMiles/0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textFieldKm.setText(formatVal.format(vKm));
            }
        });

        buttonKmToMiles.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double vKm = Double.valueOf(textFieldKm.getText().toString());
                double vMiles = vKm * 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textFieldMiles.setText(formatVal.format(vMiles));
            }
        });
    }
}
