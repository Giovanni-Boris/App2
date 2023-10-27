package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String FILTRO = "com.example.app1.lab04";
    EditText mensajeText;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enviar = findViewById(R.id.buttonEnviar);
        mensajeText = findViewById(R.id.editTextMensaje);
        IntentFilter filter = new IntentFilter(FILTRO);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mensajeText.getText().toString();
                enviarMensajeAApp2(msg);
            }
        });
    }


    public void enviarMensajeAApp2(String mensaje) {
        Intent intent = new Intent(FILTRO);
        intent.putExtra("mensaje", mensaje);
        sendBroadcast(intent);
    }
}