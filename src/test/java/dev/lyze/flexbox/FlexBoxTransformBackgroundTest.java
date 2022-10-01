package dev.lyze.flexbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import io.github.orioncraftmc.meditate.enums.YogaFlexDirection;
import io.github.orioncraftmc.meditate.enums.YogaWrap;

/**
 * This test demonstrates the use of FlexBox directly in a {@link Stage Stage}. This emulates the layout of the
 * <a href="https://yogalayout.com/playground/">Yoga Playground</a> Press LEFT CLICK to add a new element. Press RIGHT
 * CLICK to remove an element.
 */
public class FlexBoxTransformBackgroundTest extends ApplicationAdapter {
	private Stage stage;
	private FlexBox rotatingFlexBox, flexBox;
	private static final float DEGREES_PER_SECOND = 45f;
	
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new FlexBoxTransformBackgroundTest(), config);
	}
	
	@Override
	public void create() {
		VisUI.load();
		
		NinePatch ninePatch = new NinePatch(new NinePatch(new Texture(Gdx.files.internal("background.png")), 5, 5, 5, 5));
		ninePatch.setPadding(5, 5, 5, 5);
		NinePatchDrawable rootBgDrawable = new NinePatchDrawable(ninePatch);
		
		ninePatch = new NinePatch(new NinePatch(new Texture(Gdx.files.internal("child.png")), 5, 5, 5, 5));
		ninePatch.setPadding(5, 5, 5, 5);
		NinePatchDrawable childBgDrawable = new NinePatchDrawable(ninePatch);

		stage = new Stage(new ScreenViewport());
		stage.setDebugAll(true);

		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		table.defaults().space(100);
		rotatingFlexBox = new FlexBox();
		rotatingFlexBox.getRoot()
				.setFlexDirection(YogaFlexDirection.ROW)
				.setWrap(YogaWrap.WRAP)
				.setBackground(rootBgDrawable);
		table.add(rotatingFlexBox).size(150);
		
		rotatingFlexBox.setTransform(true);
		table.layout();
		rotatingFlexBox.setOrigin(Align.center);
		rotatingFlexBox.addAction(Actions.forever(Actions.rotateBy(DEGREES_PER_SECOND, 1f)));
		
		VisLabel testlabel = new VisLabel("test1");
		testlabel.setAlignment(Align.center);
		rotatingFlexBox.add(testlabel).setBackground(childBgDrawable);
		
		testlabel = new VisLabel("test2");
		testlabel.setAlignment(Align.center);
		rotatingFlexBox.add(testlabel).setBackground(childBgDrawable);
		
		testlabel = new VisLabel("test3");
		testlabel.setAlignment(Align.center);
		rotatingFlexBox.add(testlabel).setBackground(childBgDrawable);
		
		flexBox = new FlexBox();
		flexBox.getRoot()
				.setFlexDirection(YogaFlexDirection.ROW)
				.setWrap(YogaWrap.WRAP)
				.setBackground(rootBgDrawable);
		table.add(flexBox).size(150);
		
		testlabel = new VisLabel("test4");
		testlabel.setAlignment(Align.right);
		flexBox.add(testlabel).setBackground(childBgDrawable);
		
		testlabel = new VisLabel("test5");
		testlabel.setAlignment(Align.left);
		flexBox.add(testlabel).setBackground(childBgDrawable);
		
		testlabel = new VisLabel("test6");
		testlabel.setAlignment(Align.top);
		flexBox.add(testlabel).setBackground(childBgDrawable);
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.BLACK);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		rotatingFlexBox.layout();
	}
}