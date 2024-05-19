package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

public class GameHud{
    BitmapFont font1;
    public GameHud(){
        FreeTypeFontGenerator gintama=new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter par=new FreeTypeFontGenerator.FreeTypeFontParameter();
        par.size= (int) (Main.Widith/25);
        par.color=new Color(Color.WHITE);
        font1=gintama.generateFont(par);

    }
    public void draw(SpriteBatch batch){
        GlyphLayout dl=new GlyphLayout();
        dl.setText(font1,"healf - "+Main.player.getHealth());
        font1.draw(batch,dl,0,Main.Height-dl.height);
    }
}
