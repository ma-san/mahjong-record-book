package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

/**
 * 合計を管理するレイアウトクラス。
 */
public class TotalLayout extends LinearLayout {
    
	/** プレイヤー合計 */
	private CTextView[] playerTotal;
    
	/**
	 * コンストラクタ
	 * 
	 * @param context コンテキスト
	 */
	public TotalLayout(Context context) {
		super(context);
		setLayout();
	}
    
	/**
	 * レイアウトを設定する。
	 */
	private void setLayout() {
		CTextView total = new CTextView(getContext());
		total.setText(R.string.total);
		addView(total, LayoutParamsUtil.createWidthWeightParams(1));
        
		playerTotal = new CTextView[Constant.SUPPORT_NUMBER];
		for (int i = 0; i < playerTotal.length; i++) {
			playerTotal[i] = new CTextView(getContext());
			addView(playerTotal[i], LayoutParamsUtil.createWidthWeightParams(2));
		}
        
		CTextView point = new CTextView(getContext());
		point.setText(R.string.point);
		addView(point, LayoutParamsUtil.createWidthWeightParams(1));
	}
    
	/**
	 * プレイヤー合計を設定する。
	 *
	 * @param index インデックス
	 * @return プレイヤー合計
	 */
	public int getPlayerTotal(int index) {
        
		int result = 0;
        
		try {
			result = Integer.parseInt(playerTotal[index].getText().toString());
		} catch (NumberFormatException e) {
			result = 0;
		}
        
		return result;
	}
    
	/**
	 * プレイヤー合計を取得する。
	 *
	 * @param index インデックス
	 * @param value 設定値
	 */
	public void setPlayerTotal(int index, int value) {
		
		playerTotal[index].setText(Integer.toString(value));
        
		if(value >= 0) {
			playerTotal[index].setTextColor(Color.BLACK);
		}
		else {
			playerTotal[index].setTextColor(Color.RED);
		}
	}
    
}



