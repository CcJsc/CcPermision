package com.example.ccmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cclibrary.permission.CcPermissions;
import com.example.cclibrary.permission.Consumer;
import com.example.cclibrary.permission.PermissionName;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CcPermissions.with(this)
                .permission(PermissionName.CAMERA)
                .request(new Consumer() {
                    @Override
                    public void accept(List<String> granted, boolean isAll) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}