package dev.lyze.flexbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.enums.YogaFlexDirection;
import io.github.orioncraftmc.meditate.enums.YogaWrap;

public class FlexBoxTest extends ApplicationAdapter {
	private Stage stage;
	private FlexBox flexBox;
	
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new FlexBoxTest(), config);
	}
	
	@Override
	public void create() {
		VisUI.load();

		stage = new Stage(new ScreenViewport());
		stage.setDebugAll(true);

		Table table = new Table();
		table.setFillParent(true);
		table.add(new VisLabel("TABLE"));

		flexBox = new FlexBox();
		flexBox.getRoot().setFlexDirection(YogaFlexDirection.ROW);
		flexBox.getRoot().setWrap(YogaWrap.WRAP);

		for (int i = 0; i < 3; i++) {
			YogaNode node = flexBox.add(new VisLabel("Item " + i));
			node.setWidth(400);
		}

		table.add(flexBox);
		stage.addActor(table);
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