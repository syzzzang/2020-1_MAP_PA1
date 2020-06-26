package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView login_signup_txt;
    EditText login_username;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_signup_txt=(TextView)findViewById(R.id.login_signupbtn);
        login_username=(EditText)findViewById(R.id.login_username);
        login_btn=(Button)findViewById(R.id.login_btn);

        Intent getintent=getIntent();
        String username=getintent.getStringExtra("name");
        login_username.setText(username);

        login_signup_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(login_username.length()==0){
//                    Toast.makeText(MainActivity.this, "username이라도 써줘여...", Toast.LENGTH_SHORT).show();
//                }else{
                    Intent intent= new Intent(MainActivity.this,MainpageActivity.class);
                    startActivity(intent);
//                }

            }
        });



    }
}
