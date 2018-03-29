package com.example.hefen.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefen on 3/29/2018.
 */

public class CFragment extends Fragment {
    View rootView;
    Context context;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    static List<String> msg_list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_c,container,false);
        context = rootView.getContext();

        initC();

        return rootView;
    }

    private void initC() {
        listView = rootView.findViewById(R.id.listView);
        arrayAdapter =new ArrayAdapter<String>(context, R.layout.item_layout,R.id.textView2, msg_list);
        listView.setAdapter(arrayAdapter);
    }

    public void updateList() {
        arrayAdapter.notifyDataSetChanged();
    }
}
