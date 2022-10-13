package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.GameActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public static final String TAG = "MyAppMessage";

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textHome;
        // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        Log.i(TAG, "Informational Messages");
        Log.v(TAG, "Verbose Messages");
        Log.d(TAG, "Debug Messages");
        Log.w(TAG, "Warning Messages");
        Log.e(TAG, "Error Messages");

        final Button button = root.findViewById(R.id.about_button);
        final View someText1 = root.findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (someText1.getVisibility() == View.VISIBLE) {
                    someText1.setVisibility(View.INVISIBLE);
                } else {
                    someText1.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button button1 = root.findViewById(R.id.game_button);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), GameActivity.class);
                startActivity(i);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
}