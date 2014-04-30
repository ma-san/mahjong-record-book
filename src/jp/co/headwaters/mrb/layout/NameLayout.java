package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.widget.LinearLayout;

public class NameLayout extends LinearLayout {

	private CEditText[] playerName;

	public NameLayout(Context context) {
		super(context);
		setLayout();
	}

	private void setLayout() {
		CTextView nameLabel = new CTextView(getContext());
		nameLabel.setText(R.string.player_name);
		addView(nameLabel, LayoutParamsUtil.createWidthWeightParams(1));

		playerName = new CEditText[Constant.SUPPORT_NUMBER];
		for (CEditText et: playerName) {
			et = new CEditText(getContext());
			addView(et, LayoutParamsUtil.createWidthWeightParams(2));
		}
		
		CTextView margin = new CTextView(getContext());
		addView(margin, LayoutParamsUtil.createWidthWeightParams(1));
	}
}