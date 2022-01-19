package com.example.shootinggame;

import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Bullet extends BaseObject {
    private static final float MOVE_WEIGHT =3.0f;
    private static final  float SIZE = 15f;
    private final Paint paint =new Paint();

    public final float alignX;

    Bullet(Rect rect,float alignXValue){
        yposition =rect.centerY();
        xposition =rect.centerX();
        alignX = alignXValue;

        paint.setColor(Color.RED);
    }
    @Override
    public boolean isHit(BaseObject object){
        if(object.getType()!= Type.Missile){
            return false;
        }

        return (calcDistance(this,object) < SIZE);
    }
    @Override
    public Type getType(){
        return Type.Bullet;
    }
    @Override
    public void move(){
        yposition -=1 *MOVE_WEIGHT;
        xposition +=alignX*MOVE_WEIGHT;
    }
    @Override
    public void draw(Canvas canvas){
        if(state != STATE_NORMAL){
            return;
        }
        canvas.drawCircle(xposition,yposition,SIZE,paint);
    }
}
