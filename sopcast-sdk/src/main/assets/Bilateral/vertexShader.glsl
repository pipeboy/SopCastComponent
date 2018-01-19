attribute vec4 position;
attribute vec4 inputTextureCoordinate;

const int GAUSSIAN_SAMPLES = 9;

uniform vec2 singleStepOffset;
uniform mat4 uPosMtx;
uniform mat4 uTexMtx;

varying vec2 textureCoordinate;
varying vec2 blurCoordinates[GAUSSIAN_SAMPLES];

void main() {
    gl_Position = uPosMtx * position;

    textureCoordinate = (uTexMtx * inputTextureCoordinate).xy;

    int multiplier = 0;
    vec2 blurStep;

    for(int i = 0; i < GAUSSIAN_SAMPLES; i++) {
        multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));

        blurStep = float(multiplier) * singleStepOffset;
        blurCoordinates[i] = (uTexMtx * inputTextureCoordinate).xy + blurStep;
    }
}
