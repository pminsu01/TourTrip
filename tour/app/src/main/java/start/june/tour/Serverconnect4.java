package start.june.tour;

/**
 * Created by msubun on 17. 8. 27.
 */

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Serverconnect4 {

    String urlstr = ""; // server url 정보 조회 할것.
    String status = "";
    Handler handler;
    String people_info;
    TextView textview;


    public Serverconnect4(){

        new SendData();
    }




    class SendData extends AsyncTask<Object, Object, String> {


        public SendData() {

        }



        @Override
        protected String doInBackground(Object... params) { // background에서 네트워크가 돈다.

            try {

                URL url = new URL(urlstr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.connect();

                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();// 이것은 서버에서 받은 정보들을 라인 따라 읽을꺼야.
                Log.d("박민수", "line 나와라 : " + line);



                if (line.equals("0")) {
                    status = "nope";
                    people_info="0";
                }
                else {
                    status = "yes";

                    people_info =line;



                }

            } catch (IOException e) {
                Log.d("ASDF", "ERROR IS " + e);
                e.printStackTrace();


            } catch (Exception e) {
                Log.d("ASDF", "ERROR IS " + e);

                e.printStackTrace();
            }
            //Log.d("serverconnect",car_many_info[0]);
            return people_info;
        }


    }



}

