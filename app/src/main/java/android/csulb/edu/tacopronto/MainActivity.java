package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity implements View.OnClickListener {

    android.widget.Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RadioButton size_large = (RadioButton)findViewById(R.id.radiobutton_large);
        RadioButton size_small = (RadioButton)findViewById(R.id.radiobutton_small);

        Intent myIntent = new Intent(this, tortilla.class);
        if(size_large.isChecked()){
            myIntent.putExtra("key_size", "Large");
            this.startActivity(myIntent);
        }
        else{
            myIntent.putExtra("key_size","Small");
            this.startActivity(myIntent);
        }

    }
}

