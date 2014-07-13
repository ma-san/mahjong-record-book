package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.activity.MainActivity;
import jp.co.headwaters.mrb.constant.Constant;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class RecordLayout extends ScrollView {

	private RecordRowLayout[] recordRowLayout;

	public RecordLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		LinearLayout mainLayout = new LinearLayout(getContext());
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		addView(mainLayout);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

		int rowHeigth = (displaymetrics.heightPixels - Constant.STATUS_BAR_HEIGTH) / Constant.LAYOUT_ROW_NUMBER;
		recordRowLayout = new RecordRowLayout[Constant.PLAY_NUMBER_MAX];
		
		for (int i = 0; i < recordRowLayout.length; i++) {
			recordRowLayout[i] = new RecordRowLayout(getContext(), i + 1);
			mainLayout.addView(
					recordRowLayout[i],
					new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, rowHeigth));
		}
	}
	
	public void calculate() {
		for (RecordRowLayout record : recordRowLayout) {
			record.calculateDifference();
		}
		for (int i = 0; i < Constant.SUPPORT_NUMBER; i ++) {
			onChangeRecord(i);
		}
	}

	/**
	 * 蜿門ｾ励＠縺溷�､縺ｮ蜷郁ｨ医ｒ霑泌唆縺吶ｋ
	 * @param index
	 * @return 蜷郁ｨ医＠縺溷�､
	 */
	private int calculateTotal(int index) {
		int totalCalculation = 0;
		for (RecordRowLayout record : recordRowLayout) {
			totalCalculation += (record.getPlus(index) - record.getMinus(index));
		}
		return totalCalculation;
	}

	/**
	 * レコードが変更した時の処理です。
	 * 
	 * @param index インデックス
	 */
	public void onChangeRecord(int index) {
		int result = calculateTotal(index);
		TotalLayout totalLayout = ((MainActivity)getContext()).getTotalLayout();
		totalLayout.setPlayerTotal(index, result);
		AmountLayout amountLayout = ((MainActivity)getContext()).getAmountLayout();
		amountLayout.calculateAmount(index);
	}
	
	/**
	 * 入力内容をクリアする。
	 */
	public void clear() {
		for(int i = 0; i < Constant.PLAY_NUMBER_MAX; i ++) {
			recordRowLayout[i].clear();
		}
	}
	
    /**
     * 設定値を読み込む。
     */
    public void save() {
		for(int i = 0; i < Constant.PLAY_NUMBER_MAX; i ++) {
			recordRowLayout[i].save();
		}
    }

}
