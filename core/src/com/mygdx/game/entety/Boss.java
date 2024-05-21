package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

import java.util.Random;

public class Boss extends Entety{
    private Texture imgBoss;
    private Point2D positionBoss;
    private Point2D directionBoss;
    private float healthBoss;
    private float speedBoss=25;
    public static Circle boundsBoss;
    private Circle bbBoss;
    private int speed=5;
    private float radius=128;
    private int DelayB=10;
    private long StartTimerB=0;
    public Boss(Point2D positionBoss){
        imgBoss=new Texture("Enemy4.png");
        this.positionBoss=positionBoss;
        directionBoss=new Point2D(0,0);
        boundsBoss=new Circle(positionBoss,radius);
        bbBoss=new Circle(positionBoss,radius*8);
        healthBoss=500;

    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgBoss,positionBoss.getX()-radius,positionBoss.getY()-radius,radius*2,radius*2);
    }

    @Override
    public void update() {
        if(positionBoss.getX()+radius> Main.Widith)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getX()-radius<0)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getY()+radius> Main.Height)directionBoss.setY(-directionBoss.getY());
        if(positionBoss.getY()-radius<0)directionBoss.setY(-directionBoss.getY());
        if(bbBoss.isConteins(Player.position)){
            float xs=positionBoss.getX()-Player.position.getX();
            float ys=positionBoss.getY()-Player.position.getY();
            float ds= (float) Math.sqrt(xs*xs+ys*ys);
            directionBoss.setPoint(-(xs / ds), -(ys / ds));
            positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
            //поведение нпс
        }else {
            positionBoss.add(directionBoss.getX()*speed,directionBoss.getY()*speed);
        }
        boundsBoss.poso.setPoint(positionBoss);
        bbBoss.poso.setPoint(positionBoss);
    }
    public void setHealthBoss(){
        healthBoss-=2;
    }
    public Circle getBoundsBoss(){
        return boundsBoss;
    }

    public float getHealthBoss() {
        return healthBoss;
    }

    public void DieBoss(){
        imgBoss.dispose();
    }
}
