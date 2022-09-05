package com.example.newproject.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.newproject.SharedHelper;
import com.example.newproject.databinding.FragmentUsersetBinding;
import com.example.newproject.ui.MyActivity;

public class UsersetFragment extends Fragment {
    private FragmentUsersetBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        DashboardViewModel dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentUsersetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        myOperation();
//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void myOperation() {

        // 设置按钮监听
        binding.llSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "设置", Toast.LENGTH_SHORT).show();
            }
        });

        // 关于按钮监听
        binding.llAbouting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "关于", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btSettingLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyActivity.class);
                intent.putExtra("logout", "logout");
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}