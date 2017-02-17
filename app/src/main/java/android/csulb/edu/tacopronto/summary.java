package android.csulb.edu.tacopronto;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class summary extends Activity implements View.OnClickListener {


    ArrayList item_list;
    android.widget.Button button;
    int amount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        item_list = (ArrayList) getIntent().getSerializableExtra("key_beverages");

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter array_adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item_list);
        listView.setAdapter(array_adapter);

        try {

            InputStream fXmlFile = getAssets().open("MenuList.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(item_list.contains(eElement.getElementsByTagName("name").item(0).getTextContent())){
                        amount = amount + Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = (Button) this.findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message="Order:\n";

        Iterator itr = item_list.iterator();
        while(itr.hasNext()){
            message = message + itr.next().toString() + "\n";
        }
        message = message + "Amount: " + amount;

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+15512425898", null, message, null, null);
        Toast.makeText(getApplicationContext(), "Your Order is placed", Toast.LENGTH_LONG).show();
    }
}