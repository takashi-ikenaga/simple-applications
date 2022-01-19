package com.example.shootinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class Robo extends BaseObject {

    private final Paint paint = new Paint();

    public final Bitmap bitmap;
    public final Rect rect;

    public Robo(Bitmap bitmap, int width, int height){
        this.bitmap = bitmap;

        int left= (width -bitmap.getWidth()) /2;
        int top = height -bitmap.getHeight();
        int right = left + bitmap.getWidth();
        int bottom = top+ bitmap.getHeight();
        rect = new Rect(left,top,right,bottom);

        xposition =rect.centerX();
        yposition =rect.centerY();
    }
    @Override
    public boolean isHit(BaseObject object){
        if(object.getType()!= Type.Missile){
            return false;
        }
        int x =(Math.round(object.xposition)*2)/3;
        int y =(Math.round(object.yposition)*2)/3;
        return rect.contains(x,y);
    }
    @Override
    public Type getType(){
        return Type.Robo;
    }
    @Override
    public void draw(Canvas canvas){
        if(state != STATE_NORMAL){
            return;
        }
        canvas.drawBitmap(bitmap,rect.left,rect.top,paint);
    }
    @Override
    public void move(){
    }
}
