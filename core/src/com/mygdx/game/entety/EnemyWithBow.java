package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class EnemyWithBow extends Entety{
    private Texture imgEnemyBow;
    private Point2D positionEnemyBow;
    private Point2D directionEnemyBow;
    private float healthEnemyBow;
    private float speedEnemyBow;
    public Circle boundsEnemyBow;
    private Circle bbEnemy;
    private float radius=64;
    private int rang;
    public EnemyWithBow(Point2D pos,int Rang){
        switch (Rang){
            case 1:
                imgEnemyBow=new Texture("Enemy1.jpg");
                boundsEnemyBow=new Circle(pos,radius);
                healthEnemyBow=50;
                speedEnemyBow=5;
                bbEnemy=new Circle(pos,radius*10);
                rang=Rang;
                break;
            case 2:
                imgEnemyBow=new Texture("Enemy2.png");
                healthEnemyBow=20;
                speedEnemyBow=6;
                boundsEnemyBow=new Circle(pos,radius);
                bbEnemy=new Circle(pos,radius*10);
                rang=Rang;
                break;
            case 3:
                imgEnemyBow=new Texture("Enemy3.png");
                healthEnemyBow=80;
                speedEnemyBow=3;
                boundsEnemyBow=new Circle(pos,radius);
                bbEnemy=new Circle(pos,radius*15);
                rang=Rang;
                break;
            case 4:
                imgEnemyBow=new Texture("Enemy4.png");
                healthEnemyBow=60;
                speedEnemyBow=7;
                boundsEnemyBow=new Circle(pos,radius);
                bbEnemy=new Circle(pos,radius*9);
                rang=Rang;
                break;
        }
        positionEnemyBow=pos;
        boundsEnemyBow=new Circle(positionEnemyBow,radius);
        directionEnemyBow=new Point2D(0,0);
        directionEnemyBow.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        directionEnemyBow.setY((float) Math.cos(Math.toRadians(Math.random()*360)));

    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgEnemyBow,positionEnemyBow.getX()-radius,positionEnemyBow.getY()-radius,radius*2,radius*2);
    }

    @Override
    public void update() {
        if(positionEnemyBow.getX()+radius> Main.Widith)directionEnemyBow.setX(-directionEnemyBow.getX());
        if(positionEnemyBow.getX()-radius<0)directionEnemyBow.setX(-directionEnemyBow.getX());
        if(positionEnemyBow.getY()+radius> Main.Height)directionEnemyBow.setY(-directionEnemyBow.getY());
        if(positionEnemyBow.getY()-radius<0)directionEnemyBow.setY(-directionEnemyBow.getY());
        if(bbEnemy.isConteins(Player.position)){
            float xs=positionEnemyBow.getX()-Player.position.getX();
            float ys=positionEnemyBow.getY()-Player.position.getY();
            float ds= (float) Math.sqrt(xs*xs+ys*ys);
            directionEnemyBow.setPoint(-(xs / ds), -(ys / ds));

            //поведение нпс
        }
        positionEnemyBow.add(directionEnemyBow.getX()*speedEnemyBow,directionEnemyBow.getY()*speedEnemyBow);
        boundsEnemyBow.poso.setPoint(positionEnemyBow);
        bbEnemy.poso.setPoint(positionEnemyBow);
    }
    public void attack(int Rang){
        switch (Rang){
            case 1:
                float xs=positionEnemyBow.getX()-Player.position.getX();
                float ys=positionEnemyBow.getY()-Player.position.getY();
                float ds= (float) Math.sqrt(xs*xs+ys*ys);
                directionEnemyBow.setPoint(-(xs / ds), -(ys / ds));
                break;
            case 2:
                directionEnemyBow.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
                directionEnemyBow.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
                positionEnemyBow.add(directionEnemyBow.getX()*speedEnemyBow,directionEnemyBow.getY()*speedEnemyBow);
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    public void hit(){
        healthEnemyBow-=3;
    }
    public float getHealthEnemyBow(){return healthEnemyBow;}


}
