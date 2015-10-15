package com.example.xudongwu.airhockey;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

/**
 * Created by xudongwu on 10/10/15.
 */
public class ShaderHelper {
    public static int compileVertextShader(String shaderCode) {
        return compileShader(GLES20.GL_VERTEX_SHADER, shaderCode);
    }

    public static int compileFragmentShader(String shaderCode) {
        return compileShader(GLES20.GL_FRAGMENT_SHADER, shaderCode);
    }

    private static int compileShader(int type, String shaderCode) {
        final int shaderObjectId = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shaderObjectId, shaderCode);
        GLES20.glCompileShader(shaderObjectId);

        final int[] compileStatus = new int[1];
        GLES20.glGetShaderiv(shaderObjectId, GLES20.GL_COMPILE_STATUS, compileStatus, 0);

        Log.d("WXD", GLES20.glGetShaderInfoLog(shaderObjectId));

        return shaderObjectId;
    }

    public static int linkProgram(int vertextShaderId, int fragmentShaderId) {
        final int programObjectId = GLES20.glCreateProgram();
        GLES20.glAttachShader(programObjectId, vertextShaderId);
        GLES20.glAttachShader(programObjectId, fragmentShaderId);

        GLES20.glLinkProgram(programObjectId);

        final int[] linkStatus = new int[1];
        GLES20.glGetProgramiv(programObjectId, GLES20.GL_LINK_STATUS, linkStatus, 0);

        Log.d("WXD", "link status:" + GLES20.glGetProgramInfoLog(programObjectId));

        return programObjectId;
    }

    public static boolean validateProgram(int programObjectId) {
        GLES20.glValidateProgram(programObjectId);

        final int[] validateStatus = new int[1];
        GLES20.glGetProgramiv(programObjectId, GLES20.GL_VALIDATE_STATUS, validateStatus, 0);
        Log.d("WXD", "validate status:" + GLES20.glGetProgramInfoLog(programObjectId));

        return validateStatus[0] != 0;
    }

    public static int buildProgram(String vertexShaderSource, String fragShaderSource) {
        int program;

        int vertexShader = compileVertextShader(vertexShaderSource);
        int fragShader = compileFragmentShader(fragShaderSource);

        program = linkProgram(vertexShader, fragShader);

        return program;
    }
}
