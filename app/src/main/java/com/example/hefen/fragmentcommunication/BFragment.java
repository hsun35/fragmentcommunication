package com.example.hefen.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hefen on 3/29/2018.
 */

public class BFragment extends Fragment{
    View rootView;
    Context context;
    String msg;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_b,container,false);

        initB();

        return rootView;
    }

    private void initB() {
        textView = rootView.findViewById(R.id.textView);
        if (msg != null && msg.length() != 0) {
            textView.setText(msg);
        }
        Log.i("mylog", "initB");
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setTextView(String msg) {
        Log.i("mylog", "setB");
        textView.setText(msg);
    }
}
