package com.wiser.acoordinatorlayout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

public class ToolBarCeilingActivity extends Activity {

    private AppBarLayout appBarLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceiling_toolbar);

        appBarLayout = findViewById(R.id.app_bar);

        toolbar = findViewById(R.id.toolbar);

        final int alphaMaxOffset = dpToPx(150);
        toolbar.getBackground().setAlpha(0);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                // 设置 toolbar 背景
                if (verticalOffset > -alphaMaxOffset) {
                    toolbar.getBackground().setAlpha(255 * -verticalOffset / alphaMaxOffset);
                } else {
                    toolbar.getBackground().setAlpha(255);
                }
            }
        });
    }

    /**
     * dp转换为px
     */
    public static int dpToPx(float dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density + 0.5f);
    }
}
