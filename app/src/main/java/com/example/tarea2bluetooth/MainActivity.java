package com.example.tarea2bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI(){

        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button mButtonOn = (Button) findViewById(R.id.btnTurnOn);
        mButtonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                    TextView mTextView = (TextView) findViewById(R.id.lblContent);
                    mTextView.setText(mTextView.getText().toString() + "\n" + "Bluetooth fue encendido");
                    Toast.makeText(getApplicationContext(), "Bluetooth encendido satisfactoriamente", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Bluetooth ya se encuentra encendido", Toast.LENGTH_SHORT).show();
            }
        });

        Button mButtonOff = (Button) findViewById(R.id.btnTurnOff);
        mButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.disable();
                    TextView mTextView = (TextView) findViewById(R.id.lblContent);
                    mTextView.setText(mTextView.getText().toString() + "\n" + "Bluetooth fue apagado");
                    Toast.makeText(getApplicationContext(), "Bluetooth apagado satisfactoriamente", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Bluetooth ya se encuentra apagado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
