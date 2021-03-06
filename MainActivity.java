package com.example.user.iseng_mail;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText to,subject,msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=findViewById(R.id.to);
        subject=findViewById(R.id.subject);
        msg=findViewById(R.id.msg);
    }
    public void send(View view){
        sendmail();
    }

    protected void sendmail(){

      Intent mailIntent=new Intent(Intent.ACTION_SEND);
      mailIntent.setData(Uri.parse("mailto:"));
      mailIntent.setType("text/plain");

      String[] adress={to.getText().toString()};
      String sub=subject.getText().toString();
      String text=msg.getText().toString();

      mailIntent.putExtra(Intent.EXTRA_EMAIL,adress);
      mailIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
      mailIntent.putExtra(Intent.EXTRA_TEXT,text);
      try{
          startActivity(Intent.createChooser(mailIntent, "Send mail..."));
      }
      catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this,"No email adress",Toast.LENGTH_SHORT).show();
        }



    }
}
