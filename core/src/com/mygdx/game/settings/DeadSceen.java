package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Main;

public class DeadSceen implements Screen {
    Main main;
    int scoreEnd;
    BitmapFont fontEnd;
    GlyphLayout gll,gll2;
    GlyphLayout glq,glq2;

    public DeadSceen(Main main,int scoreEnd){
        this.main=main;
        this.scoreEnd=scoreEnd;


        FreeTypeFontGenerator freeEnd=new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter perEnd=new FreeTypeFontGenerator.FreeTypeFontParameter();
        perEnd.size= (int) (Main.Widith/17);
        perEnd.color=new Color(Color.WHITE);
        fontEnd=freeEnd.generateFont(perEnd);

        gll=new GlyphLayout();
        glq=new GlyphLayout();
        glq.setText(fontEnd,"GAME OVER");
        gll.setText(fontEnd,"you score : "+scoreEnd);
        gll2=new GlyphLayout();
        String info,k;
        if(scoreEnd>Main.youRecord){
            info="NEW RECORD";
            k=scoreEnd+"";
            Main.Write(k);
            Main.youRecord=scoreEnd;
        }else{
            info="Record : "+Main.youRecord;
        }
        gll2.setText(fontEnd,info);
        glq2=new GlyphLayout();
        glq2.setText(fontEnd,"new game?");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();
        main.batch.begin();
        fontEnd.draw(main.batch,gll,Main.Widith/2-gll.width/2,Main.Height*5/7- gll.height/2);
        fontEnd.draw(main.batch,glq,Main.Widith/2-glq.width/2,Main.Height*6/7- glq.height/2);
        fontEnd.draw(main.batch,gll2,Main.Widith/2-gll2.width/2,Main.Height*4/7- gll2.height/2);
        fontEnd.draw(main.batch,glq2,Main.Widith/2-glq2.width/2,Main.Height*3/7- glq2.height/2);
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
    public void update(){
        if(Gdx.input.isTouched()){
            main.setScreen(new GameScreen(main));
            Main.player.setHealf();
            Main.player.setRecord();
            Main.wave.setWaveNumber();
            Main.player.setStartPosition();
            Main.enemyWithBows.clear();
        }
    }
}
