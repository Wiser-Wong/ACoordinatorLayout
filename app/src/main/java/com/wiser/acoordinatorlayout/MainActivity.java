package com.wiser.acoordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void skipNestedScroll(View view) {
        skipActivity(0);
    }

    public void skipRecycler(View view) {
        skipActivity(1);
    }

    public void skipViewPager(View view) {
        skipActivity(2);
    }

    private void skipActivity(int type) {
        Intent intent = new Intent();
        switch (type) {
            case 0:
                intent.setClass(this, NestedScrollCeilingActivity.class);
                break;
            case 1:
                intent.setClass(this, RecyclerViewCeilingActivity.class);
                break;
            case 2:
                intent.setClass(this, ViewPagerCeilingActivity.class);
                break;
        }
        startActivity(intent);
    }
}
