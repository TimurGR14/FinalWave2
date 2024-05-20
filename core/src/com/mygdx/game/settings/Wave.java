package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;
import com.mygdx.game.entety.EnemyWithBow;

import java.util.Random;

public class Wave {
    private int Delay,WaveNumber, minEnemy;
   private long StartTimer;
   private String k= "WAVE - ";
   BitmapFont font;

   public Wave(int Delay,int WaveNumber,int minEnemy){
       FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
       FreeTypeFontGenerator.FreeTypeFontParameter parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
       parameter.size= (int) (Main.Widith/20);
       parameter.color=new Color(1,0,1,1);
       font=generator.generateFont(parameter);
       this.Delay=Delay;
       this.WaveNumber=WaveNumber;
       this.minEnemy=minEnemy;


   }
   public void update(){
       if(Main.enemyWithBows.size==0 && StartTimer==0)StartTimer=System.currentTimeMillis();
       int Seconds=0;
       if(StartTimer>0)Seconds= (int) ((System.currentTimeMillis()-StartTimer)/1000);
       if(Seconds>=Delay){setWave();
           WaveNumber+=1;
           StartTimer=0;
           Seconds=0;
       }
   }
   public void setWave(){
       Random random=new Random();
       float x;
       float y;
       int Enem=minEnemy+WaveNumber;
       int maxRank=1;
       if(WaveNumber>3){maxRank=2;}
       if(WaveNumber>7){maxRank=3;}
       if(WaveNumber>10){maxRank=4;}

       for (int i=0;i<Enem;i++){
           x = MathUtils.random(128,Main.Widith-128);
           y=MathUtils.random(128,Main.Height-128);
           Main.enemyWithBows.add(new EnemyWithBow(new Point2D(x,y), (int) (Math.random()*maxRank+1)));
       }

   }
   public void draw(SpriteBatch batch){

       GlyphLayout glyphLayout=new GlyphLayout();
       glyphLayout.setText(font,k+WaveNumber);

       font.draw(batch,glyphLayout,Main.Widith/2-glyphLayout.width/2,Main.Height/2);

   }
   public boolean isDraw(){
       return StartTimer>0;
   }
   public void setWaveNumber(){
       WaveNumber=1;
   }

    public int getWaveNumber() {
        return WaveNumber;
    }
}
