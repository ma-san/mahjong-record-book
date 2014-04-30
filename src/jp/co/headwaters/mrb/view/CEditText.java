package jp.co.headwaters.mrb.view;

import jp.co.headwaters.mrb.R;
import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;

public class CEditText extends EditText {

	public CEditText(Context context) {
		super(context);
		setBackgroundResource(R.drawable.bg_exit_text);
		setGravity(Gravity.CENTER);
	}

}