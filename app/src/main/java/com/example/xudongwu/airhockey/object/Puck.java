package com.example.xudongwu.airhockey.object;

import com.example.xudongwu.airhockey.Geometry;
import com.example.xudongwu.airhockey.ObjectBuilder;
import com.example.xudongwu.airhockey.data.VertexArray;
import com.example.xudongwu.airhockey.program.ColorShaderProgram;

import java.util.List;

public class Puck {
    private static final int POSITION_COMPONENT_COUNT = 3;

    public final float radius, height;

    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public Puck(float radius, float height, int numPointsAroundPuck) {
        ObjectBuilder.GeneratedData generatedData = ObjectBuilder.createPuck(
                new Geometry.Cylinder(new Geometry.Point(0f, 0f, 0f), radius, height), numPointsAroundPuck);
        this.radius = radius;
        this.height = height;

        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram program) {
        vertexArray.setVertexAttribPointer(
                0, program.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, 0);
    }

    public void draw() {
        for (ObjectBuilder.DrawCommand c : drawList) {
            c.draw();
        }
    }
}
