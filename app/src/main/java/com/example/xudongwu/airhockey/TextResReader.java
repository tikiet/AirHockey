package com.example.xudongwu.airhockey;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by xudongwu on 10/10/15.
 */
public class TextResReader {
    public static String readTextFileFromRes(Context context, int res) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = context.getResources().openRawResource(res);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                sb.append(nextLine);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
