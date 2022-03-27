package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private int x;
    private int y;
    private int xSpeed;
    private int width;
    private int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        xSpeed = 10;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (x <= 0) x = 0;
            x -= xSpeed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (x + width > Gdx.graphics.getWidth()) x = Gdx.graphics.getWidth() - width;
            x += xSpeed;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.WHITE);
        shape.rect(x, y, width, height);
    }

}
