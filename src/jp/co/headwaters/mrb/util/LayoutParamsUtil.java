package jp.co.headwaters.mrb.util;

import android.widget.LinearLayout;


public class LayoutParamsUtil {
	
	public static LinearLayout.LayoutParams createWidthWeightParams(float weight) {
		return new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, weight);
	}

	public static LinearLayout.LayoutParams createHeigthWeightParams(float weight) {
		return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, weight);
	}

}
