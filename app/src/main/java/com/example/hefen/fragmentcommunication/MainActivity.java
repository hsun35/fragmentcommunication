package com.example.hefen.fragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SendMessage{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AFragment aFragment;
    BFragment bFragment;
    CFragment cFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();
        if(findViewById(R.id.activity_main_portrait)!= null){
            addAFragment();
        } else if(findViewById(R.id.activity_main_large)!= null) {
            addAFragment();
            addBFragment();
            addCFragment();
        }
    }

    @Override
    public void sendData(int item_index, String msg) {
        if(findViewById(R.id.activity_main_portrait)!= null){
            if (item_index == 1) {
                addBFragment(msg);
            } else if (item_index == 2) {
                if (msg != null && msg.length() != 0) {
                    CFragment.msg_list.add(msg);
                }
                addCFragment();
            }
        } else if(findViewById(R.id.activity_main_large)!= null) {
            if (item_index == 1) {
                bFragment.setTextView(msg);
            } else if (item_index == 2) {
                if (msg != null && msg.length() != 0) {
                    CFragment.msg_list.add(msg);
                    cFragment.updateList();
                }

            }
        }
    }

    private void addAFragment(){
        //AFragment aFragment;
        fragmentTransaction=fragmentManager.beginTransaction();

        //aFragment = new AFragment();
        aFragment.setSendMessage(MainActivity.this);

        if(findViewById(R.id.activity_main_portrait)!= null) {
            fragmentTransaction.replace(R.id.frameLayout, aFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (findViewById(R.id.activity_main_large)!= null) {
            fragmentTransaction.replace(R.id.frameLayout_a, aFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
    private void addBFragment(){
        //BFragment bFragment;
        fragmentTransaction=fragmentManager.beginTransaction();

        //bFragment = new BFragment();

        if(findViewById(R.id.activity_main_portrait)!= null) {
            fragmentTransaction.replace(R.id.frameLayout, bFragment)
                                .addToBackStack(null)
                                .commit();
        } else if(findViewById(R.id.activity_main_large)!= null) {
            fragmentTransaction.replace(R.id.frameLayout_b, bFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
    private void addBFragment(String msg){
        //BFragment bFragment;
        fragmentTransaction=fragmentManager.beginTransaction();

        bFragment.setMsg(msg);

        fragmentTransaction.replace(R.id.frameLayout, bFragment)
                .addToBackStack(null)
                .commit();

    }
    private void addCFragment(){
        //CFragment cFragment;
        fragmentTransaction=fragmentManager.beginTransaction();

        //cFragment = new CFragment();

        if(findViewById(R.id.activity_main_portrait)!= null) {
            fragmentTransaction.replace(R.id.frameLayout, cFragment)
                    .addToBackStack(null)
                    .commit();
        } else if(findViewById(R.id.activity_main_large)!= null) {
            fragmentTransaction.replace(R.id.frameLayout_c, cFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
