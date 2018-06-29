package com.example.hp.saving;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    Button regBtn,logBtn;
    TextView welcome;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        regBtn=(Button)findViewById(R.id.register);
        logBtn=(Button)findViewById(R.id.login);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("Prefs",MODE_PRIVATE);
                String details= sharedPreferences.getString(user + pass + "data"  ,"sorry invalid" );

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("display",details);

                editor.commit();
                Intent i=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i2);
            }
        });
    }
}