package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

public class GameScore {
    BitmapFont font1;
    public GameScore(){
        FreeTypeFontGenerator ginsama=new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter paar=new FreeTypeFontGenerator.FreeTypeFontParameter();
        paar.size= (int) (Main.Widith/25);
        paar.color=new Color(Color.GRAY);
        font1=ginsama.generateFont(paar);

    }
    public void draw(SpriteBatch batch){
        GlyphLayout dl=new GlyphLayout();
        dl.setText(font1,"score - "+Main.player.getScore());
        font1.draw(batch,dl,Main.Widith-dl.width,Main.Height-dl.height);
    }
}
