package com.example.robotcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {

    private Button buttonStop;
    private Button buttonStart;
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clientId = MqttClient.generateClientId();
                final MqttAndroidClient client =
                        new MqttAndroidClient(MainActivity.this, "tcp://192.168.1.105:1883",
                                clientId);

                try {
                    IMqttToken token = client.connect();
                    token.setActionCallback(new IMqttActionListener() {
                        @Override
                        public void onSuccess(IMqttToken asyncActionToken) {
                            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                            Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();

                        }
                    });
                } catch (MqttException e) {
                    e.printStackTrace();
                }

                upButton = findViewById(R.id.upButton);
                upButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String topic = "movement/move";
                        String payload = "w";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });

                downButton = findViewById(R.id.downButton);
                downButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String topic = "movement/move";
                        String payload = "s";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });

                rightButton = findViewById(R.id.rightButton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String topic = "movement/move";
                        String payload = "d";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });

                leftButton = findViewById(R.id.leftButton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String topic = "movement/move";
                        String payload = "a";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });

                buttonStop = findViewById(R.id.buttonStop);
                buttonStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            IMqttToken disconToken = client.disconnect();
                            disconToken.setActionCallback(new IMqttActionListener() {
                                @Override
                                public void onSuccess(IMqttToken asyncActionToken) {
                                    Toast.makeText(MainActivity.this, "Disconnected", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(IMqttToken asyncActionToken,
                                                      Throwable exception) {
                                    Toast.makeText(MainActivity.this, "Fail to disconnect", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }

}
