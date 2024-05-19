package com.mygdx.game.settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JoostikPlayer {
    Texture CircleImg,StickImg;
    Circle CircleBounds,StickBounds;
    float Rcircle,Rstick;
    private int pointer=-1;
    Point2D direction;
    public JoostikPlayer(Texture cimg,Texture simg,Point2D point,float sizee){
        CircleImg=cimg;
        StickImg=simg;
        Rcircle=sizee/2;
        Rstick=Rcircle/2;
        CircleBounds=new Circle(point,Rcircle);
        StickBounds=new Circle(point,Rstick);
        direction=new Point2D(0,0);
    }
    public void draw(SpriteBatch batch){
        batch.draw(CircleImg,CircleBounds.poso.getX()-Rcircle,CircleBounds.poso.getY()-Rcircle,Rcircle*2,Rcircle*2);
        batch.draw(StickImg,StickBounds.poso.getX()-Rstick,StickBounds.poso.getY()-Rstick,Rstick*2,Rstick*2);

    }
    public void update(float x,float y,boolean isDownTouch,int pointer){
        Point2D touch=new Point2D(x,y);
        if(CircleBounds.isConteins(touch)&& isDownTouch && this.pointer==-1)this.pointer=pointer ;
        if(CircleBounds.Overlaps(StickBounds)&& isDownTouch && pointer==this.pointer)atControl(new Point2D(x,y));
        if((!isDownTouch && pointer==this.pointer)||(isDownTouch && pointer==this.pointer && !CircleBounds.isConteins(touch)))returnStick();

    }

    private void returnStick() {
        StickBounds.poso.setPoint(StickBounds.poso);
        direction.setPoint(0,0);
        pointer=-1;
    }

    public void atControl(Point2D point){
        StickBounds.poso.setPoint(point);
        float dx=CircleBounds.poso.getX()-StickBounds.poso.getX();
        float dy=CircleBounds.poso.getY()-StickBounds.poso.getY();
        float dist= (float) Math.sqrt(dx*dx+dy*dy);
        direction.setPoint(-(dx/dist),-(dy/dist));
    }
    public Point2D getDir(){
        return direction;
    }
}
