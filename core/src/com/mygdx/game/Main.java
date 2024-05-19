package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entety.Bullet;
import com.mygdx.game.entety.EnemyWithBow;
import com.mygdx.game.entety.Lives;
import com.mygdx.game.entety.Player;
import com.mygdx.game.settings.BulletGen;
import com.mygdx.game.settings.GameScreen;
import com.mygdx.game.settings.JoostikPlayer;
import com.mygdx.game.settings.Point2D;
import com.mygdx.game.settings.Wave;

public class Main extends Game {
	public static SpriteBatch batch;
	private Point2D posPlayer=new Point2D(300,200);
	public static Player player;
	public static float Widith,Height;
	public static Texture circle,stick;
	public static JoostikPlayer joostikPlayer,joostikBullet;
	public static Array<Bullet> bullets;
	public static Bullet bullet;
	public static Array<EnemyWithBow>enemyWithBows;
	public static BulletGen bulletGen;
	public static Wave wave;
	public static Array<Lives>livesArray;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player=new Player(posPlayer);
		Widith= Gdx.graphics.getWidth();
		Height=Gdx.graphics.getHeight();
		circle=new Texture("circle.jpg");
		stick=new Texture("stick.jpg");
		joostikPlayer=new JoostikPlayer(circle,stick,new Point2D(Widith*4/5,Height/3),Height/4);
		setScreen(new GameScreen(this));
		joostikBullet=new JoostikPlayer(circle,stick,new Point2D(Widith/5,Height/3),Height/5);
		bulletGen=new BulletGen();
		livesArray=new Array<Lives>();
		bullets=new Array<Bullet>();
		enemyWithBows=new Array<EnemyWithBow>();
		wave=new Wave(4,1,2);
	}
}
