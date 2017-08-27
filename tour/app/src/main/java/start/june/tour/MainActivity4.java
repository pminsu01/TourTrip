package start.june.tour;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


//import com.example.ubunms.myapplication.SendData;

public class MainActivity4 extends Activity {


    Button button;
    String car_number;
    //Serverconnect car_server_info;
    int[] images;


    String[] people_view={"차량글자"};   //초기값 선언해줌
    String[] id_info={"차량넘버"};
    String[] region_info={"차량위치"};
    //String[] car_find_url={"차량url"};
    //SendData sendData;
    GuideAdpater guideadapter;
    String status;

    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);




        final TextView car_num =(TextView)findViewById(R.id.textview2);

        button = (Button) findViewById(R.id.next);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                car_number ="123";
                Log.i("박민수",car_number);

                try {
                    connectcheck();

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("박민수","실행되었군!");

            }
        });

        //Log.i("create",car_find_number[0]);



    }



    private void connectcheck() throws ExecutionException, InterruptedException { // 네트워크 상태 check


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Log.i("박민수","conect check");

            refine(car_number);

        }

        else {
            // display error
            Toast.makeText(this, "네트워크 상태를 확인하십시오", Toast.LENGTH_SHORT).show();
        }


    }


    public void refine(String car_num_num) throws ExecutionException, InterruptedException {      // car_info split 해서 할 것


        final ProgressDialog dialog;
        dialog = new ProgressDialog(MainActivity4.this);
        dialog.show();

        String car_in = new Serverconnect4().new SendData().execute().get(); //이게 오류남
        Log.d("박민수","여기되려나");
        Log.d("car_in",car_in);

        if(car_in.equals("0")) {
            Toast.makeText(getApplicationContext(),"차량이 없습니다",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }

        else {

            String[] people_info = car_in.split("@");
            Log.d("people",people_info[0]); //여기까지 실행됌   골뱅이 중심으로 깨진다.

            people_view = new String[people_info.length];
            id_info = new String[people_info.length];
            region_info = new String[people_info.length];


            for(int i=0; i<people_info.length;i++) {       // 갯수처럼

                String[] people_serpe_info = people_info[i].split(" ");
                Log.i("car_ff",people_serpe_info[0]);

                people_view[i] = people_serpe_info[0];
                id_info[i] = people_serpe_info[1];
                region_info[i]  = people_serpe_info[2];


            }



            //Log.i("박민수",people_serpe_info[0]);
            guideadapter = new GuideAdpater(this,people_view,id_info,region_info);
            guideadapter.notifyDataSetChanged();
            ListView listView =(ListView)findViewById(R.id.listview);
            listView.setAdapter(guideadapter);
            dialog.dismiss();




        }




    }







}







