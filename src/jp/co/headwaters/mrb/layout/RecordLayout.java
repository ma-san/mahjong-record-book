package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class RecordLayout extends ScrollView {

	private CEditText[][] plus;
	private CEditText[][] minus;
	private CTextView[] difference;

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

		plus = new CEditText[Constant.PLAY_NUMBER_MAX][Constant.SUPPORT_NUMBER];
		minus = new CEditText[Constant.PLAY_NUMBER_MAX][Constant.SUPPORT_NUMBER];
		difference = new CTextView[Constant.PLAY_NUMBER_MAX];
		// TODO ステータスバー高さをonWindow前にとりたい
//		Rect rect = new Rect();
//		Window window = ((Activity)getContext()).getWindow();
//		window.getDecorView().getWindowVisibleDisplayFrame(rect);
//		int statusBarHeight = rect.bottom;
//		int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
//		int titleBarHeight = contentViewTop - statusBarHeight;
		
		for (int i = 0; i < Constant.PLAY_NUMBER_MAX; i++) {
			LinearLayout playLayout = new LinearLayout(getContext());
			mainLayout.addView(
					playLayout,
					new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.MATCH_PARENT,
							(displaymetrics.heightPixels - Constant.STATUS_BAR_HEIGTH) / Constant.LAYOUT_ROW_NUMBER));

			CTextView playNumber = new CTextView(getContext());
			playNumber.setText(String.valueOf(i + 1));
			playLayout.addView(playNumber, LayoutParamsUtil.createWidthWeightParams(1)); 

			for (int j = 0; j < Constant.SUPPORT_NUMBER; j++) {
				plus[i][j] = new CEditText(getContext());
				plus[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
				playLayout.addView(plus[i][j], LayoutParamsUtil.createWidthWeightParams(1));

				minus[i][j] = new CEditText(getContext());
				minus[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
				playLayout.addView(minus[i][j], LayoutParamsUtil.createWidthWeightParams(1));
			}

			difference[i] = new CTextView(getContext());
			playLayout.addView(difference[i], LayoutParamsUtil.createWidthWeightParams(1));
		}
	}
	
}