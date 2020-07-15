package com.example.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @date：2020/7/15
 * @describe：
 * @author：FanYaJun
 */
@SuppressLint("AppCompatCustomView")
public class CanersView extends TextView {
    public CanersView(Context context) {
        super(context);
    }
    public CanersView(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
    }
    public CanersView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写onDraw方法 表示画布 欧美人思维
     * @param canvas
     * @return
     */

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(R.color.colorAccent);
        canvas.rotate(10,getMeasuredHeight()/10,getMeasuredWidth()/10);//旋转

        super.onDraw(canvas);
    }
}
