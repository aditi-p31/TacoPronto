package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tortilla extends Activity implements View.OnClickListener {

    android.widget.Button button;
    ArrayList item_list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tortilla);

        //Bundle myInput = this.getIntent().getExtras();
        String item = getIntent().getStringExtra("key_size");
        item_list.add(item);

        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RadioButton tortilla_corn = (RadioButton)findViewById(R.id.radiobutton_corn);
        RadioButton tortilla_flour = (RadioButton)findViewById(R.id.radiobutton_flour);

        Intent myIntent = new Intent(this, fillings.class);
        if(tortilla_corn.isChecked()){
            item_list.add("Corn");
        }
        else{
            item_list.add("Flour");
        }
        System.out.println(item_list);
        myIntent.putExtra("key_tortilla", item_list);
        this.startActivity(myIntent);
    }
}
