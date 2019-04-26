package com.example.googlemapapi;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

import Model.Result;
import SharedPreference.SharedPreferenceClass;



/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleMapFragment extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener
{
    private GoogleMap mMap;
    ProgressBar loaddata;
    double currentLatitude;
    double currentLongitude;
    public static final String KEY_POSITION="KEY_MAP";
    String name;



    //Response latlong;
    double responseLatitude;
    double responseLongitude;

    public GoogleMapFragment()
    {
        // Required empty public constructor
    }

    public static GoogleMapFragment newInstance(Result result)
    {
        GoogleMapFragment fragment = new GoogleMapFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_POSITION,result);

        Log.e("TAG","GetResultValue"+result);

        fragment.setArguments(args);
        return fragment;
    }

    public  void GetData()
    {


        //Get result value

        Result result= (Result) getArguments().getSerializable(KEY_POSITION);

        //Response LatLong;

            responseLatitude=  result.getGeometry().getLocation().getLat();
            responseLongitude= result.getGeometry().getLocation().getLng();

            name=result.getName();

        Log.e("TAG","GetResponseResultValue"+responseLatitude);
        Log.e("TAG","GetResponseResultValue"+responseLongitude);

        //Current LatLong

        SharedPreferenceClass sharedPreferenceClass=new SharedPreferenceClass(getContext());

        currentLatitude= Double.valueOf(sharedPreferenceClass.getStr("latitude"));
        currentLongitude= Double.valueOf(sharedPreferenceClass.getStr("longitude"));

        Log.e("TAG","GetCurrentResultValue"+currentLatitude);
        Log.e("TAG","GetCurrentResultValue"+currentLongitude);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_google_map, null, false);
        //loaddata=v.findViewById(R.id.loadingdata_progress);
       // loaddata.setVisibility(View.VISIBLE);
        SupportMapFragment mapFragment= (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map_id);

        GetData();

        mapFragment.getMapAsync(this);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
       // mMap.setOnMapClickListener(this);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED)
        {
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.setTrafficEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);



//        LatLng currentlocation=new LatLng(currentLatitude,currentLongitude);
//        LatLng responselocation=new LatLng(responseLatitude,responseLongitude);

//        Log.e("LocationTag","loc"+currentlocation);
//        Log.e("LocationTag","loc"+responselocation);

//        mMap.addMarker(new MarkerOptions().position(currentlocation));
//        mMap.addMarker(new MarkerOptions().position(responselocation));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentlocation,13));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(responselocation,13));
//        mMap.setOnMarkerDragListener(this);

//        MarkerOptions markerOptions=new MarkerOptions();
//        markerOptions.position(currentlocation);
//        markerOptions.position(responselocation);
//       // mMap.clear(ions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
//        markerOptions.getPosition();
//);
//        markerOptions.title("Current Position");
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
//        markerOptions.getPosition();
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentlocation,5));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(responselocation,5));
//        mMap.addMarker(markerOptions);

       // loaddata.setVisibility(View.INVISIBLE);

        LatLng startlocation=new LatLng(currentLatitude,currentLongitude);
        LatLng endlocation=new LatLng(responseLatitude,responseLongitude);



        mMap.addMarker(new MarkerOptions().position(startlocation).title("My Location"));
        mMap.addMarker(new MarkerOptions().position(endlocation).title(name));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startlocation,15));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(endlocation,15));


        ArrayList<LatLng> points = new ArrayList<LatLng>();
        PolylineOptions polyLineOptions = new PolylineOptions();
        points.add(new LatLng(currentLatitude,currentLongitude));
        points.add(new LatLng(responseLatitude,responseLongitude));
        polyLineOptions.width(7 * 1);
        polyLineOptions.geodesic(true);
        polyLineOptions.color(getActivity().getResources().getColor(R.color.colorAccent));
        polyLineOptions.addAll(points);
        Polyline polyline = mMap.addPolyline(polyLineOptions);
        polyline.setGeodesic(true);

//        Routing routing=new Routing.Builder().
//                travelMode(AbstractRouting.TravelMode.WALKING).
//                withListener(this).
//                alternativeRoutes(true).
//                waypoints(startlocation,endlocation).build();
//
//        routing.execute();
    }

    @Override
    public void onMapClick(LatLng latLng)
    {

    }

//    @Override
//    public void onRoutingFailure(RouteException e)
//    {
//
//    }
//
//    @Override
//    public void onRoutingStart()
//    {
//
//    }
//
//    @Override
//    public void onRoutingSuccess(ArrayList<Route> arrayList, int i)
//    {
//        for (i=0;i<arrayList.size();i++)
//        {
//
//            PolylineOptions polyLineOptions = new PolylineOptions();
//            polyLineOptions.color(getActivity().getResources().getColor(R.color.colorAccent));
//            polyLineOptions.width(7);
//            polyLineOptions.addAll(arrayList.get(i).getPoints());
//            Polyline polyline = mMap.addPolyline(polyLineOptions);
//            polyline.setGeodesic(true);
//
//            Toast.makeText(getContext(),"Route "+ (i+1) +": distance - "+
//                    arrayList.get(i).getDistanceValue()+": " +
//                    "duration - "+ arrayList.get(i).getDurationValue(),Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onRoutingCancelled()
//    {
//
//    }
}
