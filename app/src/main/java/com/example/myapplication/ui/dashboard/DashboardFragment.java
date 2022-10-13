package com.example.myapplication.ui.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;

import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment implements LocationListener {

    public static final String TAG = "Stringi viesti";

    private FragmentDashboardBinding binding;


    LocationManager locationManager;


    private TextView latitudeTextView;
    private TextView longitudeTextView;
    private TextView addressTextView;
    public Address location;

    private Button btnLocation;

    String address;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        latitudeTextView = root.findViewById(R.id.Longitude);
        longitudeTextView = root.findViewById(R.id.Latitude);
        addressTextView = root.findViewById(R.id.Address);

        btnLocation = root.findViewById(R.id.btnLocation);


        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        //  Log.i(TAG, "asdasd");
        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
                ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        // Log.i(TAG, "asdasd 12 ");
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);

        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        // Log.i(TAG, "asdasd 2 " + String.valueOf(lastLocation.getLongitude()));

        longitudeTextView.setText(String.valueOf(lastLocation.getLongitude()));
        latitudeTextView.setText(String.valueOf(lastLocation.getLatitude()));
        addressTextView.setText(address);


        Geocoder geocoder;
        List<Address> addresses;
        Locale finnish = new Locale("fi", "FI");

        try {
            geocoder = new Geocoder(getContext(), finnish);

            addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(),
                    1); // Here 1 represent maxResults
            address = addresses.get(0).getAddressLine(0); // getAddressLine returns a line of the address
            addressTextView.setText(address);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }




        /*Uri gmmIntentUri = Uri.parse("Latitude: " + location.getLatitude() + ", " + "Longitude: " + location.getLongitude());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
            */



        btnLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Log.i(TAG, "KLIKKI TOIMII ");

                Uri gmmIntentUri = Uri.parse("geo:" + lastLocation.getLatitude() + "," + lastLocation.getLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                //  if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null)
                startActivity(mapIntent);


            }

        });
    }


    @Override
    public void onStop() {
        super.onStop();

        locationManager.removeUpdates(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        latitudeTextView.setText(String.valueOf(location.getLatitude()));
        longitudeTextView.setText(String.valueOf(location.getLongitude()));
        addressTextView.setText(address);
    }
}


