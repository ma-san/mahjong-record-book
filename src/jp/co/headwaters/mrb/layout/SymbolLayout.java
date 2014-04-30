package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.widget.LinearLayout;

public class SymbolLayout extends LinearLayout {

	public SymbolLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		CTextView playNumber = new CTextView(getContext());
		playNumber.setText(R.string.play_number);
		addView(playNumber, LayoutParamsUtil.createWidthWeightParams(1));

		for (int i = 0; i < Constant.SUPPORT_NUMBER * 2; i++) {
			CTextView tv = new CTextView(getContext());
			if (i % 2 == 0) {
				tv.setText(R.string.plus);
			} else {
				tv.setText(R.string.minus);
			}
			addView(tv, LayoutParamsUtil.createWidthWeightParams(1));
		}
		
		CTextView difference = new CTextView(getContext());
		difference.setText(R.string.difference);
		addView(difference, LayoutParamsUtil.createWidthWeightParams(1));
	}
}