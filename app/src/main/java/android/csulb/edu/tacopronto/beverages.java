package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;


public class beverages extends Activity implements View.OnClickListener {

    android.widget.Button button;
    ArrayList item_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);

        item_list = (ArrayList) getIntent().getSerializableExtra("key_fillings");

        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        CheckBox checkbox_soda = (CheckBox)findViewById(R.id.checkBox_soda);
        CheckBox checkbox_cerveza = (CheckBox)findViewById(R.id.checkBox_cerveza);
        CheckBox checkbox_margarita = (CheckBox)findViewById(R.id.checkBox_margarita);
        CheckBox checkbox_tequila = (CheckBox)findViewById(R.id.checkBox_tequila);


        Intent myIntent = new Intent(this, summary.class);
        if(checkbox_soda.isChecked()){
            item_list.add("Soda");
        }
        if(checkbox_cerveza.isChecked()){
            item_list.add("Cerveza");
        }
        if(checkbox_margarita.isChecked()){
            item_list.add("Margarita");
        }
        if(checkbox_tequila.isChecked()){
            item_list.add("Tequila");
        }
        String list = item_list.toString();
        System.out.println(list);

        try {
            myIntent.putExtra("key_beverages", item_list);
            startActivity(myIntent);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}