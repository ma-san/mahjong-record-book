package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.text.InputType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AmountLayout extends LinearLayout {

	private CTextView[] playerAmount;
	private CEditText point;

	public AmountLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		CTextView amount = new CTextView(getContext());
		amount.setText(R.string.amount);
		addView(amount, LayoutParamsUtil.createWidthWeightParams(1)); 

		playerAmount = new CTextView[Constant.SUPPORT_NUMBER];
		for (TextView tv: playerAmount) {
			tv = new CTextView(getContext());
			addView(tv, LayoutParamsUtil.createWidthWeightParams(2)); 
		}
		
		point = new CEditText(getContext());
		point.setInputType(InputType.TYPE_CLASS_NUMBER);
		addView(point, LayoutParamsUtil.createWidthWeightParams(1)); 
	}

}