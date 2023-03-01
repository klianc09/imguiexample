# ImGui + LibGDX example project
An example project showing Java code on how to use [SpaiR/imgui-java](https://github.com/SpaiR/imgui-java) together with [libgdx](https://github.com/libgdx/libgdx).

The [the official libgdx wiki](https://libgdx.com/wiki/graphics/2d/imgui) points to multiple ImGui java implementations, but at the time of writing (March 2023) none of the examples seem to be self-contained, nor up-to-date.

[SpaiR/imgui-java](https://github.com/SpaiR/imgui-java) simply was chosen, because it was the only one I could get to work.

The largest caveat this setup currently has is, that it requires the 'core' project to have a dependency on the lwjgl3 backend to get the GLFW window handle.
If you have subprojects other than desktop (e.g. html), this might be a problem, otherwise this is probably fine.

## Versions Used

* **LibGDX** 1.11.0
* **imgui-java** 1.86.8
* **gradle** 7.6

The base libGDX project itself was generated with [gdx-liftoff](https://github.com/tommyettinger/gdx-liftoff).
Which might have a slightly different structure in terms of gradle files than the default libgdx-setup.

## Relevant Files

* **gradle.properties** - Defines the imgui version used
* **build.gradle** - Defines the imgui dependencies for the core and lwjgl3 subproject
* **core/build.gradle** - Defines the lwjgl3 dependency needed in core (unfortunately)
* **core/src/main/java/at/example/Main** - Shows how to setup ImGui (contained in the **MyImgui** inner class)
