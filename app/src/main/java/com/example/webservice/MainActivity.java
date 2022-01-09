    package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;
    EditText etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        herramientas();

    }

    private void herramientas()
    {
        /*
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        etEmail=( EditText) findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);

         */
    }

    @Override
    public void onClick(View v)
    {
        final String email= etEmail.getText().toString();
        final String password=etPassword.getText().toString();
        final String direccion="http://192.168.1.70/conexion.php?u="+email+"&p="+password;
        RequestQueue servicio= Volley.newRequestQueue(getApplicationContext());
        if (!email.isEmpty() && !password.isEmpty())
        {
            StringRequest respuesta = new StringRequest(Request.Method.GET, direccion, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Error al conectar al serivdor",Toast.LENGTH_SHORT).show();
                }
            });
            servicio.add(respuesta);
        } else
            {
                Toast.makeText(getApplicationContext(),"Llenar todos los campos",Toast.LENGTH_LONG).show();
            }


    }
}