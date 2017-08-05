package br.pucpr.cg;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.joml.Matrix4f;

import br.pucpr.mage.Keyboard;
import br.pucpr.mage.Mesh;
import br.pucpr.mage.Scene;
import br.pucpr.mage.Window;

public class CameraScene implements Scene {
    private Keyboard keys = Keyboard.getInstance();
    
    private Mesh mesh;
    private float angle;

    @Override
    public void init() {
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        mesh = MeshFactory.createCube();
    }

    @Override
    public void update(float secs) {
        if (keys.isPressed(GLFW_KEY_ESCAPE)) {
            glfwSetWindowShouldClose(glfwGetCurrentContext(), true);
            return;
        }

        angle += Math.toRadians(10) * secs;
    }

    @Override
    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        mesh.setUniform("uWorld", new Matrix4f().rotateX(0.2f).rotateY(angle));
        mesh.draw();
    }

    @Override
    public void deinit() {
    }

    public static void main(String[] args) {
        new Window(new CameraScene(), "Rotating cube", 800, 600).show();
    }
}
