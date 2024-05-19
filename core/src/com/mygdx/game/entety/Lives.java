package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class Lives extends Entety{
    public static Point2D positionLive;
    float sideL=128;
    float heal;
    private Texture imgLive;
    private Circle boundsLive;
    private int Delay=20;
    private long StartTimer;
    public Lives(float x,float y){
        this.positionLive=new Point2D(x,y);
        heal=20;
        imgLive=new Texture("Healy.png");
        boundsLive=new Circle(positionLive,sideL);
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgLive,positionLive.getX()-sideL,positionLive.getY()-sideL,sideL,sideL);
    }

    @Override
    public void update() {
    }

    public Circle getBoundsLive(){return boundsLive;}
}
