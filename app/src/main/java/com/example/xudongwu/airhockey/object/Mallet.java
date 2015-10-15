package com.example.xudongwu.airhockey.object;

import android.opengl.GLES20;

import com.example.xudongwu.airhockey.Geometry;
import com.example.xudongwu.airhockey.ObjectBuilder;
import com.example.xudongwu.airhockey.data.VertexArray;
import com.example.xudongwu.airhockey.program.ColorShaderProgram;

import java.util.List;

public class Mallet {
    private static final int POSITION_COMPONENT_COUNT = 3;

    public final float radius;
    public final float height;

    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public Mallet(float radius, float height, int numPointsAroundMallet) {
        ObjectBuilder.GeneratedData generatedData = ObjectBuilder.createMallet(
                new Geometry.Point(0, 0, 0), radius, height, numPointsAroundMallet);
        this.radius = radius;
        this.height = height;

        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram) {
        vertexArray.setVertexAttribPointer(
                0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                0);
    }

    public void draw() {
        for (ObjectBuilder.DrawCommand c : drawList) {
            c.draw();
        }
    }
}
