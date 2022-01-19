package com.example.shootinggame;

import android.graphics.Canvas;

public abstract class BaseObject {
    static final int STATE_NORMAL =-1;
    static final int STATE_DESTROYED =0;

    int state =STATE_NORMAL;

    enum Type{
        Robo,
        Bullet,
        Missile,
    }
    public  abstract Type getType();

    float xposition;
    float yposition;

    public abstract void draw(Canvas canvas);

    public boolean isAvailable(int width, int height){
        if (yposition < 0 || xposition <0 || yposition >height || xposition >width){
            return false;
        }
        if(state == STATE_DESTROYED){
            return false;
        }
        return true;
    }
    public abstract void move();

    public abstract boolean isHit(BaseObject object);

    public void hit(){
        state =STATE_DESTROYED;
    }

    static double calcDistance(BaseObject obj1,BaseObject obj2){
        float distX = obj1.xposition - obj2.xposition;
        float distY = obj1.yposition - obj2.yposition;
        return Math.sqrt(Math.pow(distX,2) + Math.pow(distY,2));
    }
}
