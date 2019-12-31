package com.wiser.acoordinatorlayout;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewCeilingActivity extends Activity {

    private RecyclerView rlv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceiling_recycler);

        rlv = findViewById(R.id.rlv);

        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setAdapter(new RecyclerAdapter(this,30));
    }
}
