package dev.lyze.flexbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.enums.YogaFlexDirection;
import io.github.orioncraftmc.meditate.enums.YogaWrap;

/**
 * This test demonstrates the use of FlexBox directly in a {@link Stage Stage}. This emulates the layout of the
 * <a href="https://yogalayout.com/playground/">Yoga Playground</a> Press LEFT CLICK to add a new element. Press RIGHT
 * CLICK to remove an element.
 */
public class FlexBoxNestedTest extends ApplicationAdapter {
	private Stage stage;
	private FlexBox flexBox;
	
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new FlexBoxNestedTest(), config);
	}
	
	@Override
	public void create() {
		VisUI.load();

		stage = new Stage(new ScreenViewport());
		stage.setDebugAll(true);

		flexBox = new FlexBox();
		flexBox.setFillParent(true);
		flexBox.getRoot().setFlexDirection(YogaFlexDirection.ROW)
				.setWrap(YogaWrap.WRAP);
		stage.addActor(flexBox);

		YogaNode parentNode = flexBox.add().setFlexDirection(YogaFlexDirection.COLUMN).setFlexGrow(1);
		VisLabel testlabel = new VisLabel("test1");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		testlabel = new VisLabel("test2");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		parentNode = flexBox.add().setFlexDirection(YogaFlexDirection.COLUMN).setFlexGrow(1);
		testlabel = new VisLabel("test3");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		testlabel = new VisLabel("test4");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		parentNode = flexBox.add().setFlexDirection(YogaFlexDirection.COLUMN).setFlexGrow(1);
		testlabel = new VisLabel("test4");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		parentNode = flexBox.addAsChild(parentNode).setFlexDirection(YogaFlexDirection.ROW);
		testlabel = new VisLabel("test5");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		testlabel = new VisLabel("test6");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.BLACK);

		stage.act();
		stage.draw();
		
		if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
			VisLabel label = new VisLabel(Integer.toString(flexBox.getChildren().size + 1));
			label.setAlignment(Align.center);
			YogaNode node = flexBox.add(label);
			node.setWidth(100);
			node.setHeight(100);
		}
		
		if (Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
			if (flexBox.getChildren().size > 0) {
				flexBox.remove(flexBox.getRoot().getChildAt(flexBox.getChildren().size - 1));
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		flexBox.layout();
	}
}