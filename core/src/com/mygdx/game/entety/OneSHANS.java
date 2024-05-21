package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class OneSHANS extends Entety{
    public static Point2D positionOne;
    float sideL=128;
    private Texture imgOne;
    private Circle boundsOne;

    public OneSHANS(float x,float y){
        this.positionOne=new Point2D(x,y);
        imgOne=new Texture("live.png");
        boundsOne=new Circle(positionOne,sideL);
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgOne,positionOne.getX()-sideL,positionOne.getY()-sideL,sideL,sideL);
    }

    @Override
    public void update() {

    }
    public Circle getBoundsOne(){return boundsOne;}
}
