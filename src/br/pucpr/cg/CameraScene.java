package br.pucpr.cg;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import br.pucpr.mage.*;
import org.joml.Matrix4f;

public class CameraScene implements Scene {
    private Keyboard keys = Keyboard.getInstance();

    private Shader shader;
    private Mesh mesh;
    private float angle;

    @Override
    public void init() {
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        shader = Shader.loadProgram("basic");
        mesh = new MeshFactory(shader).createCube();
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
        mesh.draw(shader);
    }

    @Override
    public void deinit() {
    }

    public static void main(String[] args) {
        new Window(new CameraScene(), "Rotating cube", 800, 600).show();
    }
}
