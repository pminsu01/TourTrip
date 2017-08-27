package start.june.tour;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MymenuActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout motherframe;
	private TextView textview12;
	private LinearLayout linear34;
	private LinearLayout linear41;
	private LinearLayout linear35;
	private LinearLayout linear49;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear46;
	private ImageView imageview1;
	private LinearLayout linear38;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private TextView logname;
	private TextView textview13;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private LinearLayout linear47;
	private TextView logid;
	private TextView textid;
	private TextView textview18;
	private TextView textcharge;
	private LinearLayout linear45;
	private TextView textview11;
	private LinearLayout linear48;
	private TextView textmomey;
	private TextView textgocharge;
	private TextView textview19;
	private LinearLayout linear50;
	private TextView textview20;
	private LinearLayout linear51;
	private TextView textpoint;
	private TextView textview21;
	private TextView textcart;
	private TextView textprint;
	private TextView textorder;
	private TextView textlogout;
	private TextView textout;
	private TextView textview15;
	private TextView result;
	private TextView point;



	private Intent go = new Intent();
	private SharedPreferences ID;
	private SharedPreferences momey;
	private SharedPreferences name;
	private SharedPreferences pw;
	private SharedPreferences momey2;
	private SharedPreferences loginid;
	private SharedPreferences home;
	private AlertDialog.Builder dia;
	private SharedPreferences end;
	private SharedPreferences pointsave;
	private SharedPreferences moneyprint;
	private SharedPreferences colorprint;
	private SharedPreferences doubleprint;
	private SharedPreferences multiprint;
	private SharedPreferences divideprint;
	private SharedPreferences placeprint;
	private SharedPreferences docprint;
	private SharedPreferences printyes;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymenu);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		motherframe = (LinearLayout) findViewById(R.id.motherframe);
		textview12 = (TextView) findViewById(R.id.textview12);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		logname = (TextView) findViewById(R.id.logname);
		textview13 = (TextView) findViewById(R.id.textview13);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		linear47 = (LinearLayout) findViewById(R.id.linear47);
		logid = (TextView) findViewById(R.id.logid);
		textid = (TextView) findViewById(R.id.textid);
		textview18 = (TextView) findViewById(R.id.textview18);
		textcharge = (TextView) findViewById(R.id.textcharge);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear48 = (LinearLayout) findViewById(R.id.linear48);
		textmomey = (TextView) findViewById(R.id.textmomey);
		textgocharge = (TextView) findViewById(R.id.textgocharge);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		textview20 = (TextView) findViewById(R.id.textview20);
		linear51 = (LinearLayout) findViewById(R.id.linear51);
		textpoint = (TextView) findViewById(R.id.textpoint);
		textview21 = (TextView) findViewById(R.id.textview21);
		textcart = (TextView) findViewById(R.id.textcart);
		textprint = (TextView) findViewById(R.id.textprint);
		textorder = (TextView) findViewById(R.id.textorder);
		textlogout = (TextView) findViewById(R.id.textlogout);
		textout = (TextView) findViewById(R.id.textout);
		textview15 = (TextView) findViewById(R.id.textview15);
		result = (TextView) findViewById(R.id.result);
		point = (TextView) findViewById(R.id.point);


		ID = getSharedPreferences("id", Activity.MODE_PRIVATE);
		momey = getSharedPreferences("money", Activity.MODE_PRIVATE);
		name = getSharedPreferences("name", Activity.MODE_PRIVATE);
		pw = getSharedPreferences("pw", Activity.MODE_PRIVATE);
		momey2 = getSharedPreferences("currentMoney", Activity.MODE_PRIVATE);
		loginid = getSharedPreferences("id", Activity.MODE_PRIVATE);
		home = getSharedPreferences("home", Activity.MODE_PRIVATE);
		dia = new AlertDialog.Builder(this);
		end = getSharedPreferences("print", Activity.MODE_PRIVATE);
		pointsave = getSharedPreferences("point", Activity.MODE_PRIVATE);
		moneyprint = getSharedPreferences("moneyprint", Activity.MODE_PRIVATE);
		colorprint = getSharedPreferences("colorprint", Activity.MODE_PRIVATE);
		doubleprint = getSharedPreferences("doubleprint", Activity.MODE_PRIVATE);
		multiprint = getSharedPreferences("multiprint", Activity.MODE_PRIVATE);
		divideprint = getSharedPreferences("divideprint", Activity.MODE_PRIVATE);
		placeprint = getSharedPreferences("placeprint", Activity.MODE_PRIVATE);
		docprint = getSharedPreferences("docprint", Activity.MODE_PRIVATE);
		printyes = getSharedPreferences("printyes", Activity.MODE_PRIVATE);

		textlogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textlogout.setBackgroundColor(0xFF1A237E);
				textlogout.setTextColor(0xFFFFFFFF);
				if ("1".equals(home.getString("homeyes1", ""))) {
					loginid.edit().remove("id").commit();
					loginid.edit().remove("pw").commit();
					loginid.edit().putString("logyes1", "0").commit();
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
				else {
					loginid.edit().remove("id").commit();
					loginid.edit().remove("pw").commit();
					loginid.edit().putString("logyes1", "0").commit();
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
			}
		});
		textout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textout.setBackgroundColor(0xFF1A237E);
				textout.setTextColor(0xFFFFFFFF);
				dia.setTitle("📴 정말 탈퇴합니까?");
				dia.setPositiveButton("네", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
											ID.edit().remove(textid.getText().toString()).commit();
							name.edit().remove(textid.getText().toString()).commit();
							pw.edit().remove(textid.getText().toString()).commit();
							momey.edit().putString(textid.getText().toString(), "0").commit();
							pointsave.edit().remove(textid.getText().toString()).commit();
							moneyprint.edit().remove(textid.getText().toString()).commit();
							colorprint.edit().remove(textid.getText().toString()).commit();
							doubleprint.edit().remove(textid.getText().toString()).commit();
							multiprint.edit().remove(textid.getText().toString()).commit();
							divideprint.edit().remove(textid.getText().toString()).commit();
							placeprint.edit().remove(textid.getText().toString()).commit();
							docprint.edit().remove(textid.getText().toString()).commit();
							printyes.edit().remove(textid.getText().toString()).commit();
							end.edit().remove(textid.getText().toString()).commit();
							loginid.edit().remove("id").commit();
							loginid.edit().remove("pw").commit();
							end.edit().putString("printyes1", "0").commit();
							go.setClass(getApplicationContext(), MainActivity.class);
							startActivity(go);
							loginid.edit().putString("logyes1", "0").commit();
							showMessage("탈퇴성공!");
							finish();
					}
				});
				dia.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
											textout.setBackgroundColor(Color.TRANSPARENT);
							textout.setTextColor(0xFF000000);
					}
				});
				dia.create().show();
			}
		});
		textgocharge.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				go.setClass(getApplicationContext(), MainActivity.class);
				startActivity(go);
				finish();
			}
		});
		textview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textview15.setBackgroundColor(0xFF1A237E);
				textview15.setTextColor(0xFFFFFFFF);
				go.setClass(getApplicationContext(), MainActivity.class);
				startActivity(go);
				finish();
			}
		});
		textprint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				go.setClass(getApplicationContext(), MainActivity.class);
				startActivity(go);
				finish();
			}
		});
		textcart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				go.setClass(getApplicationContext(), ListActivity.class);
				startActivity(go);
				finish();
			}
		});
		textorder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (Double.parseDouble(printyes.getString(textid.getText().toString(), "")) == 1) {
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
				else {
					showMessage("최근 인쇄내역이 없습니다!");
				}
			}
		});
		textview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				go.setClass(getApplicationContext(), MainActivity.class);
				startActivity(go);
				finish();
			}
		});
		textview21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				textmomey.setText(String.valueOf((long)(Double.parseDouble(momey.getString(textid.getText().toString(), "")) + Double.parseDouble(pointsave.getString(textid.getText().toString(), "")))));
				momey.edit().putString(textid.getText().toString(), textmomey.getText().toString()).commit();
				point.setText("0");
				textpoint.setText("0");
				pointsave.edit().putString(textid.getText().toString(), "0").commit();
				showMessage("적립금 사용완료!");
			}
		});
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});

	}

	private void  initializeLogic() {
		textid.setText(loginid.getString("id", ""));
		textview13.setText(name.getString(textid.getText().toString(), ""));
		textlogout.setBackgroundColor(Color.TRANSPARENT);
		textlogout.setTextColor(0xFF000000);
		textout.setBackgroundColor(Color.TRANSPARENT);
		textout.setTextColor(0xFF000000);
		textview15.setBackgroundColor(Color.TRANSPARENT);
		textview15.setTextColor(0xFF000000);
		result.setVisibility(View.GONE);
		point.setVisibility(View.GONE);
		result.setText(String.valueOf((long)(Double.parseDouble(moneyprint.getString(textid.getText().toString(), "")))));
		textmomey.setText(String.valueOf((long)(Double.parseDouble(momey.getString(textid.getText().toString(), "")) - Double.parseDouble(result.getText().toString()))));
		momey.edit().putString(textid.getText().toString(), textmomey.getText().toString()).commit();
		point.setText(String.valueOf((long)(Double.parseDouble(result.getText().toString()) / 10)));
		textpoint.setText(String.valueOf((long)(Double.parseDouble(point.getText().toString()) + Double.parseDouble(pointsave.getString(textid.getText().toString(), "")))));
		pointsave.edit().putString(textid.getText().toString(), textpoint.getText().toString()).commit();
		moneyprint.edit().putString(textid.getText().toString(), "0").commit();
	}

	@Override
	public void onBackPressed() {
				if ("1".equals(home.getString("homeyes1", ""))) {
					loginid.edit().putString("logyes1", "1").commit();
					go.setClass(getApplicationContext(), MainActivity.class);
					startActivity(go);
					finish();
				}
				else {
					loginid.edit().putString("logyes1", "1").commit();
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
