package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fillings extends Activity implements View.OnClickListener {

    android.widget.Button button;
    ArrayList item_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillings);

        item_list = (ArrayList) getIntent().getSerializableExtra("key_tortilla");

        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        CheckBox checkbox_beef = (CheckBox)findViewById(R.id.checkBox_beef);
        CheckBox checkbox_chicken = (CheckBox)findViewById(R.id.checkBox_chicken);
        CheckBox checkbox_whitefish = (CheckBox)findViewById(R.id.checkBox_whitefish);
        CheckBox checkbox_cheese = (CheckBox)findViewById(R.id.checkBox_cheese);
        CheckBox checkbox_seafood = (CheckBox)findViewById(R.id.checkBox_seafood);
        CheckBox checkbox_rice = (CheckBox)findViewById(R.id.checkBox_rice);
        CheckBox checkbox_beans = (CheckBox)findViewById(R.id.checkBox_beans);
        CheckBox checkbox_picodegallo = (CheckBox)findViewById(R.id.checkBox_picodegallo);
        CheckBox checkbox_guacamole = (CheckBox)findViewById(R.id.checkBox_guacamole);
        CheckBox checkbox_lbt = (CheckBox)findViewById(R.id.checkBox_lbt);

        Intent myIntent = new Intent(this, beverages.class);
        if(checkbox_beef.isChecked()){
            item_list.add("Beef");
        }
        if(checkbox_chicken.isChecked()){
            item_list.add("Chicken");
        }
        if(checkbox_whitefish.isChecked()){
            item_list.add("Whitefish");
        }
        if(checkbox_cheese.isChecked()){
            item_list.add("Cheese");
        }
        if(checkbox_seafood.isChecked()){
            item_list.add("Seafood");
        }
        if(checkbox_rice.isChecked()){
            item_list.add("Rice");
        }
        if(checkbox_beans.isChecked()){
            item_list.add("Beans");
        }
        if(checkbox_picodegallo.isChecked()){
            item_list.add("Picodegallo");
        }
        if(checkbox_guacamole.isChecked()){
            item_list.add("Guacamole");
        }
        if(checkbox_lbt.isChecked()){
            item_list.add("Lbt");
        }
        System.out.print(item_list);
        myIntent.putExtra("key_fillings",item_list);
        this.startActivity(myIntent);
    }
}