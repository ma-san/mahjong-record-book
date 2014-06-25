package jp.co.headwaters.mrb.layout;

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

		// TODO �X�e�[�^�X�o�[������onWindow�O�ɂƂ肽��
//		Rect rect = new Rect();
//		Window window = ((Activity)getContext()).getWindow();
//		window.getDecorView().getWindowVisibleDisplayFrame(rect);
//		int statusBarHeight = rect.bottom;
//		int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
//		int titleBarHeight = contentViewTop - statusBarHeight;
		int rowHeigth = (displaymetrics.heightPixels - Constant.STATUS_BAR_HEIGTH) / Constant.LAYOUT_ROW_NUMBER;
		recordRowLayout = new RecordRowLayout[Constant.PLAY_NUMBER_MAX];
		
		for (int i = 0; i < recordRowLayout.length; i++) {
			recordRowLayout[i] = new RecordRowLayout(getContext());
			recordRowLayout[i].setPlayNumber(String.valueOf(i + 1));
			mainLayout.addView(
					recordRowLayout[i],
					new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, rowHeigth));
		}
	}
	
	/**
	 * 取得した値の合計を返却する
	 * @param index
	 * @return 合計した値
	 */
	private int calculateTotal(int index){

	    RecordRowLayout record = new RecordRowLayout(getContext());
	    int recordPlus = record.getPlus(index);
	    int recordMinus = record.getMinus(index);

	    int totalCalculation = recordPlus + (-recordMinus);
	    
	    return totalCalculation;
	}

	public void onChangeRecord(int index){
		int result = calculateTotal(index);
		TotalLayout totalLayout = ((MainActivity)getContext()).getTotalLayout();
		totalLayout.setPlayerTotal(index, result);
	}

}
