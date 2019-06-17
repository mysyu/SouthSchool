package com.mmlab.southschool;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
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

public class bag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return new bag.AnimView(getActivity());

    }

    private DisplayMetrics metrics = new DisplayMetrics();
    private Paint paint;
    private Canvas canvas;
    private Bitmap map, picker, back;
    private SurfaceHolder sfh;
    private int[][] test_map0 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_map1 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_back0 = {

            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

    };


    private int mapx = 0;// map地图的唯一坐标
    private int mapy = 0;
    private float titleW;// 每一个方块的宽度和高度
    private float titleH;
    private int n = 0;// 每一行的方块数量
    private int n2 = 0;// 每一行的方块数量


    private int tx = 2;
    private int ty = 2;


    private int px = 2;
    private int py = 2;


    float upX, upY, downX, downY;

    DisplayMetrics displaymetrics = new DisplayMetrics();
    int height;
    int width;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int check_row = 1;
        GlobalVariable globalVariable = (GlobalVariable) getActivity().getApplicationContext();
        if (globalVariable.old_key == 1) {
            test_map0[tx][ty] = 181;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.wind_arrow == 1) {
            test_map0[tx][ty] = 169;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.firestone == 1) {
            test_map0[tx][ty] = 24;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.hammer == 1) {
            test_map0[tx][ty] = 187;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.inyun == 1) {
            test_map0[tx][ty] = 125;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.helmelt == 1) {
            test_map0[tx][ty] = 105;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }
        if (globalVariable.vip == 1) {
            test_map0[tx][ty] = 155;
            ty = ty + 2;
            check_row++;
            if (check_row == 5) {
                check_row = 1;
                ty = 2;
                tx++;
            }
        }


        Button doBtn = (Button) getActivity().findViewById(R.id.doBtn);
        doBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVariable globalVariable = (GlobalVariable) getActivity().getApplicationContext();
                if (test_map0[px][py] == 181) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備了鑰匙").show();
                    globalVariable.with_what = 1;
                    globalVariable.attack = 20;
                }
                if (test_map0[px][py] == 169) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備了風暴弓").show();
                    globalVariable.with_what = 2;
                    globalVariable.attack = 100;
                }
                if (test_map0[px][py] == 24) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備了火焰石").show();
                    globalVariable.with_what = 3;
                    globalVariable.attack = 25;
                }
                if (test_map0[px][py] == 187) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備了槌子").show();
                    globalVariable.with_what = 4;
                    globalVariable.attack = 75;
                }
                if (test_map0[px][py] == 125) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備了黑白戒").show();
                    globalVariable.with_what = 5;
                    globalVariable.attack = 50;
                }
                if (test_map0[px][py] == 105) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備識破頭盔").show();
                    globalVariable.with_what = 6;
                    globalVariable.attack = 20;
                }
                if (test_map0[px][py] == 155) {
                    new AlertDialog.Builder(getActivity()).setMessage("裝備vip頭盔").show();
                    globalVariable.with_what = 7;
                    globalVariable.attack = 1000;
                }

            }
        });


        Button toBag = (Button) getActivity().findViewById(R.id.toBag);
        toBag.setText("離開");
        toBag.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm;
                fm = getActivity().getSupportFragmentManager();

                if (fm.getBackStackEntryCount() == 0) {
                    getActivity().finish();
                } else {
                    fm.popBackStack();
                }
            }
        });


    }


    class AnimView extends SurfaceView implements SurfaceHolder.Callback {
        SurfaceHolder holder;

        public AnimView(Context context) {
            super(context);
            sfh = this.getHolder();
            sfh.addCallback(this);
            paint = new Paint();
            paint.setAntiAlias(true);
            // 图片资源初始化
            map = BitmapFactory.decodeResource(getResources(), R.drawable.bag);
            picker = BitmapFactory.decodeResource(getResources(), R.drawable.picker);
            back = BitmapFactory.decodeResource(getResources(), R.drawable.ui);

            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            height = displaymetrics.heightPixels;
            width = displaymetrics.widthPixels;
            float density = displaymetrics.density;

            titleW = (24 * density);
            titleH = (24 * density);


            n = map.getWidth() / (int) titleW;
            n2 = back.getWidth() / (int) titleW;
        }

        /* 在surface的大小發生改變時啟動 */
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        /* 在建立時啟動，一般在這裡呼叫繪圖的執行緒 */
        public void surfaceCreated(SurfaceHolder holder) {
            /* 啟動執行緒繪圖 */
            myDraw();

        }

        /* 結束時啟動，一般在這裡將繪圖的執行緒停止、釋放 */
        public void surfaceDestroyed(SurfaceHolder holder) {
        }

        private void myDraw() {
            // TODO Auto-generated method stub
            canvas = sfh.lockCanvas();//实例化
            //中间代码绘图过程
            //i控制行输出,j控制列输出

            for (int i = 0; i < test_map0.length; i++) {
                for (int j = 0; j < test_map0[i].length; j++) {
                    canvas.save();
                    //绘制一个矩形可视区域
                    canvas.clipRect(j * titleW + mapx, i * titleH + mapy, (j + 1) * titleW + mapx, (i + 1) * titleH + mapy);
                    //在每个矩形区域内，将原地图的指定的模块绘制在矩形区域内
                    canvas.drawBitmap(back, j * titleW + mapx - ((test_back0[i][j] - 1) % n2) * titleW, i * titleH + mapy - ((test_back0[i][j] - 1) / n2) * titleH, paint);
                    canvas.drawBitmap(picker, j * titleW + mapx - ((test_map1[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_map1[i][j] - 1) / n) * titleH, paint);
                    canvas.drawBitmap(map, j * titleW + mapx - ((test_map0[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_map0[i][j] - 1) / n) * titleH, paint);
                    canvas.restore();
                }
            }
            sfh.unlockCanvasAndPost(canvas);//解锁画布
        }


        private void go() {

            myDraw();
        }


        public boolean onTouchEvent(MotionEvent event) {

            float X = event.getX();
            float Y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                }
                break;

                case MotionEvent.ACTION_MOVE: {
                }

                break;
                case MotionEvent.ACTION_UP: {
                    upX = event.getX();
                    upY = event.getY();
                    float x = Math.abs(upX - downX);
                    float y = Math.abs(upY - downY);
                    double z = Math.sqrt(x * x + y * y);
                    int jiaodu = Math.round((float) (Math.asin(y / z) / Math.PI * 180));//角度

                    if (upY < downY && jiaodu > 45) {//上 遊戲裡相反
                        if (test_map0[px - 1][py] != 0) {
                            test_map1[px][py] = 0;
                            tx = px;
                            ty = py;
                            px = px - 1;
                            test_map1[px][py] = 1;
                            go();
                        }


                    } else if (upY > downY && jiaodu > 45) {//下 遊戲裡相反
                        if (test_map0[px + 1][py] != 0) {
                            test_map1[px][py] = 0;
                            tx = px;
                            ty = py;
                            px = px + 1;
                            test_map1[px][py] = 1;
                            go();
                        }

                    } else if (upX < downX && jiaodu <= 45) {//左 遊戲裡相反
                        if (test_map0[px][py - 2] != 0) {
                            test_map1[px][py] = 0;
                            tx = px;
                            ty = py;
                            py = py - 2;
                            test_map1[px][py] = 1;
                            go();
                        }

                    } else if (upX > downX && jiaodu <= 45) {//右 遊戲裡相反
                        if (test_map0[px][py + 2] != 0) {
                            test_map1[px][py] = 0;
                            tx = px;
                            ty = py;
                            py = py + 2;
                            test_map1[px][py] = 1;
                            go();
                        }
                    }
                }
                break;
            }
            return true;
        }


    }


}