package com.mygdx.game.settings;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Main;
import com.mygdx.game.entety.Bullet;

public class BulletGen {
    boolean isFire;
    public void update(JoostikPlayer joostikPlayer){
        isFire=(joostikPlayer.getDir().getX()==0 && joostikPlayer.getDir().getY()==0)?false:true;
        if(isFire){
            Main.bullets.add(new Bullet(Main.player.position,Main.joostikBullet.getDir()));

        }
    }
}
