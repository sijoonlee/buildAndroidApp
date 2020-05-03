package github.sijoonlee.tenthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMesssage(View v){
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Uri destination = Uri.parse("smsto:5556");
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);


    }
}
