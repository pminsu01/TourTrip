package start.june.tour;

/**
 * Created by msubun on 17. 8. 27.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/* Created by ubunms on 17. 5. 17.
*/

public class GuideAdpater extends BaseAdapter {
    Context context;
    String[] people={};
    String[] id={};
    String[] region={};
    String[] car_url={};


    public GuideAdpater(Context context,String[] people, String[] id,String[] region){

        Log.d("caradapter","도착했어!");

        this.context = context;
        //this.car_url =car_url;
        this.people =people;
        this.id = id;
        this.region = region;
        Log.d("Caradpater",people[0]);
        Log.d("Caradapter",id[0]);
        Log.d("cards",region[0]);
        // Log.d("dsfsdf",car_url[0]);
    }



    @Override
    public int getCount() {
        return people.length;
    }

    @Override
    public Object getItem(int position) {

        return people[position];

    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.image_item4,parent,false);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.iv_image);
        TextView id_info= (TextView)convertView.findViewById(R.id.id);
        TextView region_info = (TextView)convertView.findViewById(R.id.region);
        //TextView where_info= (TextView)convertView.findViewById(R.id.car_where);

        Image_View image_view = new Image_View();
        image_view.setImage(imageView,people[position]);
        id_info.setText(id[position]);
        region_info.setText(region[position]);
        //,where_info.setText(car_url[position]);

        return convertView;

        //car_each_info 0번 차량 string , 1번 차량 넘버, 2번 차량 위치 , 3번 차량 url

    }
}

