package com.example.shootinggame;

import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Missile extends BaseObject{
    private static final  float MOVE_WEIGHT = 4.5f;
    private static final  float SIZE = 10f;
    private final Paint paint =new Paint();

    public final float alignX;

    Missile(int fromX, float alignX){
        yposition =0;
        xposition =fromX;
        this.alignX = alignX;
        paint.setColor(Color.BLUE);
    }
    @Override
    public void move(){
        yposition +=1 *MOVE_WEIGHT;
        xposition +=alignX*MOVE_WEIGHT;
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
        return Type.Missile;
    }

    @Override
    public void draw(Canvas canvas){
        if(state != STATE_NORMAL){
            return;
        }
        canvas.drawCircle(xposition,yposition,SIZE,paint);
    }
}

