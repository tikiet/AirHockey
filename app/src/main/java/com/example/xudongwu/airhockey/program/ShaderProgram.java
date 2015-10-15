package com.example.xudongwu.airhockey.program;

import android.content.Context;
import android.opengl.GLES20;

import com.example.xudongwu.airhockey.ShaderHelper;
import com.example.xudongwu.airhockey.TextResReader;
import com.example.xudongwu.airhockey.constants.Constants;

/**
 * Created by xudongwu on 10/12/15.
 */
public class ShaderProgram {
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";

    protected static final String U_COLOR = "u_Color";
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResId, int fragShaderResid) {
        program = ShaderHelper.buildProgram(
                TextResReader.readTextFileFromRes(context, vertexShaderResId),
                TextResReader.readTextFileFromRes(context, fragShaderResid));
    }

    public void useProgram() {
        GLES20.glUseProgram(program);
    }
}
