package com.daotrung.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edtPhone , edtEmail , edtName , edtCompany , edtPass;
    Button btnLogin ;
    TextView txtNote , txtWarning1,txtWarning2,txtWarning3,txtWarning4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCompany = findViewById(R.id.edtCompany);
        edtPass = findViewById(R.id.edtPassword);
        edtName = findViewById(R.id.edtFullname);
        btnLogin = findViewById(R.id.btnLogin);
        txtNote = findViewById(R.id.txtNote);
        txtWarning1 = findViewById(R.id.txtWarning1);
        txtWarning2 = findViewById(R.id.txtWarning2);
        txtWarning3 = findViewById(R.id.txtWarning3);
        txtWarning4 = findViewById(R.id.txtWarning4);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Phone
                String phone = edtPhone.getText().toString();
                Pattern pPhone = Pattern.compile("^[0-9]{10,11}$");
                if(pPhone.matcher(phone).find()){
                    txtNote.setVisibility(View.INVISIBLE);
                }else{
                    txtNote.setVisibility(View.VISIBLE);
                }
                // Email
                String email = edtEmail.getText().toString();
                Pattern pEmail = Pattern.compile("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
                if(pEmail.matcher(email).find()){
                    txtWarning1.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning1.setVisibility(View.VISIBLE);
                    txtNote.setVisibility(View.VISIBLE);
                }
                //Name
                String name = edtName.getText().toString();
                Pattern pName = Pattern.compile("[a-zA-Z]+\\.?");
                if(pName.matcher(name).find()){
                    txtWarning2.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning2.setVisibility(View.VISIBLE);
                }
                //Company
                String company = edtCompany.getText().toString();
                Pattern pCompany = Pattern.compile("[a-zA-Z]+\\.?");
                if(pCompany.matcher(company).find()){
                    txtWarning3.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning3.setVisibility(View.VISIBLE);
                }
                //Pass
                String pass = edtPass.getText().toString();
                Pattern pPass = Pattern.compile("^.{8,}$");
                if(pPass.matcher(pass).find()){
                    txtWarning4.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning4.setVisibility(View.VISIBLE);
                    txtNote.setVisibility(View.VISIBLE);
                }
            }
        });





    }
}