package com.mmlab.southschool;

import android.app.Application;

public class GlobalVariable extends Application {
    int inital_x = 4;
    int inital_y = 3;
    int inital_z = 1;


    int hp = 50;
    int max_hp = 50;
    int level = 1;


    int library_qte = 0;
    int computer_qte = 0;
    int g502_qte = 0;
    int health_center_qte = 0;


    int Skull = 1;
    int gblin = 1;
    int chicken = 1;
    int man = 1;
    int snow = 1;
    int firelord = 1;
    int waterlord = 1;
    int grasslord = 1;
    int vip = 1;


    int old_key = 1;
    int wind_arrow = 0;
    int firestone = 0;
    int hammer = 0;
    int inyun = 0;
    int helmelt = 0;


    int with_what = 0;

    int attack = 20;

    String[] test = {"", "有個漆黑的身影出現在角落，要提防他嗎?", "陷阱發動了要向左閃避嗎?",};

    String[] yes = {"", "你往後看了看，什麼也沒有", "",};

    String[] no = {"", "你被魔王的手下偷襲了", "",};

    int[] answer = {0, 0, 1, 0, 0, 0, 1, 0,
            1, 0, 0, 1, 0};


}
