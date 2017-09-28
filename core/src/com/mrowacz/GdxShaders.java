package com.mrowacz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class GdxShaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	String vertexShader;
	String fragmentShader;
	ShaderProgram shaderProgram;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");


		vertexShader = Gdx.files.internal("vertex.glsl").readString();
		fragmentShader = Gdx.files.internal("fragment.glsl").readString();
		shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setShader(shaderProgram);
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
