package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

public class TotalLayout extends LinearLayout {
    
	/** 得点合計 */    
	private CTextView[] playerTotal;
    
	public TotalLayout(Context context) {
		super(context);
		setLayout();
	}
    
	private void setLayout() {
		CTextView total = new CTextView(getContext());
		total.setText(R.string.total);
		addView(total, LayoutParamsUtil.createWidthWeightParams(1));
        
		playerTotal = new CTextView[Constant.SUPPORT_NUMBER];
		for (CTextView tv: playerTotal) {
			tv = new CTextView(getContext());
			addView(tv, LayoutParamsUtil.createWidthWeightParams(2));
		}
        
		CTextView point = new CTextView(getContext());
		point.setText(R.string.point);
		addView(point, LayoutParamsUtil.createWidthWeightParams(1));
	}

}
