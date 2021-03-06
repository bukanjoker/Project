package example.dmesenv1_2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
 

public class OrderList extends MainActivity{
	
	String harga;
	String nama;
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        
        TextView nama = (TextView) findViewById(R.id.textView2);
        TextView harga = (TextView) findViewById(R.id.textView3);
        
        Intent i = this.getIntent();
        
        String s = i.getExtras().getString("nama");
        String h = i.getExtras().getString("harga");
//        int position = i.getExtras().getInt("id_gbr");
        
        nama.setText(s);
        harga.setText(h);
        
        Button tambah = (Button)findViewById(R.id.tambah);
        tambah.setOnClickListener(new View.OnClickListener()
        {
        	
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(OrderList.this, MenuList.class);
                startActivity(i);
            }
        });
        
        
        
        /*Button ok = (Button)findViewById(R.id.buttonOk);
        ok.setOnClickListener(new View.OnClickListener()
        {
        	
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(OrderList.this, Send.class);
                startActivity(i);
            }
        });*/
        
        //final TextView nama = (TextView) findViewById(R.id.textView2);
        //final TextView harga = (TextView) findViewById(R.id.textView3);
	}
	

	
public void onCreate2(Bundle savedInstanceState) {
    //super.onCreate(savedInstanceState);
    //setContentView(R.layout.order);
    
    final TextView nama = (TextView) findViewById(R.id.textView2);
    final TextView harga = (TextView) findViewById(R.id.textView3);
    
    /*Button ok = (Button) findViewById(R.id.buttonOk);
    
    ok.setOnClickListener(new View.OnClickListener() {
		
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			
		//nama = nama.getText().toString();
		//harga = harga.getText().toString();
		
		insert();
	}
});*/
}

public void insert()
{
	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

	nameValuePairs.add(new BasicNameValuePair("nama",nama));
	nameValuePairs.add(new BasicNameValuePair("harga",harga));
	
	try
	{
	HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://10.0.2.2/insert.php");
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpclient.execute(httppost); 
        HttpEntity entity = response.getEntity();
        is = entity.getContent();
        Log.e("pass 1", "connection success ");
}
    catch(Exception e)
{
    	Log.e("Fail 1", e.toString());
    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
		Toast.LENGTH_LONG).show();
}     
    
    try
    {
        BufferedReader reader = new BufferedReader
		(new InputStreamReader(is,"iso-8859-1"),8);
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null)
    {
            sb.append(line + "\n");
        }
        is.close();
        result = sb.toString();
    Log.e("pass 2", "connection success ");
}
    catch(Exception e)
{
        Log.e("Fail 2", e.toString());
}     
   
try
{
        JSONObject json_data = new JSONObject(result);
        code=(json_data.getInt("code"));
		
        if(code==1)
        {
	Toast.makeText(getBaseContext(), "Inserted Successfully",
		Toast.LENGTH_SHORT).show();
        }
        else
        {
	 Toast.makeText(getBaseContext(), "Sorry, Try Again",
		Toast.LENGTH_LONG).show();
        }
}
catch(Exception e)
{
        Log.e("Fail 3", e.toString());
}
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}}    
