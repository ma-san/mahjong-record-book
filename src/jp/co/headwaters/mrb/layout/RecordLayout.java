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

		// TODO �ｽX�ｽe�ｽ[�ｽ^�ｽX�ｽo�ｽ[�ｽ�ｽ�ｽ�ｽ�ｽ�ｽonWindow�ｽO�ｽﾉとりた�ｽ�ｽ
//		Rect rect = new Rect();
//		Window window = ((Activity)getContext()).getWindow();
//		window.getDecorView().getWindowVisibleDisplayFrame(rect);
//		int statusBarHeight = rect.bottom;
//		int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
//		int titleBarHeight = contentViewTop - statusBarHeight;
		int rowHeigth = (displaymetrics.heightPixels - Constant.STATUS_BAR_HEIGTH) / Constant.LAYOUT_ROW_NUMBER;
		recordRowLayout = new RecordRowLayout[Constant.PLAY_NUMBER_MAX];
		
		for (int i = 0; i < recordRowLayout.length; i++) {
			recordRowLayout[i] = new RecordRowLayout(getContext(), i + 1);
			mainLayout.addView(
					recordRowLayout[i],
					new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, rowHeigth));
		}
	}
	
	/**
	 * 蜿門ｾ励＠縺溷�､縺ｮ蜷郁ｨ医ｒ霑泌唆縺吶ｋ
	 * @param index
	 * @return 蜷郁ｨ医＠縺溷�､
	 */
	private int calculateTotal(int index){
		int totalCalculation = 0;
		for (RecordRowLayout record : recordRowLayout) {
			totalCalculation += (record.getPlus(index) - record.getMinus(index));
		}
		return totalCalculation;
	}

	public void onChangeRecord(int index){
		int result = calculateTotal(index);
		TotalLayout totalLayout = ((MainActivity)getContext()).getTotalLayout();
		totalLayout.setPlayerTotal(index, result);
	}

}
