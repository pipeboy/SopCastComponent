package com.laifeng.sopcastsdk.video.effect;

import android.content.Context;

/**
 * Created by fenrir-cd on 2018/1/11.
 */

public class BilateralFilter extends Effect{

    private static final String BILATERAL_FILTER_VERTEX = "BilateralFilter/vertexShader.glsl";
    private static final String BILATERAL_FILTER_FRAGMENT = "BilateralFilter/fragmentShader.glsl";

    public BilateralFilter(Context context) {
        super();
    }
}
