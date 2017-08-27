package start.june.tour;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


/* Created by ubunms on 17. 5. 17.
*/

public class CarAdapter extends BaseAdapter {
    Context context;
    //String[] id={};
    //String[] where={};
    String[] picture_url={};



    public CarAdapter(Context context,String[] picture_url){

        Log.d("caradapter","도착했어!");

        this.context = context;
        //this.id =id;
        //this.where =where;
        this.picture_url = picture_url;

        //Log.d("Caradpater",id[0]);
       // Log.d("Caradapter",where[0]);
        Log.d("cards",picture_url[0]);

    }



    @Override
    public int getCount() {
        return picture_url.length;
    }

    @Override
    public Object getItem(int position) {

        return picture_url[position];

    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.image_item3,parent,false);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.iv_image);
       // TextView string_info= (TextView)convertView.findViewById(R.id.car_String);
        //TextView number_info = (TextView)convertView.findViewById(R.id.car_number);
        //  TextView where_info= (TextView)convertView.findViewById(R.id.car_where);

        Image_View image_view = new Image_View();
        image_view.setImage(imageView,picture_url[position]);
        //string_info.setText(id[position]);
        //number_info.setText(where[position]);


        return convertView;

        //car_each_info 0번 차량 string , 1번 차량 넘버, 2번 차량 위치 , 3번 차량 url

    }
}

