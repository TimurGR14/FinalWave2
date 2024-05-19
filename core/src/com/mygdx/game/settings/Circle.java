package com.mygdx.game.settings;

public class Circle {
    float Ro;
    public Point2D poso;
    public Circle(Point2D pos,float R){
        this.poso=new Point2D(pos);
        this.Ro=R;
    }
    public boolean isConteins(Point2D point){
        float dx=poso.getX()- point.getX();
        float dy= poso.getY()- point.getY();
        return dx*dx+dy*dy<=Ro*Ro;
    }
    public boolean Overlaps(Circle c){
        float dx=poso.getX()-c.poso.getX();
        float dy=poso.getY()-c.poso.getY();
        float dist=dx*dx+dy*dy;
        float sumR=c.Ro+Ro;
        return dist<sumR*sumR;
    }
    
}
