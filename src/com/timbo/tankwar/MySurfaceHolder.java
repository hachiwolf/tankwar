package com.timbo.tankwar;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MySurfaceHolder extends Thread{
	private boolean isplaying ;
	private MySurfaceView surfaceView ;
	private SurfaceHolder surfaceholder ;
	public MySurfaceHolder(MySurfaceView mySurfaceView) {
		this.surfaceView = mySurfaceView ;
		surfaceholder = mySurfaceView.getHolder() ;
	}

	public boolean isIsplaying() {
		return isplaying;
	}


	public void setIsplaying(boolean isplaying) {
		this.isplaying = isplaying;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(isplaying) {
			Canvas canvas = surfaceholder.lockCanvas() ;
			surfaceView.draw(canvas) ;
			surfaceholder.unlockCanvasAndPost(canvas) ;
			try {
				Thread.sleep(250) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
