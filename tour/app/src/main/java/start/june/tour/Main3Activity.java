package start.june.tour;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
//import static com.example.ubunms.myapplication.R.id.textview2;


//import com.example.ubunms.myapplication.SendData;

public class Main3Activity extends Activity {


    Button button;
    String where;
    String[] id={"id"};   //초기값 선언해줌
    CarAdapter carAdapter;




    private Intent go = new Intent();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);




        Button button = (Button) findViewById(R.id.next);
        ImageButton  imageButton =(ImageButton) findViewById(R.id.next1);

        //final TextView textView =(TextView)findViewById(R.id.textView2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 where = "seoul";

                 Log.i("박민수",where);

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

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main3Activity.this,MainActivity4.class);
                startActivity(intent);
            }
        });



    }



    private void connectcheck() throws ExecutionException, InterruptedException { // 네트워크 상태 check


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
                Log.i("박민수","connect check");

                refine(where);

        }

        else {
            // display error
            Toast.makeText(this, "네트워크 상태를 확인하십시오", Toast.LENGTH_SHORT).show();
        }


    }



    public void refine(String where) throws ExecutionException, InterruptedException {      // car_info split 해서 할 것


        final ProgressDialog dialog;
        dialog = new ProgressDialog(Main3Activity.this);
        dialog.show();

        String picutre_info = new Serverconnect(where).new SendData().execute().get(); //이게 오류남
        Log.d("박민수","여기되려나");
        Log.d("car_in",picutre_info);

        if(picutre_info.equals("0")) {
            Toast.makeText(getApplicationContext(),"no register images",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }

        else {

                String[] pre_picture_url = picutre_info.split("@"); // pre_picture_url : preview , after select region
                Log.d("pre_picutre",pre_picture_url[0]); //여기까지 실행됌   골뱅이 중심으로 깨진다.



            Log.i("박민수",pre_picture_url[0]);
            carAdapter = new CarAdapter(this,pre_picture_url);
            carAdapter.notifyDataSetChanged();
            ListView listView =(ListView)findViewById(R.id.listview);
            listView.setAdapter(carAdapter);
            dialog.dismiss();


        }



    }


    public void onBackPressed() {

            go.setClass(getApplicationContext(), MainActivity.class);
            startActivity(go);
            finish();
        }



    }







