package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x;
    private int y;
    private int size;
    private int ySpeed;
    private int xSpeed;
    private Color color;
    private Paddle paddle;
    private Block block;


    public Ball(int x, int y, int size, int ySpeed, int xSpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
        color = Color.WHITE;

    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) xSpeed = -xSpeed;
        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) ySpeed = -ySpeed;
        if (checkCollision(paddle)) ySpeed = -ySpeed;
        checkCollision(block);
    }


    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public boolean checkCollision(Paddle paddle) {
        this.paddle = paddle;
        if (collidesWith(paddle)) return true;
        return false;
    }

    public void checkCollision(Block block) {
        this.block = block;

        if(collidesWith(block)){

            ySpeed = - ySpeed;
            block.setStatus(true);
        }
    }

    private boolean collidesWith(Block block) {

        if ((x + size >= block.getX() && x - size <= block.getX() + block.getWidth()) &&
                (y - size <= block.getHeight() + block.getY() && y + size >= block.getY()))
            return true;

        return false;
    }

    private boolean collidesWith(Paddle paddle) {
        if ((x + size >= paddle.getX() && x - size <= paddle.getX() + paddle.getWidth()) &&
                (y - size <= paddle.getHeight() + paddle.getY() && y + size >= paddle.getY()))
            return true;

        return false;
    }
}
