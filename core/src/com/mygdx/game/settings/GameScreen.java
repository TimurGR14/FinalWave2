package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;
import com.mygdx.game.entety.Lives;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;

public class GameScreen implements Screen {
    private Main main;
    private int DelayL=15,DelayPlayer=2;
    private long StartTimerL,StartTimerPlayer;
    public Lives lives;


    public GameScreen(Main main){
        this.main=main;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }
            //

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }
            //

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }

        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GameUpdate();
        main.batch.begin();
        GameRender(Main.batch);
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
    public void GameUpdate(){
        Main.player.setDirection(Main.joostikPlayer.getDir());
        Main.player.update();
        Main.bulletGen.update(Main.joostikBullet);
        for(int j=0;j<Main.bullets.size;j++){Main.bullets.get(j).update();if (Main.bullets.get(j).isOut)Main.bullets.removeIndex(j--);
        }
        for(int j=0;j<Main.livesArray.size;j++){Main.livesArray.get(j).update();}
        for(int k=0;k<Main.enemyWithBows.size;k++){
            Main.enemyWithBows.get(k).update();
            if (Main.enemyWithBows.get(k).getHealthEnemyBow()<1){
                Main.enemyWithBows.removeIndex(k--);
                Main.player.setScore();
            }
        }
        collision();
        upHealTimer();
        colH();
        if(Main.wave.getWaveNumber()<=21){
            Main.wave.update();
        }else if(Main.wave.getWaveNumber()>21 && Main.enemyWithBows.size==0){
            main.setScreen(new ScreenFinal(main,Main.player.getScore()));
        }
        if(Main.player.getHealth()<1)main.setScreen(new DeadSceen(main,Main.player.getScore()));
    }
    public void GameRender(SpriteBatch batch){
        Main.player.draw(batch);
        Main.joostikPlayer.draw(batch);
        Main.joostikBullet.draw(batch);
        for(int j=0;j<Main.bullets.size;j++){Main.bullets.get(j).draw(batch);
        }
        for(int l=0;l<Main.enemyWithBows.size;l++){Main.enemyWithBows.get(l).draw(batch);
        }

        for(int j=0;j<Main.livesArray.size;j++){Main.livesArray.get(j).draw(batch);}
        if(Main.wave.isDraw())Main.wave.draw(batch);

        Main.gameHud.draw(batch);
        Main.gameScore.draw(batch);
    }
    @Override
    public void dispose() {
        main.batch.dispose();
    }

    public void multitouch(float x,float y,boolean isDownTouch,int pointer){
        for(int i=0;i<5;i++){
            Main.joostikPlayer.update(x,y,isDownTouch,pointer);
            Main.joostikBullet.update(x,y,isDownTouch,pointer);
        }
    }
    public void collision(){
        for(int i=0;i<Main.bullets.size;i++){
            for (int j=0;j<Main.enemyWithBows.size;j++){
                if(Main.bullets.get(i).boundsBullet.Overlaps(Main.enemyWithBows.get(j).boundsEnemyBow)){
                    Main.enemyWithBows.get(j).hit();
                    Main.bullets.removeIndex(i--);
                break;}
            }
        }
        for (int l=0;l<Main.enemyWithBows.size;l++){
            if(Main.player.getBounds().Overlaps(Main.enemyWithBows.get(l).boundsEnemyBow)){
                Main.player.HitP();
            }
        }
    }

    public void upHealTimer(){
        Random random=new Random();
        if(StartTimerL==0)StartTimerL=System.currentTimeMillis();
        int Seconds=0;
        if(StartTimerL>0)Seconds= (int) ((System.currentTimeMillis()-StartTimerL)/1000);
        if(Seconds>=DelayL){
            float x=MathUtils.random(128,Main.Widith-128);
            float y=MathUtils.random(128,Main.Height-128);
            Main.livesArray.add(new Lives(x,y));
            StartTimerL=0;
            Seconds=0;
        }
    }
    public  void  colH(){
        for (int i=0;i<Main.livesArray.size;i++){
            if(Main.livesArray.get(i).getBoundsLive().Overlaps(Main.player.getBounds())){
                Main.player.Heal();
                Main.livesArray.removeIndex(i);
                break;
            }
        }
    }
}
