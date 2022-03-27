package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import sun.jvm.hotspot.utilities.HeapGXLWriter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;
    private ArrayList<Block> blocks = new ArrayList<>();

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(250, 250, 10, 3, 5);
        paddle = new Paddle(100, 10, 100, 10);
        int blockWidth = 63;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        paddle.update();
        paddle.draw(shape);

        for (Block block : blocks) {

            block.draw(shape);


        }

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            ball.checkCollision(b);
            if (b.getStatus()) {
                blocks.remove(b);
                i--;
            }
        }


        ball.checkCollision(paddle);
        ball.update();
        ball.draw(shape);

        shape.end();
    }

    @Override
    public void dispose() {
    }

}
