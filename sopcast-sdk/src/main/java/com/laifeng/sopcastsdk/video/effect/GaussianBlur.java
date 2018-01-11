package com.laifeng.sopcastsdk.video.effect;

import android.content.Context;
import android.opengl.GLES20;

import com.laifeng.sopcastsdk.video.GLSLFileUtils;
/**
 * Created by fenrir-cd on 2018/1/11.
 */

public class GaussianBlur extends Effect{

    private static final String GAUSSIAN_BLUR_VERTEX = "GaussianBlurFilter/vertexShader.glsl";
    private static final String GAUSSIAN_BLUR_FRAGMENT = "GaussianBlurFilter/fragmentShader.glsl";

    public GaussianBlur(Context context) {
        super();
        String vertexShader = GLSLFileUtils.getFileContextFromAssets(context, GAUSSIAN_BLUR_VERTEX);
        String fragmentShader = GLSLFileUtils.getFileContextFromAssets(context, GAUSSIAN_BLUR_FRAGMENT);
        super.setShader(vertexShader,fragmentShader);
    }

    @Override
    protected void loadOtherParams() {
        initTexelOffsets();
    }

    private void initTexelOffsets() {
        // TODO: 2018/1/9 initTexelOffsets
        int muTexelWOffsetHandle = GLES20.glGetUniformLocation(getProgram(), "texelWidthOffset");
        int muTexelHOffsetHandle = GLES20.glGetUniformLocation(getProgram(), "texelHeightOffset");
        setFloat(muTexelWOffsetHandle, 10.0f/mWidth);
        setFloat(muTexelHOffsetHandle, 0);

//        muTexelWOffsetHandle = GLES20.glGetUniformLocation(mProgram, "texelWidthOffset");
//        muTexelHOffsetHandle = GLES20.glGetUniformLocation(mProgram, "texelHeightOffset");
//        setFloat(muTexelWOffsetHandle, 0);
//        setFloat(muTexelHOffsetHandle, 1f/mHeight);
    }
}
