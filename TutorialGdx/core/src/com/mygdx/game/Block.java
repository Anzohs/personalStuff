package com.mygdx.game;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean status;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public boolean getStatus(){
        return status;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
