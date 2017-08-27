package start.june.tour;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Serverconnect {

    String urlstr = "http://ec2-52-14-166-136.us-east-2.compute.amazonaws.com/android_req.php"; // 정보 조회 할것.
    String status = "";
    Handler handler;
    String picture_url;
    String where;

    // String[] car_where;
    //String[] car_picture_url;
    TextView textview;




    public Serverconnect(String main_info) {

        this.where = main_info;
        //Log.d("serverconnect",main_info);
        new SendData(where);



    }


    class SendData extends AsyncTask<Object, Object, String> {

        public SendData(String main_info) {

        }

        public SendData() {

        }



        @Override
        protected String doInBackground(Object... params) { // background에서 네트워크가 돈다.

            try {
                Log.d("serverconnect","come on baby");
                URL url = new URL(urlstr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Log.d("server","yes!");

                //editText car_number;

                HashMap<String, String> nameValue = new HashMap<String, String>();    // HashMap을 쓰는 이유는 post 방식이기 때문에 이해 안되면 나한테 물어볼 것
                nameValue.put("where", where);
                Log.d("serverconnect+where",where);

                OutputStream os = conn.getOutputStream();


                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                writer.write(getQuery(nameValue));                      // getQuery문을 쓸거야. => 즉 서버로 보내는 query문이야 여기서 car_number을 보낼 거
                Log.d("박민수", where);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();// 이것은 서버에서 받은 정보들을 라인 따라 읽을꺼야.
                Log.d("박민수", "line 나와라 : " + line);



                if (line.equals("0")) {
                    status = "nope";
                    picture_url="0";
                }
                else {
                    status = "yes";
                    picture_url =line;



                }

            } catch (IOException e) {
                Log.d("ASDF", "ERROR IS " + e);
                e.printStackTrace();


            } catch (Exception e) {
                Log.d("ASDF", "ERROR IS " + e);

                e.printStackTrace();
            }
            //Log.d("serverconnect",car_many_info[0]);
            return picture_url;
        }


    }

    private String getQuery(HashMap<String, String> params) throws UnsupportedEncodingException {

        StringBuilder result = new StringBuilder();
        boolean first = true; // 첫번째 매개변수 여

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;

            else

                result.append("&");
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("="); //?
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                Log.i("박민수", String.valueOf(result));

            }
            return result.toString();
        }


    }

