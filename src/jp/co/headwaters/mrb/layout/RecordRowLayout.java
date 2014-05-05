package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.text.InputType;
import android.widget.LinearLayout;

public class RecordRowLayout extends LinearLayout {

	private CTextView playNumber;
	private CEditText[] plus;
	private CEditText[] minus;
	private CTextView difference;

	public RecordRowLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		LinearLayout mainLayout = new LinearLayout(getContext());
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		addView(mainLayout);

		playNumber = new CTextView(getContext());
		addView(playNumber, LayoutParamsUtil.createWidthWeightParams(1)); 

		plus = new CEditText[Constant.SUPPORT_NUMBER];
		minus = new CEditText[Constant.SUPPORT_NUMBER];
		for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
			plus[i] = new CEditText(getContext());
			plus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
			addView(plus[i], LayoutParamsUtil.createWidthWeightParams(1));

			minus[i] = new CEditText(getContext());
			minus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
			addView(minus[i], LayoutParamsUtil.createWidthWeightParams(1));
		}

		difference = new CTextView(getContext());
		addView(difference, LayoutParamsUtil.createWidthWeightParams(1));
	}

	public void setPlayNumber(String playNumber) {
	}

}