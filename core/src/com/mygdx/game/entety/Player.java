package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class Player extends Entety {

    private int score=0;
    public static Point2D position;
    float speed=12;
    public static float side=128;
    float health;
    private Texture imgPlayer;
    private Circle bounds;
    public static Point2D direction;
    private boolean ghost;
    private long StartTimerP=0;
    private int live=0;

    public Player(Point2D position){
        imgPlayer=new Texture("giga.jpg");
        this.position=position;
        health=10;
        direction=new Point2D(0,0);
        bounds=new Circle(position,side);
    }
    @Override
    public void draw(SpriteBatch batch) {
        //if(ghost)batch.setColor(Color.RED);
        batch.draw(imgPlayer,position.getX()-side,position.getY()-side,side,side);

    }

    @Override
    public void update() {
        if(position.getX()+side> Main.Widith)position.setX(Main.Widith-side);
        if(position.getX()-side<0)position.setX(side);
        if(position.getY()+side> Main.Height)position.setY(Main.Height-side);
        if(position.getY()-side<0)position.setY(side);
        if(StartTimerP==0 && ghost)StartTimerP=System.currentTimeMillis();
        int seconds=0;
        if(StartTimerP>0)seconds=(int)(System.currentTimeMillis()-StartTimerP)/1000;
        if(seconds>1){ghost=false;StartTimerP=0;seconds=0;}
        if(health>0){
            position.add(direction.getX()*speed,direction.getY()*speed);
        }else{
            position.add(0,0);//setPoint
        }

        bounds.poso.setPoint(position);

    }
    public void setDirection(Point2D dir){
        direction=dir;
    }
     public void HitP(){
        if(ghost==false){
            ghost=true;
            health-=3;
        }


     }
     public void setScore(){
        score+=10;
     }

    public int getScore() {
        return score;
    }

    public void Heal(){
        health+=7;
     }
     public Circle getBounds(){
        return bounds;
     }

    public float getHealth() {
        return health;
    }

    public void setHealf() {
        health=10;
    }
    public void setRecord(){
        score=0;
    }
    public void setStartPosition(){
        position.setPoint(Main.Widith/2+side,Main.Height/2+side);
    }
    public  void SHAn(){
        live-=1;
    }
    public void setLive(){
        live+=1;
    }
    public int getLive(){
        return live;
    }
    public void setHealthVSBoss(){
        health-=4;
    }
}
