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
import java.util.Timer;
import java.util.TimerTask;


public class SignActivity extends Activity {

	private LinearLayout linear5;
	private LinearLayout linear12;
	private LinearLayout linear2;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout linear4;
	private LinearLayout linear11;
	private EditText newid;
	private EditText student;
	private EditText newpw;
	private LinearLayout linear9;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private TextView textview2;
	private TextView textview1;
	private TextView sign;



	private Timer _timer = new Timer();
	private Intent back = new Intent();
	private SharedPreferences ID;
	private TimerTask time;
	private SharedPreferences momey;
	private SharedPreferences name;
	private Vibrator vib;
	private SharedPreferences pw;
	private SharedPreferences print;
	private SharedPreferences end;
	private SharedPreferences pointsave;
	private SharedPreferences colorprint;
	private SharedPreferences doubleprint;
	private SharedPreferences moneyprint;
	private SharedPreferences multiprint;
	private SharedPreferences divideprint;
	private SharedPreferences placeprint;
	private SharedPreferences docprint;
	private SharedPreferences printyes;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		newid = (EditText) findViewById(R.id.newid);
		student = (EditText) findViewById(R.id.student);
		newpw = (EditText) findViewById(R.id.newpw);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		sign = (TextView) findViewById(R.id.sign);


		ID = getSharedPreferences("id", Activity.MODE_PRIVATE);

		momey = getSharedPreferences("money", Activity.MODE_PRIVATE);
		name = getSharedPreferences("name", Activity.MODE_PRIVATE);
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		pw = getSharedPreferences("pw", Activity.MODE_PRIVATE);
		print = getSharedPreferences("list", Activity.MODE_PRIVATE);
		end = getSharedPreferences("print", Activity.MODE_PRIVATE);
		pointsave = getSharedPreferences("point", Activity.MODE_PRIVATE);
		colorprint = getSharedPreferences("colorprint", Activity.MODE_PRIVATE);
		doubleprint = getSharedPreferences("doubleprint", Activity.MODE_PRIVATE);
		moneyprint = getSharedPreferences("moneyprint", Activity.MODE_PRIVATE);
		multiprint = getSharedPreferences("multiprint", Activity.MODE_PRIVATE);
		divideprint = getSharedPreferences("divideprint", Activity.MODE_PRIVATE);
		placeprint = getSharedPreferences("placeprint", Activity.MODE_PRIVATE);
		docprint = getSharedPreferences("docprint", Activity.MODE_PRIVATE);
		printyes = getSharedPreferences("printyes", Activity.MODE_PRIVATE);

		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		sign.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				sign.setBackgroundColor(0xFF1A237E);
				sign.setTextColor(0xFFFFFFFF);
				if ((newid.getText().toString().length() > 0) && (student.getText().toString().length() > 0)) {
					if (student.getText().toString().equals(ID.getString(student.getText().toString(), ""))) {
						sign.setBackgroundColor(Color.TRANSPARENT);
						sign.setTextColor(0xFF000000);
						showMessage("학번이 중복 입니다. ");
					}
					else {
						if (newid.getText().toString().equals(name.getString(student.getText().toString(), ""))) {
							sign.setBackgroundColor(Color.TRANSPARENT);
							sign.setTextColor(0xFF000000);
							showMessage("이름이 중복 입니다. ");
						}
						else {
							name.edit().putString(student.getText().toString(), newid.getText().toString()).commit();
							pw.edit().putString(student.getText().toString(), newpw.getText().toString()).commit();
							ID.edit().putString(student.getText().toString(), student.getText().toString()).commit();
							momey.edit().putString(student.getText().toString(), "0").commit();
							end.edit().putString("money", "0").commit();
							pointsave.edit().putString(student.getText().toString(), "0").commit();
							print.edit().remove("yes1").commit();
							print.edit().remove("yes2").commit();
							print.edit().remove("yes3").commit();
							print.edit().remove("yes4").commit();
							end.edit().putString("yes1", "").commit();
							end.edit().putString("yes2", "").commit();
							end.edit().putString("yes3", "").commit();
							end.edit().putString("yes4", "").commit();
							end.edit().putString("check2", "").commit();
							end.edit().putString("check5", "").commit();
							end.edit().putString(student.getText().toString(), "0").commit();
							colorprint.edit().putString(student.getText().toString(), "").commit();
							doubleprint.edit().putString(student.getText().toString(), "").commit();
							multiprint.edit().putString(student.getText().toString(), "").commit();
							divideprint.edit().putString(student.getText().toString(), "").commit();
							placeprint.edit().putString(student.getText().toString(), "3").commit();
							docprint.edit().putString(student.getText().toString(), "").commit();
							printyes.edit().putString(student.getText().toString(), "0").commit();
							end.edit().putString("place", "0").commit();
							moneyprint.edit().putString(student.getText().toString(), "0").commit();
							momey.edit().putString(student.getText().toString(), "1000").commit();
							end.edit().putString("printyes1", "0").commit();
							showMessage("가입성공! 로그인해주세요");
							time = new TimerTask() {
										@Override
											public void run() {
												runOnUiThread(new Runnable() {
												@Override
													public void run() {
																				back.setClass(getApplicationContext(), LoginActivity.class);
													startActivity(back);
													finish();
													}
												});
											}
										};
										_timer.schedule(time, (int)(100));
						}
					}
				}
				else {
					showMessage("한 자리이상 입력해주세요");
					sign.setBackgroundColor(Color.TRANSPARENT);
					sign.setTextColor(0xFF000000);
				}
			}
		});
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview1.setBackgroundColor(0xFF1A237E);
				textview1.setTextColor(0xFFFFFFFF);
				back.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(back);
				finish();
			}
		});
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview2.setBackgroundColor(0xFF1A237E);
				textview2.setTextColor(0xFFFFFFFF);
				back.setClass(getApplicationContext(), MainActivity.class);
				startActivity(back);
				finish();
			}
		});

	}

	private void  initializeLogic() {
		sign.setBackgroundColor(Color.TRANSPARENT);
		sign.setTextColor(0xFF000000);
		textview1.setBackgroundColor(Color.TRANSPARENT);
		textview1.setTextColor(0xFF000000);
		textview2.setBackgroundColor(Color.TRANSPARENT);
		textview2.setTextColor(0xFF000000);
	}

	@Override
	public void onBackPressed() {
				back.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(back);
				finish();
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
