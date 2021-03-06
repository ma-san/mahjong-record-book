package jp.co.headwaters.mrb.layout;

import java.text.DecimalFormat;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.activity.MainActivity;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.LinearLayout;

/**
 * 額を管理するレイアウトクラス。
 */
public class AmountLayout extends LinearLayout implements TextWatcher{
    
	/**　額基数　*/
	private static int AMOUNT_BASIS = 10;
	/**　額フォーマット　*/
	private static DecimalFormat AMOUNT_FORMAT = new DecimalFormat("#,###");

	/** 額 */
	private CTextView[] playerAmount;
	/** 点 */
	private CEditText point;
    
	/**
	 * コンストラクタ
	 * 
	 * @param context コンテキスト
	 */
	public AmountLayout(Context context) {
		super(context);
		setLayout();
		load();
		setListener();
    }
    
	/**
	 * レイアウトを設定する。
	 */
	private void setLayout() {
		CTextView amount = new CTextView(getContext());
		amount.setText(R.string.amount);
		addView(amount, LayoutParamsUtil.createWidthWeightParams(1));
        
		playerAmount = new CTextView[Constant.SUPPORT_NUMBER];
		for (int i = 0; i < playerAmount.length; i++) {
			playerAmount[i] = new CTextView(getContext());
			addView(playerAmount[i], LayoutParamsUtil.createWidthWeightParams(2));
		}
		
		point = new CEditText(getContext());
		point.setText("5");
		point.setKey("point");
		point.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		addView(point, LayoutParamsUtil.createWidthWeightParams(1));
	}
    
	@Override
	public void afterTextChanged(Editable s) {
	}
    
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		point.save();
		calculateAmount();
	}
    
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}
	
	/**
	 * リスナーを設定する。
	 */
	private void setListener() {
		point.addTextChangedListener(this);
	}
	
	/**
	 * 額を算出する。
	 */
	private void calculateAmount() {
		for (int i=0; i<Constant.SUPPORT_NUMBER; i++) {
			calculateAmount(i);
		}
	}

	public void calculateAmount(int index) {
		int pointAmount = 0;
		try {
			pointAmount = Integer.parseInt(point.getText().toString()) * AMOUNT_BASIS;
		} catch (NumberFormatException e) {
			pointAmount = 0;
		}
		int amount = ((MainActivity)getContext()).getTotalLayout().getPlayerTotal(index) * pointAmount;
		playerAmount[index].setText(AMOUNT_FORMAT.format(amount));			
		if (0 <= amount) {
			playerAmount[index].setTextColor(Color.BLACK);
		} else {
			playerAmount[index].setTextColor(Color.RED);
		}
	}

	/**
	 * 設定値を読み込む。
	 */
	public void load() {
		point.load();
		if (0 == point.getText().length()) {
			clear();
		}
	}

	/**
	 * 入力内容をクリアする。
	 */
	public void clear() {
		point.setText("5");
	}
	
	public void save() {
        point.save();
    }

}