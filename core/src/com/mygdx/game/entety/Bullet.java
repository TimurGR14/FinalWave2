package com.mygdx.game.entety;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class Bullet extends  Entety{
    private Texture imgBullet;
    private Point2D pos;
    private Point2D dir;
    float speed=50;
    float radiusBullet=32;
    public Circle boundsBullet;
    public boolean isOut;


    public Bullet(Point2D pos,Point2D dir){
        imgBullet=new Texture("MyBullet.png");
        this.pos=new Point2D(pos);
        this.dir=new Point2D(dir);
        boundsBullet=new Circle(pos,radiusBullet);
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgBullet,pos.getX()-radiusBullet,pos.getY()-radiusBullet,radiusBullet*2,radiusBullet*2);
    }
    @Override
    public void update() {
        isOut=((pos.getX()-radiusBullet> Main.Widith)||(pos.getX()+radiusBullet<0)||(pos.getY()-radiusBullet>Main.Height)||(pos.getY()+radiusBullet<0))?true:false;
        pos.add(dir.getX()*speed,dir.getY()*speed);
        boundsBullet.poso.setPoint(pos);
    }
    public Point2D getPos() {
        return pos;
    }
}
// не массив