package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText signup_username;
    String username;
    Button signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup_username=(EditText)findViewById(R.id.signup_username);
        signup_btn=(Button)findViewById(R.id.signup_btn);
        Intent getIntent=getIntent();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=signup_username.getText().toString();

                if(username.length()==0){
                    Toast.makeText(SignupActivity.this, "이름만이라도 입력해주세여....", Toast.LENGTH_SHORT).show();
                }else{
                    Intent sendIntent=new Intent(SignupActivity.this, MainActivity.class);
                    sendIntent.putExtra("name",username);
                    startActivity(sendIntent);
                }

            }
        });


    }
}
