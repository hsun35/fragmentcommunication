package com.example.hefen.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hefen on 3/29/2018.
 */

public class AFragment extends Fragment{
    SendMessage sendMessage;
    View rootView;
    Context context;
    Button btn_b;
    Button btn_c;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_a,container,false);

        initA();

        return rootView;
    }

    private void initA() {
        btn_b = rootView.findViewById(R.id.button);
        btn_c = rootView.findViewById(R.id.button2);
        editText = rootView.findViewById(R.id.editText);

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();
                sendMessage.sendData(1,msg);
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();
                sendMessage.sendData(2,msg);
            }
        });
    }

    public void setSendMessage(SendMessage sendMessage){
        this.sendMessage = sendMessage;
    }
}
