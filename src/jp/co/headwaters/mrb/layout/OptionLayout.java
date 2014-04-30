package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.widget.LinearLayout;

public class OptionLayout extends LinearLayout {

	public OptionLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		CTextView recordClear = new CTextView(getContext());
		recordClear.setBackgroundResource(R.drawable.bg_exit_text);
		recordClear.setText(R.string.record_clear);
		addView(recordClear, LayoutParamsUtil.createWidthWeightParams(3)); 
		
		CTextView margin = new CTextView(getContext());
		addView(margin, LayoutParamsUtil.createWidthWeightParams(6));

		CTextView allClear = new CTextView(getContext());
		allClear.setBackgroundResource(R.drawable.bg_exit_text);
		allClear.setText(R.string.all_clear);
		addView(allClear, LayoutParamsUtil.createWidthWeightParams(3)); 
	}

}