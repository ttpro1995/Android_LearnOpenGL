package com.apcs.learnopengl.Renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by Thien on 1/24/2016.
 */

public class AirHockeyRenderer {
    private static final  int BYTES_PER_FLOAT = 4;// 1 float = 4 bytes
    private final FloatBuffer vertexData;

    public AirHockeyRenderer() {
        /*
        float[] tableVertices = {
                0f, 0f,
                0f,14f,
                9f,14f,
                9f, 0f
        };
        */

        //Open gl can only draw points, lines, triangles
        float[] tableVerticesWithTriangles = {
                //triangle1
                0f, 0f,
                9f, 14f,
                0f, 14f,

                // Triagle2
                0f, 0f,
                9f, 0f,
                9f, 14f,

                // Line1
                0f, 7f,
                9f, 7f,

                // Mallets
                4.5f, 2f,
                4.5f, 12f
        };

        vertexData = ByteBuffer
                .allocateDirect(tableVerticesWithTriangles.length * BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();

        vertexData.put(tableVerticesWithTriangles);
    }
}
