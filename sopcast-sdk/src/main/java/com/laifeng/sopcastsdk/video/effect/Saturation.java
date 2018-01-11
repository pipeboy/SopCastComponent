package com.laifeng.sopcastsdk.video.effect;

import android.content.Context;
import android.opengl.GLES20;

import com.laifeng.sopcastsdk.video.GLSLFileUtils;

/**
 * Created by fenrir-cd on 2018/1/11.
 */

public class Saturation extends Effect {

    private static final String SATURATION_EFFECT_VERTEX = "saturation/vertexShader.glsl";
    private static final String SATURATION_EFFECT_FRAGMENT = "saturation/fragmentShader.glsl";

    public Saturation(Context context) {
        super();
        String vertexShader = GLSLFileUtils.getFileContextFromAssets(context, SATURATION_EFFECT_VERTEX);
        String fragmentShader = GLSLFileUtils.getFileContextFromAssets(context, SATURATION_EFFECT_FRAGMENT);
        super.setShader(vertexShader, fragmentShader);
    }

    @Override
    protected void loadOtherParams() {
        int mSaturationLocation = GLES20.glGetUniformLocation(getProgram(), "saturation");
        setFloat(mSaturationLocation, 2.0f);
    }
}
