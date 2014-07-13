package jp.co.headwaters.mrb.view;

import jp.co.headwaters.mrb.R;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

public class CTextView extends TextView {

	public CTextView(Context context) {
		super(context);
		setBackgroundResource(R.drawable.bg_text_view);
		setGravity(Gravity.CENTER);
		setTextColor(0xff4169e1);
		setTextSize(16);
	}

}