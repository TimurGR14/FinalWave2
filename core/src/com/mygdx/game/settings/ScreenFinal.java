package com.mygdx.game.settings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

public class ScreenFinal implements Screen {
    Main main;
    int scoreEnd;
    BitmapFont fontEnd;
    GlyphLayout gll,gll2;
    public ScreenFinal(Main main,int x){
        this.main=main;
        scoreEnd=x;
        FreeTypeFontGenerator freeEnd=new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter perEnd=new FreeTypeFontGenerator.FreeTypeFontParameter();
        perEnd.size= (int) (Main.Widith/17);
        perEnd.color=new Color(Color.WHITE);
        fontEnd=freeEnd.generateFont(perEnd);
        gll=new GlyphLayout();
        gll2=new GlyphLayout();
        gll.setText(fontEnd,"Thank you Player");
        gll2.setText(fontEnd,"you score - "+scoreEnd);
        String k;
        if(scoreEnd>Main.youRecord){
            k=scoreEnd+"";
            Main.Write(k);
            Main.youRecord=scoreEnd;
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //update();
        main.batch.begin();
        fontEnd.draw(main.batch,gll,Main.Widith/2-gll.width/2,Main.Height*2/3- gll.height/2);
        fontEnd.draw(main.batch,gll2,Main.Widith/2-gll2.width/2,Main.Height/3- gll2.height/2);
        main.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
