package com.example.googlemapapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    public static final String KEY_CODE ="KEY_CODE" ;
    Button btn_hospitals,btn_restaurant,btn_atm,btn_cafe;
    CardView cv_main;
    String strNameHospital = "hospital";
    String strNameRestaurant = "restaurant";
    String strNameATM = "atm";
    String strNameCafe = "cafe";
    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hospitals=findViewById(R.id.btn_doctorlist);
        btn_restaurant=findViewById(R.id.btn_restaurant_list);
        btn_atm=findViewById(R.id.btn_atm_list);
        btn_cafe=findViewById(R.id.btn_cafe_list);
        cv_main=findViewById(R.id.cv_main);

        btn_hospitals.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv_main.setVisibility(View.GONE);
                bundle.putString(KEY_CODE,strNameHospital);
                intent.putExtras(bundle);
                NearByLocationFragment nearByHospitalFragment= new NearByLocationFragment();

                nearByHospitalFragment.setArguments(bundle);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home,nearByHospitalFragment);
                fragmentTransaction.commit();
            }
        });
        btn_restaurant.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv_main.setVisibility(View.GONE);
                bundle.putString(KEY_CODE,strNameRestaurant);
                intent.putExtras(bundle);

                NearByLocationFragment nearByHospitalFragment= new NearByLocationFragment();
                nearByHospitalFragment.setArguments(bundle);

                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home,nearByHospitalFragment);
                fragmentTransaction.commit();
            }
        });
        btn_atm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv_main.setVisibility(View.GONE);

                bundle.putString(KEY_CODE,strNameATM);
                intent.putExtras(bundle);
                NearByLocationFragment nearByHospitalFragment= new NearByLocationFragment();

                nearByHospitalFragment.setArguments(bundle);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home,nearByHospitalFragment);
                fragmentTransaction.commit();
            }
        });
        btn_cafe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cv_main.setVisibility(View.GONE);

                bundle.putString(KEY_CODE,strNameCafe);
                intent.putExtras(bundle);
                NearByLocationFragment nearByHospitalFragment= new NearByLocationFragment();

                nearByHospitalFragment.setArguments(bundle);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home,nearByHospitalFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
