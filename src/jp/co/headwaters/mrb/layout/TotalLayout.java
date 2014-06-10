package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

public class TotalLayout extends LinearLayout {
    
	private CTextView[] playerAmount;
    
	public TotalLayout(Context context) {
		super(context);
		setLayout();
	}
    
	private void setLayout() {
		CTextView total = new CTextView(getContext());
		total.setText(R.string.total);
		addView(total, LayoutParamsUtil.createWidthWeightParams(1));
        
		playerAmount = new CTextView[Constant.SUPPORT_NUMBER];
		for (CTextView tv: playerAmount) {
			tv = new CTextView(getContext());
			addView(tv, LayoutParamsUtil.createWidthWeightParams(2));
		}
        
		CTextView point = new CTextView(getContext());
		point.setText(R.string.point);
		addView(point, LayoutParamsUtil.createWidthWeightParams(1));
	}
	
	/**
	 * インスタンス変数のplayerAmountから
	 * 引数インデックスの配列位置にあるCTextViewの設定値を数値に変換して返却する。
	 *
	 * @param index インデックス
	 * @return plyaerAmoountの設定値
	 */
	public int getPlayerAmount(int index) {
		
		int result = 0;
		
		try {
			result = Integer.parseInt(playerAmount[index].getText().toString());
		} catch (NumberFormatException e) {
			result = 0;
		}
		
		return result;
	}
	
	public void setPlayerAmount(int index, int value) {
        
		if(value >= 0) {
			playerAmount[index].setTextColor(Color.BLACK);
		}
		else {
			playerAmount[index].setTextColor(Color.RED);
		}
	}
}