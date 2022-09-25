# gdx-FlexBox

## gdx-FlexBox is a fork of [Meditate Layout](https://github.com/OrionCraftMC/meditate-layout) to make it compatible with libGDX.

Meditate Layout is a full java port of [Yoga Layout by Facebook](https://github.com/facebook/yoga) which implements Flexbox.
---

[![License](https://img.shields.io/github/license/lyze237/gdx-FlexBox)](https://github.com/lyze237/gdx-FlexBox/blob/main/LICENSE)
[![Jitpack](https://jitpack.io/v/lyze237/gdx-FlexBox.svg)](https://jitpack.io/#lyze237/gdx-FlexBox)

This fork downgrades the project to Java 8 and supports GWT for compatibility with libGDX. It adds the FlexBox class to 
implement Yoga Layout in Scene2D UI's. 

### Yoga Layout Simple Example

Check out https://yogalayout.com/playground for a playground and https://yogalayout.com/docs (Or any other flexbox tutorial) for docs.

```java
public class Example {
    public static void main(String[] args) {
        YogaConfig config = YogaConfigFactory.create();
        config.setUseWebDefaults(true);

        YogaNode root = YogaNodeFactory.create(config);
        root.setAlignItems(YogaAlign.FLEX_START);

        for (int i = 0; i < 10; i++) {
            YogaNode child = YogaNodeFactory.create(config);
            child.setWidth(100);
            child.setHeight(100);
            root.addChildAt(child, i);
        }

        root.getChildAt(0).setFlexGrow(1);
        
        root.calculateLayout(1920, 1080);
        
        // root.getChildAt(0).getLayoutX();
        // root.getChildAt(0).getLayoutY();
        // root.getChildAt(0).getLayoutWidth();
        // root.getChildAt(0).getLayoutHeight();
    }
}
```

### libGDX Scene2D Example

```java
@Override
public void create() {
    ...
    stage = new Stage(new ScreenViewport());
    stage.setDebugAll(true);

    flexBox = new FlexBox();
    flexBox.setFillParent(true);
    flexBox.getRoot().setFlexDirection(YogaFlexDirection.ROW)
        .setWrap(YogaWrap.WRAP);
    stage.addActor(flexBox);
        
    Label label = new Label("Item 1", skin);
    label.setAlignment(Align.center);
    flexBox.add(label).setSize(100);
        
    label = new Label("Item 2", skin);
    label.setAlignment(Align.center);
    flexBox.add(label)
        .setWidth(100)
        .setHeight(100);
}
```

### Usage

1. Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2. Add the dependency to the core modules dependencies
```gradle
dependencies {
        api "com.github.lyze237:gdx-FlexBox:$version"
}
```
3. Add the dependency to the html modules dependencies
```gradle
dependencies {
        api "com.github.lyze237:gdx-FlexBox:$version:sources"
}
```
4. Change the `$version` string to the latest version from jitpack in both files.
5. Include the following in your applications `.gwt.xml` file (Normally `GdxDefinition.gwt.xml`):
```xml
<inherits name="dev.lyze.flexbox"/>
```
