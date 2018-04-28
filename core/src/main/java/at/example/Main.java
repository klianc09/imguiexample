package at.example;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.graphics.GL20;
import imgui.Context;
import imgui.ContextKt;
import imgui.ImGui;
import imgui.impl.LwjglGL3;
import uno.glfw.GlfwWindow;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    //ImGui Singleton Instances
    private LwjglGL3 lwjglGL3 = LwjglGL3.INSTANCE;
    private ImGui imgui = ImGui.INSTANCE;

    private Context ctx;

    @Override
    public void create() {
        ctx = new Context();

        Lwjgl3Graphics lwjgl3Graphics = (Lwjgl3Graphics) Gdx.graphics;
        long windowHandle = lwjgl3Graphics.getWindow().getWindowHandle();
        lwjglGL3.init(new GlfwWindow(windowHandle), false);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        lwjglGL3.newFrame();

        boolean[] showDemo = {true};
        imgui.showDemoWindow(showDemo);

        imgui.render();

        if (imgui.getDrawData() != null) {
            lwjglGL3.renderDrawData(imgui.getDrawData());
        }
    }

    @Override
    public void dispose() {
        lwjglGL3.shutdown();
        ContextKt.destroy(ctx);
    }
}