package com.laifeng.sopcastsdk.video.effect;

import android.content.Context;
import android.opengl.GLES20;

import com.laifeng.sopcastsdk.video.GLSLFileUtils;

/**
 * Created by fenrir-cd on 2018/1/11.
 */

public class BilateralFilter extends Effect{

    private static final String BILATERAL_FILTER_VERTEX = "Bilateral/vertexShader.glsl";
    private static final String BILATERAL_FILTER_FRAGMENT = "Bilateral/fragmentShader.glsl";

    public BilateralFilter(Context context) {
        super();
        String vertexShader = GLSLFileUtils.getFileContextFromAssets(context, BILATERAL_FILTER_VERTEX);
        String fragmentShader = GLSLFileUtils.getFileContextFromAssets(context, BILATERAL_FILTER_FRAGMENT);
        super.setShader(vertexShader, fragmentShader);
    }

    @Override
    protected void loadOtherParams() {
        int singleStepOffsetHandle = GLES20.glGetUniformLocation(getProgram(), "singleStepOffset");
        int distanceNormalizationFactorHandle = GLES20.glGetUniformLocation(getProgram(), "distanceNormalizationFactor");

        setFloat(distanceNormalizationFactorHandle, 15.0f);
        setFloatVec2(singleStepOffsetHandle, new float[] {-15.0f / mWidth,-15.0f / mHeight});
    }
}
