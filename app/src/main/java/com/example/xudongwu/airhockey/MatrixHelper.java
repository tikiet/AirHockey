package com.example.xudongwu.airhockey;

import java.lang.Math;

/**
 * Created by xudongwu on 10/12/15.
 */
public class MatrixHelper {
    public static void perspectiveM(float[] m, float yFovInDegress, float aspect, float n, float f) {
        final float angleInRadians = (float) (yFovInDegress * Math.PI / 180.0);
        final float a = (float) (1.0 / Math.tan(angleInRadians / 2.0));

        m[0] = a / aspect;
        m[1] = 0;
        m[2] = 0;
        m[3] = 0;

        m[4] = 0;
        m[5] = a;
        m[6] = 0;
        m[7] = 0;

        m[8] = 0;
        m[9] = 0;
        m[10] = -((f + n) / (f - n));
        m[11] = -1f;

        m[12] = 0;
        m[13] = 0;
        m[14] = -((2f * f * n) / (f - n));
        m[15] = 0f;
    }
}
