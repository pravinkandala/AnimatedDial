package edu.niu.cs.z1761257.animateddial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Pravin on 4/19/16.
 */
public class DialView extends View {

    private float angle;
    private Paint paint;


    public DialView(Context context) {
        super(context);

        //set the angle
        angle = 0;

        //create the paint object
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        //set the background color for canvas

        canvas.drawRGB(255,255,0);

        //calculate the canvas width and height
        int canvasWidth = getMeasuredWidth(),
                canvasHeight = getMeasuredHeight(),
                radius;

        //check landscape
        if(canvasWidth>canvasHeight)
            radius = canvasHeight/2;
        else //portrait
            radius = canvasWidth/2;

        //update angle
        angle += 1;
        if(angle>360){
            angle = 0;
        }

        //draw the line

        float radians = (float)(angle*(180/Math.PI)),
                startX = canvasWidth/2,
                startY = canvasHeight/2,
                stopX = (float)(startX+radius * Math.sin(radians)),
                stopY = (float)(startY-radius * Math.cos(radians));

        paint.setColor(Color.rgb(132,175,166));
        canvas.drawLine(startX,startY,stopX,stopY,paint);

    }//end of onDraw

    public void update(){
        invalidate();
    }//end of update

}//end of DialView class
