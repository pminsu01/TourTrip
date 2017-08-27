package start.june.tour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class LoginActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear11;
	private TextView textview5;
	private EditText edittext1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview4;
	private EditText edittext2;
	private ImageView imageview1;
	private LinearLayout linear13;
	private LinearLayout linear12;
	private LinearLayout linear4;
	private LinearLayout linear10;
	private LinearLayout linear9;
	private TextView textview2;
	private TextView textview6;
	private TextView textview1;



	private Intent go = new Intent();
	private SharedPreferences ID;
	private SharedPreferences pw;
	private SharedPreferences loginid;
	private SharedPreferences home;
	private Vibrator vib;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview5 = (TextView) findViewById(R.id.textview5);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview4 = (TextView) findViewById(R.id.textview4);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview1 = (TextView) findViewById(R.id.textview1);


		ID = getSharedPreferences("id", Activity.MODE_PRIVATE);
		pw = getSharedPreferences("pw", Activity.MODE_PRIVATE);
		loginid = getSharedPreferences("id", Activity.MODE_PRIVATE);
		home = getSharedPreferences("home", Activity.MODE_PRIVATE);
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview4.setBackgroundColor(0xFF1A237E);
				textview4.setTextColor(0xFFFFFFFF);
				if ((edittext1.getText().toString().length() > 0) && (edittext2.getText().toString().length() > 0)) {
					if (edittext1.getText().toString().equals(ID.getString(edittext1.getText().toString(), ""))) {
						if (edittext2.getText().toString().equals(pw.getString(edittext1.getText().toString(), ""))) {
							loginid.edit().putString("id", edittext1.getText().toString()).commit();
							loginid.edit().putString("pw", edittext2.getText().toString()).commit();
							showMessage("로그인 성공!");
							loginid.edit().putString("logyes1", "1").commit();
							go.setClass(getApplicationContext(), Main2Activity.class);
							startActivity(go);
							finish();
						}
						else {
							showMessage("비밀번호가 틀렸습니다");
							textview4.setBackgroundColor(Color.TRANSPARENT);
							textview4.setTextColor(0xFF000000);
						}
					}
					else {
						showMessage("아이디가 틀렸습니다");
						textview4.setBackgroundColor(Color.TRANSPARENT);
						textview4.setTextColor(0xFF000000);
					}
				}
				else {
					showMessage("두 글자 이상 입력하세요");
					textview4.setBackgroundColor(Color.TRANSPARENT);
					textview4.setTextColor(0xFF000000);
				}
			}
		});
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview2.setBackgroundColor(0xFF1A237E);
				textview2.setTextColor(0xFFFFFFFF);
				go.setClass(getApplicationContext(), SignActivity.class);
				startActivity(go);
				finish();
			}
		});
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview6.setBackgroundColor(0xFF1A237E);
				textview6.setTextColor(0xFFFFFFFF);
				go.setClass(getApplicationContext(), MainActivity.class);
				startActivity(go);
				finish();
			}
		});
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});

	}

	private void  initializeLogic() {
		textview4.setBackgroundColor(Color.TRANSPARENT);
		textview4.setTextColor(0xFF000000);
		textview2.setBackgroundColor(Color.TRANSPARENT);
		textview2.setTextColor(0xFF000000);
		textview6.setBackgroundColor(Color.TRANSPARENT);
		textview6.setTextColor(0xFF000000);
		textview1.setBackgroundColor(Color.TRANSPARENT);
		textview1.setTextColor(0xFF000000);
	}

	@Override
	public void onBackPressed() {
				if ("1".equals(home.getString("homeyes1", ""))) {
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
				else {
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
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
