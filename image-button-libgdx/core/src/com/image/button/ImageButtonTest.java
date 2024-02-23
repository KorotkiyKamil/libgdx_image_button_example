package com.image.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ImageButtonTest extends Game {

    Stage stage;
    ImageButtonStyle style;
    ImageButton imageButton;
    Skin skin;
    TextureAtlas buttonAtlas;

	@Override
    public void create() {    
		
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.atlas"));
        skin.addRegions(buttonAtlas);

        style           = new ImageButton.ImageButtonStyle();
        style.up        = skin.getDrawable("button-up");
        style.down      = skin.getDrawable("button-down");
        style.imageUp   = skin.getDrawable("Wilber");
        style.imageDown = skin.getDrawable("pepper");
        
        imageButton     = new ImageButton(style);
       
        imageButton.setPosition(256, 192);
        stage.addActor(imageButton);
    }

    @Override
    public void render() {  
    	Gdx.gl.glClearColor(255, 255, 255, 255);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
   @Override
    public void resize(int width, int height) {
    	stage.getViewport().update(width, height, true);
    }
    @Override
    public void dispose() {
    	stage.dispose();
    	buttonAtlas.dispose();
    }
}
