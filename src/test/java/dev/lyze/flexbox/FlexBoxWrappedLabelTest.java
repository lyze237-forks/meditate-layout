package dev.lyze.flexbox;

import com.badlogic.gdx.ApplicationAdapter;
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
public class FlexBoxWrappedLabelTest extends ApplicationAdapter {
	private Stage stage;
	private FlexBox flexBox;
	private final String LONG_TEXT = "Hello. This is a demonstration of long text that should automatically be wrapped" +
			" to the next line. It is absurd to expect otherwise. And yet there is always a chance for this opposing" +
			"viewpoint. Even as infinitesimal as it may be, it must be tested. Thus, we shall begin...";
	
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new FlexBoxWrappedLabelTest(), config);
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
		
		testlabel = new VisLabel(LONG_TEXT);
		testlabel.setWrap(true);
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
		
		testlabel = new VisLabel("test3");
		testlabel.setAlignment(Align.center);
		flexBox.addAsChild(parentNode, testlabel);
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
		flexBox.layout();
	}
}