# Meditate Layout

Meditate Layout is a full Java port of [Yoga Layout by Facebook](https://github.com/facebook/yoga)
---

[![License](https://img.shields.io/github/license/lyze237-forks/meditate-layout)](https://github.com/lyze237-forks/meditate-layout/blob/main/LICENSE)
[![Jitpack](https://jitpack.io/v/lyze237-forks/meditate-layout.svg)](https://jitpack.io/#lyze237-forks/meditate-layout)

This fork downgrades the project to Java 8 and supports GWT.

### Simple Example

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
2. Add the dependency 
````gradle
dependencies {
        implementation 'com.github.lyze237-forks:meditate-layout:$version'
}
````
3. Change the `$version` string to the latest version from jitpack.