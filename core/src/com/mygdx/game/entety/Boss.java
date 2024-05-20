package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

import java.util.Random;

public class Boss extends Entety{
    private Texture boss;
    private Point2D positionBoss;
    private Point2D directionBoss;
    private float healthBoss;
    private float speedBoss=25;
    public static Circle boundsBoss;
    private Circle bbBoss;
    private float radius=128;
    private int DelayB=10;
    private long StartTimerB=0;
    public Boss(Point2D positionBoss){
        boss=new Texture("Enemy4.png");
        this.positionBoss=positionBoss;
        directionBoss=new Point2D(0,0);
        boundsBoss=new Circle(positionBoss,radius);
        bbBoss=new Circle(positionBoss,radius*8);
        healthBoss=500;

    }
    public void attackBoss1(){
        directionBoss.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionBoss.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
    }
    public void attackBoss2(){
        float xs=positionBoss.getX()-Player.position.getX();
        float ys=positionBoss.getY()-Player.position.getY();
        float ds= (float) Math.sqrt(xs*xs+ys*ys);
        directionBoss.setPoint(-(xs / ds), -(ys / ds));

    }

    public int randomAttackBoss(){
        Random random = new Random();
        int x= MathUtils.random(1,3);
        return x;
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(boss,positionBoss.getX()-radius,positionBoss.getY()-radius,radius*2,radius*2);
    }

    @Override
    public void update() {
        int x=1;
        if(positionBoss.getX()+radius> Main.Widith)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getX()-radius<0)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getY()+radius> Main.Height)directionBoss.setY(-directionBoss.getY());
        if(positionBoss.getY()-radius<0)directionBoss.setY(-directionBoss.getY());
        /**
        if(Main.wave.getWaveNumber()==1 && StartTimerB==0)StartTimerB=System.currentTimeMillis();
        int Seconds=0;
        if(StartTimerB>0)Seconds= (int) ((System.currentTimeMillis()-StartTimerB)/1000);
        if(Seconds>=DelayB){
            x=randomAttackBoss();
            StartTimerB=0;
            Seconds=0;
        }
        if(x==1 && StartTimerB==0){
            StartTimerB=System.currentTimeMillis();
            attackBoss1();
            if(StartTimerB>0)Seconds= (int) ((System.currentTimeMillis()-StartTimerB)/1000);
            if(Seconds>=DelayB){
                x=randomAttackBoss();
                StartTimerB=0;
                Seconds=0;
            }
        }
        while (x==2){
            attackBoss2();
        }
        positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
        boundsBoss.poso.setPoint(positionBoss);
        bbBoss.poso.setPoint(positionBoss);**/

    }
}
