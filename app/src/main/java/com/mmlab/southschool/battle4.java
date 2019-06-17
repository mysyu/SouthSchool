package com.mmlab.southschool;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

public class battle4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return new battle4.AnimView(getActivity());

    }

    private Paint paint;
    private Canvas canvas;
    private Bitmap player, back, mon, anm, anm2;
    private SurfaceHolder sfh;


    private int doing = 0;
    private int mon_doing = 0;
    int game_over = 0;

    int snow_hp = 100;

    Thread mon_magic_thread, mon_movie_thread, user_magic_thread;

    private int[][] test_player = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_mon = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_back = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 37, 37, 37, 37, 37, 37, 37, 37, 37, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_anm = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private int[][] test_anm2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };


    private int mapx = 0;// map地图的唯一坐标
    private int mapy = 0;
    private float titleW;// 每一个方块的宽度和高度
    private float titleH;
    private int n = 0;// 每一行的方块数量
    private int n2 = 0;// 每一行的方块数量


    private int tx = 0;
    private int ty = 0;

    private int px = 0;
    private int py = 0;

    private int mpx = 11;
    private int mpy = 5;

    private int mtx = 2;
    private int mty = 5;


    float upX, upY, downX, downY;

    DisplayMetrics displaymetrics = new DisplayMetrics();
    int height;
    int width;

    GlobalVariable globalVariable;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        globalVariable = (GlobalVariable) getActivity().getApplicationContext();

        Button doBtn = (Button) getActivity().findViewById(R.id.doBtn);
        doBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button toBag = (Button) getActivity().findViewById(R.id.toBag);
        toBag.setText("離開");
        toBag.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (doing == 0 && game_over == 1) {
                    FragmentManager fm;
                    fm = getActivity().getSupportFragmentManager();

                    if (fm.getBackStackEntryCount() == 0) {
                        getActivity().finish();
                    } else {
                        fm.popBackStack();
                    }


                    Button toBag = (Button) getActivity().findViewById(R.id.toBag);
                    toBag.setText("背包");
                } else {
                    new AlertDialog.Builder(getActivity()).setMessage("戰鬥中不能逃走").show();
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
            player = BitmapFactory.decodeResource(getResources(), R.drawable.player);
            back = BitmapFactory.decodeResource(getResources(), R.drawable.room);
            mon = BitmapFactory.decodeResource(getResources(), R.drawable.snow);
            GlobalVariable globalVariable = (GlobalVariable) getActivity().getApplicationContext();
            if (globalVariable.with_what == 3) {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.fire2);
            } else if (globalVariable.with_what == 4) {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.ground);
            } else if (globalVariable.with_what == 2) {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.tor);
            } else if (globalVariable.with_what == 5) {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.taigee);
            } else if (globalVariable.with_what == 7) {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.green);
            } else {
                anm = BitmapFactory.decodeResource(getResources(), R.drawable.boom);
            }
            anm2 = BitmapFactory.decodeResource(getResources(), R.drawable.ice);

            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            height = displaymetrics.heightPixels;
            width = displaymetrics.widthPixels;
            float density = displaymetrics.density;

            titleW = (32 * density);
            titleH = (32 * density);


            n = back.getWidth() / (int) titleW;
            n2 = anm.getWidth() / (int) titleW;
        }

        /* 在surface的大小發生改變時啟動 */
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        /* 在建立時啟動，一般在這裡呼叫繪圖的執行緒 */
        public void surfaceCreated(SurfaceHolder holder) {
            /* 啟動執行緒繪圖 */
            myDraw();
            mon_movie_thread();


        }

        /* 結束時啟動，一般在這裡將繪圖的執行緒停止、釋放 */
        public void surfaceDestroyed(SurfaceHolder holder) {
        }

        private void myDraw() {
            // TODO Auto-generated method stub
            canvas = sfh.lockCanvas();//实例化
            //中间代码绘图过程
            //i控制行输出,j控制列输出

            for (int i = 0; i < test_back.length; i++) {
                for (int j = 0; j < test_back[i].length; j++) {
                    canvas.save();
                    //绘制一个矩形可视区域
                    canvas.clipRect(j * titleW + mapx, i * titleH + mapy, (j + 1) * titleW + mapx, (i + 1) * titleH + mapy);
                    //在每个矩形区域内，将原地图的指定的模块绘制在矩形区域内
                    canvas.drawBitmap(back, j * titleW + mapx - ((test_back[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_back[i][j] - 1) / n) * titleH, paint);
                    canvas.drawBitmap(player, j * titleW + mapx - ((test_player[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_player[i][j] - 1) / n) * titleH, paint);
                    canvas.drawBitmap(mon, j * titleW + mapx - ((test_mon[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_mon[i][j] - 1) / n) * titleH, paint);
                    canvas.drawBitmap(anm, j * titleW + mapx - ((test_anm[i][j] - 1) % n2) * titleW, i * titleH + mapy - ((test_anm[i][j] - 1) / n2) * titleH, paint);
                    canvas.drawBitmap(anm2, j * titleW + mapx - ((test_anm2[i][j] - 1) % n) * titleW, i * titleH + mapy - ((test_anm2[i][j] - 1) / n) * titleH, paint);
                    canvas.restore();
                }
            }
            sfh.unlockCanvasAndPost(canvas);//解锁画布
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
                    if (globalVariable.hp > 0) {

                        upX = event.getX();
                        upY = event.getY();
                        float x = Math.abs(upX - downX);
                        float y = Math.abs(upY - downY);
                        double z = Math.sqrt(x * x + y * y);
                        int jiaodu = Math.round((float) (Math.asin(y / z) / Math.PI * 180));//角度

                        if (upY < downY && jiaodu > 45) {//上 遊戲裡相反
                            test_player[mpx][mpy] = 0;
                            if (test_back[mpx - 1][mpy] == 37 && mpx > 3) {

                                mpx--;
                            }
                            test_player[mpx][mpy] = 25;
                            myDraw();
                        } else if (upY > downY && jiaodu > 45) {//下 遊戲裡相反
                            test_player[mpx][mpy] = 0;
                            if (test_back[mpx + 1][mpy] == 37) {

                                mpx++;
                            }
                            test_player[mpx][mpy] = 25;
                            myDraw();
                        } else if (upX < downX && jiaodu <= 45) {//左 遊戲裡相反
                            test_player[mpx][mpy] = 0;
                            if (test_back[mpx][mpy - 1] == 37) {

                                mpy--;
                            }
                            test_player[mpx][mpy] = 25;
                            myDraw();
                        } else if (upX > downX && jiaodu <= 45) {//右 遊戲裡相反
                            test_player[mpx][mpy] = 0;
                            if (test_back[mpx][mpy + 1] == 37) {

                                mpy++;
                            }
                            test_player[mpx][mpy] = 25;
                            myDraw();
                        } else {
                            if (doing == 0) {
                                px = mpx;
                                py = mpy;
                                user_magic_thread();

                            }
                        }
                    } else {
                        new AlertDialog.Builder(getActivity()).setMessage("你輸了").show();
                    }
                }
                break;
            }
            return true;
        }


        private void user_magic_thread() {
            user_magic_thread = new Thread() {
                @Override
                public void run() {
                    doing = 1;
                    for (int count = 0; count <= 10; ++count) {
                        if (px == mtx && py == mty) {
                            mon_hit();
                            break;
                        } else if (px != 1) {
                            test_anm[px][py] = 0;
                            px--;
                            test_anm[px][py] = 1;
                            myDraw();
                        } else {
                            count = 10;
                        }


                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                        }

                    }
                    doing = 0;
                    test_anm[px][py] = 0;
                    myDraw();


                }
            };
            user_magic_thread.start();
        }

        private void mon_movie_thread() {
            mon_movie_thread = new Thread() {
                @Override
                public void run() {
                    int leftorright = 1;
                    int use_magic = 1;

                    for (int count = 0; count <= 10000; ++count) {

                        if (game_over == 1) {
                            test_mon[mtx][mty] = 0;
                            myDraw();
                            break;
                        }

                        int ram = (int) (Math.random() * 2 + 1);
                        test_mon[mtx][mty] = 0;
                        if (ram == 1) {
                            if (mty + 1 != 10) {
                                leftorright = 1;
                            } else {
                                leftorright = -2;
                            }

                        }
                        if (ram == 2) {
                            if (mty - 1 != 0) {
                                leftorright = -1;
                            } else {
                                leftorright = 2;
                            }

                        }


                        if (use_magic == 8) {
                            if (mon_doing == 0) {
                                tx = mtx;
                                ty = mty;
                                mon_magic_thread();
                            }
                            use_magic = 1;
                        }
                        use_magic++;


                        mty = mty + leftorright;
                        test_mon[mtx][mty] = 1;

                        myDraw();

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }

                    }

                }
            };
            mon_movie_thread.start();
        }


        private void mon_magic_thread() {
            mon_magic_thread = new Thread() {
                @Override
                public void run() {
                    mon_doing = 1;

                    test_anm2[tx][ty] = 0;
                    myDraw();
                    for (int count = 0; count <= 13; ++count) {

                        if (tx == mpx && ty == mpy) {
                            player_hit();
                            break;
                        } else if (tx != 12) {
                            test_anm2[tx][ty] = 0;
                            tx++;
                            test_anm2[tx][ty] = 1;
                            myDraw();

                        } else {
                            count = 15;
                        }


                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException e) {
                        }

                    }
                    mon_doing = 0;
                    test_anm2[tx][ty] = 0;
                    myDraw();


                }
            };
            mon_magic_thread.start();

        }


        private void mon_hit() {
            snow_hp = snow_hp - globalVariable.attack;
            if (snow_hp <= 0 && game_over == 0) {
                globalVariable.snow = 0;
                globalVariable.level = globalVariable.level + 1;
                globalVariable.max_hp += 5;
                myHandler.sendEmptyMessage(1);
                game_over = 1;
            }
        }

        private void player_hit() {
            globalVariable.hp = globalVariable.hp - 5 < 0 ? 0 : globalVariable.hp - 5;
            myHandler.sendEmptyMessage(0);
            if (globalVariable.hp <= 0) {
                game_over = 1;
            }
        }


    }

    private final Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            final int what = msg.what;
            switch (what) {
                //minus health
                case 0:
                    doMinusHealth();
                    break;

                //update level
                case 1:
                    doUpdateLebel();
                    break;
            }
        }
    };

    private void doMinusHealth() {
        Button btn_hp = (Button) getActivity().findViewById(R.id.hp);
        btn_hp.setText("血量" + globalVariable.hp);
    }

    private void doUpdateLebel() {
        Button level = (Button) getActivity().findViewById(R.id.level);
        level.setText("等級" + globalVariable.level);
    }
}
