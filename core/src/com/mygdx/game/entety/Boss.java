package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

import java.util.Random;

public class Boss extends Entety{
    private Texture boss;
    private Point2D positionBoss;
    private Point2D directionBoss;
    private float healthBoss;
    private float speedBoss;
    public static Circle boundsBoss;
    private Circle bbBoss;
    private float radius=64;
    public Boss(Point2D positionBoss){
        boss=new Texture("");
        this.positionBoss=positionBoss;
        boundsBoss=new Circle(positionBoss,radius);
        bbBoss=new Circle(positionBoss,radius*8);
        healthBoss=250;
        speedBoss=5;
    }
    //любая атака идёт какое-то время
    public void attackBoss1(float speedBoss){
        directionBoss.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionBoss.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
        positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
    }
    public void attackBoss2(float speedBoss){
        float xs=positionBoss.getX()-Player.position.getX();
        float ys=positionBoss.getY()-Player.position.getY();
        float ds= (float) Math.sqrt(xs*xs+ys*ys);
        /**
         if (ds<64){
         directionBoss.setPoint(0,0);
         }else if(ds>64) {
         directionBoss.setPoint(-(xs / ds), -(ys / ds));
         }**/
        directionBoss.setPoint(-(xs / ds), -(ys / ds));
    }
    public void attackBoss3(float speedBoss){
        directionBoss.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionBoss.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
        positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
    }
    public void attackBoss4(float speedBoss){
        directionBoss.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionBoss.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
        positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
    }
    public void attackBoss5(float speedBoss){
        directionBoss.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionBoss.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
        positionBoss.add(directionBoss.getX()*speedBoss,directionBoss.getY()*speedBoss);
    }
    public void randomAttackBoss(){
        Random random = new Random();
        int a = random.nextInt(1,5);
        switch (a){
            case 1:
                attackBoss1(25);
                break;
            case 2:
                attackBoss2(5);
                break;
            case 3:
                attackBoss3(15);
                break;
            case 4:
                attackBoss4(10);
                break;
            default:
                attackBoss5(20);
                break;
        }
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(boss,positionBoss.getX()-radius,positionBoss.getY()-radius,radius*2,radius*2);
    }

    @Override
    public void update() {
        if(positionBoss.getX()+radius> Main.Widith)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getX()-radius<0)directionBoss.setX(-directionBoss.getX());
        if(positionBoss.getY()+radius> Main.Height)directionBoss.setY(-directionBoss.getY());
        if(positionBoss.getY()-radius<0)directionBoss.setY(-directionBoss.getY());
        randomAttackBoss();
    }
}
