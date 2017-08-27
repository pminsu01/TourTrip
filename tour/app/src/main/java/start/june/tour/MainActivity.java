package start.june.tour;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



    public class MainActivity extends Activity {

        private LinearLayout motherframe;
        private LinearLayout linear9;
        private LinearLayout appname;
        private LinearLayout linear8;
        private LinearLayout linear24;
        private ImageView exit;
        private TextView textappname;
        private LinearLayout linear12;
        private LinearLayout linear14;
        private LinearLayout linear13;
        private LinearLayout portal;
        private LinearLayout linear16;
        private LinearLayout internet;
        private TextView textportal;
        private TextView textmail;
        private LinearLayout linear21;
        private LinearLayout linear22;
        private LinearLayout linear23;
        private ImageView my;
        private LinearLayout mymenu;
        private LinearLayout linear18;
        private LinearLayout load;
        private TextView textmypage;
        private TextView textload;
        private ImageView imageview1;

        private double bar = 0;
        private double rewind = 0;

        private ArrayList<String> ff = new ArrayList<String>();

        private Timer _timer = new Timer();
        private TimerTask timer1;
        private AlertDialog.Builder dia;
        private Intent i = new Intent();
        private AlertDialog.Builder dia2;
        private SharedPreferences momey;
        private SharedPreferences url;
        private Vibrator vib;
        private SharedPreferences loginid;
        private SharedPreferences home;
        private SharedPreferences end;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            initialize();
            initializeLogic();
        }

        private void  initialize() {
            motherframe = (LinearLayout) findViewById(R.id.motherframe);
            linear9 = (LinearLayout) findViewById(R.id.linear9);
            appname = (LinearLayout) findViewById(R.id.appname);
            linear8 = (LinearLayout) findViewById(R.id.linear8);
            exit = (ImageView) findViewById(R.id.exit);
            linear12 = (LinearLayout) findViewById(R.id.linear12);
            linear14 = (LinearLayout) findViewById(R.id.linear14);
            linear13 = (LinearLayout) findViewById(R.id.linear13);
            portal = (LinearLayout) findViewById(R.id.portal);
            linear16 = (LinearLayout) findViewById(R.id.linear16);
            internet = (LinearLayout) findViewById(R.id.internet);
            textportal = (TextView) findViewById(R.id.textportal);
            textmypage = (TextView) findViewById(R.id.textmypage);
            linear22 = (LinearLayout) findViewById(R.id.linear22);
            my = (ImageView) findViewById(R.id.my);
            linear18 = (LinearLayout) findViewById(R.id.linear18);
            load = (LinearLayout) findViewById(R.id.load);
            textload = (TextView) findViewById(R.id.textload);
            imageview1 = (ImageView) findViewById(R.id.imageview1);


            dia = new AlertDialog.Builder(this);

            dia2 = new AlertDialog.Builder(this);
            momey = getSharedPreferences("money", Activity.MODE_PRIVATE);
            url = getSharedPreferences("url", Activity.MODE_PRIVATE);
            vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            loginid = getSharedPreferences("id", Activity.MODE_PRIVATE);
            home = getSharedPreferences("home", Activity.MODE_PRIVATE);
            end = getSharedPreferences("print", Activity.MODE_PRIVATE);

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _v) {
                    dia.setTitle("🔩 설정 Setting");
                    dia.setNegativeButton("앱 탈출하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface _dialog, int _which) {
                            showMessage("탈출성공!");
                            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            finish();
                        }
                    });
                    dia.setPositiveButton("문의하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface _dialog, int _which) {
                            dia2.setTitle("🐞 문의 Question");
                            dia2.setMessage("버그를 발견 했나요?");
                            dia2.setPositiveButton("메일로 문의하기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface _dialog, int _which) {
                                    i.setAction(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse("mailto:to55cancri@hanyang.ac.kr?subject=I got a bug 2.june.0"));
                                    startActivity(i);
                                }
                            });
                            dia2.setNegativeButton("뒤로가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface _dialog, int _which) {
                                    dia.create().show();
                                }
                            });
                            dia2.create().show();
                        }
                    });
                    dia.create().show();
                }
            });
            textmypage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _v) {
                    if ("1".equals(loginid.getString("logyes1", ""))) {
                        i.setClass(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        i.setClass(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            });

            textload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View _v) {
                            if ("1".equals(loginid.getString("logyes1", ""))) {
                                i.setClass(getApplicationContext(), Main3Activity.class);
                                startActivity(i);
                                finish();
                            }
                            else {
                                i.setClass(getApplicationContext(), Main3Activity.class);
                                startActivity(i);
                                finish();
                            }
                }
            });
            textportal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _v) {
                    if ("1".equals(loginid.getString("logyes1", ""))) {
                        i.setClass(getApplicationContext(), MainActivity4.class);
                        startActivity(i);

                    }
                    else {
                        i.setClass(getApplicationContext(), MainActivity4.class);
                        startActivity(i);

                    }
                }
            });

            //imageview1.setOnClickListener(new View.OnClickListener() {
            //    @Override
           //     public void onClick(View _v) {

           //     }
          //  });

        }

        private void  initializeLogic() {

            home.edit().putString("homeyes1", "0").commit();

            textmypage.setVisibility(View.VISIBLE);
            end.edit().putString("money", "0").commit();
        }

        @Override
        public void onBackPressed() {
            dia.setTitle("😴 정말 종료합니까?");
            dia.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface _dialog, int _which) {
                    finish();
                }
            });
            dia.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface _dialog, int _which) {

                }
            });
            dia.create().show();
        }



        // created automatically
        private void showMessage(String _s) {
            Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
        }

        private int getRandom(int _minValue ,int _maxValue){
            Random random = new Random();
            return random.nextInt(_maxValue - _minValue + 1) + _minValue;
        }

        public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
            ArrayList<Double> _result = new ArrayList<Double>();
            SparseBooleanArray _arr = _list.getCheckedItemPositions();
            for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
                if (_arr.valueAt(_iIdx))
                    _result.add((double)_arr.keyAt(_iIdx));
            }
            return _result;
        }

    }


