package com.mmlab.southschool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2017/1/5.
 */

public class computer_class extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return new computer_class.AnimView(getActivity());

    }

    private DisplayMetrics metrics = new DisplayMetrics();
    private Paint paint;
    private Canvas canvas;
    private Bitmap map,player,back;
    private SurfaceHolder sfh;
    private int[][] test_map0 = {
            { 0, 1, 1, 323, 324, 325, 326, 1, 1, 1, 0 },
            { 0, 9, 9, 331, 332, 333, 334, 9, 9, 9, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 245, 246, 37, 37, 37, 245, 246, 37, 0},
            { 0, 37, 253, 254, 37, 37, 37, 253, 254, 37, 0},
            { 0, 37, 37, 262, 37, 37, 37, 37, 262, 37, 0},
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 245, 246, 37, 37, 37, 245, 246, 37, 0 },
            { 0, 37, 253, 254, 37, 37, 37, 253, 254, 37, 0  },
            { 0, 37, 37, 262, 37, 37, 37, 37, 262, 37, 0},
            { 0, 392, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            { 0, 400, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_map1 = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_back0 = {
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };


    private int mapx = 0;// map地图的唯一坐标
    private int mapy = 0;
    private float titleW;// 每一个方块的宽度和高度
    private float titleH;
    private int n=0;// 每一行的方块数量



    private int tx=0;
    private int ty=0;


    private int px;
    private int py;


    float upX,upY,downX,downY;

    DisplayMetrics displaymetrics = new DisplayMetrics();
    int height;
    int width;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GlobalVariable globalVariable = (GlobalVariable)getActivity().getApplicationContext();
        px = globalVariable.inital_x;
        py = globalVariable.inital_y;
        test_map1[px][py] = globalVariable.inital_z;

        Button doBtn = (Button) getActivity().findViewById(R.id.doBtn);
        doBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                GlobalVariable globalVariable = (GlobalVariable)getActivity().getApplicationContext();
                if (test_map1[12][2]==9 || test_map1[11][2]==9) {
                    FragmentManager fm;
                    fm = getActivity().getSupportFragmentManager();
                    f5_1 f = new f5_1();
                    fm.beginTransaction().replace(R.id.mainfame,f).commit();

                    globalVariable.inital_x = 2;
                    globalVariable.inital_y = 8;
                    globalVariable.inital_z = 1;

                    MediaPlayer m = MediaPlayer.create(getActivity(),R.raw.dooropen);
                    m.start();
                }
                if (test_map1[5][2]==17||test_map1[6][3]==25) {
                    new AlertDialog.Builder(getActivity()).setMessage("需要帳號密碼...").show();
                }
                if (test_map1[5][7]==17||test_map1[6][8]==25) {
                    if(globalVariable.helmelt != 1) {
                        globalVariable.helmelt = 1;
                        new AlertDialog.Builder(getActivity()).setMessage("獲得識破頭盔").show();
                    }
                    else {
                        new AlertDialog.Builder(getActivity()).setMessage("這是空的").show();
                    }
                }
                if (test_map1[10][2]==17||test_map1[11][3]==25) {
                    if(globalVariable.computer_qte != 1) {
                        globalVariable.computer_qte = 1;
                        qte();
                    }
                    else {
                        new AlertDialog.Builder(getActivity()).setMessage("這是空的").show();
                    }
                }
                if (test_map1[10][7]==17||test_map1[11][8]==25) {
                    new AlertDialog.Builder(getActivity()).setMessage("....ook..ase........亂碼?").show();
                }


            }
        });
        Button toBag = (Button)getActivity().findViewById(R.id.toBag);
        toBag.setText("背包");
        toBag.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm;
                fm = getActivity().getSupportFragmentManager();
                bag f = new bag();
                fm.beginTransaction().replace(R.id.mainfame,f).addToBackStack(null).commit();

                GlobalVariable globalVariable = (GlobalVariable)getActivity().getApplicationContext();
                globalVariable.inital_x = px;
                globalVariable.inital_y = py;
                globalVariable.inital_z = test_map1[px][py];
            }
        });

    }

    public void qte() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("有個漆黑的身影出現在角落！");
        builder.setTitle("突然間");
        builder.setCancelable(false);
        builder.setPositiveButton("別理他", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                new AlertDialog.Builder(getActivity()).setMessage("你往後看了看，什麼也沒有").show();
            }
        });
        builder.setNegativeButton("往後看", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                new AlertDialog.Builder(getActivity()).setMessage("你被魔王的手下偷襲了").show();
                FragmentManager fm;
                fm = getActivity().getSupportFragmentManager();
                battle1 f = new battle1();
                fm.beginTransaction().replace(R.id.mainfame,f).addToBackStack(null).commit();

                GlobalVariable globalVariable = (GlobalVariable)getActivity().getApplicationContext();
                globalVariable.inital_x = px;
                globalVariable.inital_y = py;
                globalVariable.inital_z = test_map1[px][py];

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }


    class AnimView extends SurfaceView implements SurfaceHolder.Callback
    {
        SurfaceHolder holder;
        public AnimView(Context context)
        {
            super(context);
            sfh = this.getHolder();
            sfh.addCallback(this);
            paint = new Paint();
            paint.setAntiAlias(true);
            // 图片资源初始化
            map = BitmapFactory.decodeResource(getResources(), R.drawable.room);
            player = BitmapFactory.decodeResource(getResources(), R.drawable.player);
            back = BitmapFactory.decodeResource(getResources(), R.drawable.room);

            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            height = displaymetrics.heightPixels;
            width = displaymetrics.widthPixels;
            float density = displaymetrics.density;

            titleW = (32*density);
            titleH = (32*density);


            n = map.getWidth() / (int)titleW;

        }

        /* 在surface的大小發生改變時啟動 */
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
        {
        }

        /* 在建立時啟動，一般在這裡呼叫繪圖的執行緒 */
        public void surfaceCreated(SurfaceHolder holder)
        {
			/* 啟動執行緒繪圖 */
            myDraw();

        }

        /* 結束時啟動，一般在這裡將繪圖的執行緒停止、釋放 */
        public void surfaceDestroyed(SurfaceHolder holder)
        {
        }

        private void myDraw() {
            // TODO Auto-generated method stub
            canvas=sfh.lockCanvas();//实例化
            //中间代码绘图过程
            //i控制行输出,j控制列输出

            for(int i=0;i<test_map0.length;i++){
                for(int j=0;j<test_map0[i].length;j++){
                    canvas.save();
                    //绘制一个矩形可视区域
                    canvas.clipRect(j*titleW+mapx, i*titleH+mapy, (j+1)*titleW+mapx, (i+1)*titleH+mapy);
                    //在每个矩形区域内，将原地图的指定的模块绘制在矩形区域内
                    canvas.drawBitmap(back, j*titleW+mapx-((test_back0[i][j]-1)%n)*titleW, i*titleH+mapy-((test_back0[i][j]-1)/n)*titleH, paint);
                    canvas.drawBitmap(map, j*titleW+mapx-((test_map0[i][j]-1)%n)*titleW, i*titleH+mapy-((test_map0[i][j]-1)/n)*titleH, paint);
                    canvas.drawBitmap(player, j*titleW+mapx-((test_map1[i][j]-1)%n)*titleW, i*titleH+mapy-((test_map1[i][j]-1)/n)*titleH, paint);
                    canvas.restore();
                }
            }
            sfh.unlockCanvasAndPost(canvas);//解锁画布
        }
        private void go() {

            test_map1[tx][ty] = 0;
            myDraw();
        }

        public boolean onTouchEvent(MotionEvent event){

            float X = event.getX();
            float Y = event.getY();

            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                }
                break;

                case MotionEvent.ACTION_MOVE:
                {
                }

                break;
                case MotionEvent.ACTION_UP:
                {
                    upX = event.getX();
                    upY = event.getY();
                    float x=Math.abs(upX-downX);
                    float y=Math.abs(upY-downY);
                    double z=Math.sqrt(x*x+y*y);
                    int jiaodu=Math.round((float)(Math.asin(y/z)/Math.PI*180));//角度

                    if (upY < downY && jiaodu>45) {//上 遊戲裡相反
                        if(test_map0[px-1][py] == 37 ) {
                            tx = px;
                            ty = py;
                            px --;
                        }
                        test_map1[px][py] = 25;
                        go();
                    }else if(upY > downY && jiaodu>45) {//下 遊戲裡相反
                        if(test_map0[px+1][py] == 37 ) {
                            tx = px;
                            ty = py;
                            px ++;
                        }
                        test_map1[px][py] = 1;
                        go();
                    }else if(upX < downX && jiaodu<=45) {//左 遊戲裡相反
                        if(test_map0[px][py-1] == 37) {
                            tx = px;
                            ty = py;
                            py--;
                        }
                        test_map1[px][py] = 9;
                        go();
                    }else if(upX > downX && jiaodu<=45) {//右 遊戲裡相反
                        if(test_map0[px][py+1] == 37) {
                            tx = px;
                            ty = py;
                            py++;
                        }
                        test_map1[px][py] = 17;
                        go();
                    }
                }
                break;
            }
            return true;
        }


    }


}
