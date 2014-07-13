package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.activity.MainActivity;
import jp.co.headwaters.mrb.util.AlertDialogUtil;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;

public class OptionLayout extends LinearLayout {
	
	private AlertDialogUtil alertDialogUtil;
	private CTextView recordClear;
	private CTextView allClear;

	public OptionLayout(Context context) {
		super(context);
		alertDialogUtil = new AlertDialogUtil(context);
		setLayout();
		setListener();
	}

	private void setLayout() {
		recordClear = new CTextView(getContext());
		recordClear.setBackgroundResource(R.drawable.bg_exit_text);
		recordClear.setText(R.string.record_clear);
		addView(recordClear, LayoutParamsUtil.createWidthWeightParams(3)); 
		
		CTextView margin = new CTextView(getContext());
		addView(margin, LayoutParamsUtil.createWidthWeightParams(6));

		allClear = new CTextView(getContext());
		allClear.setBackgroundResource(R.drawable.bg_exit_text);
		allClear.setText(R.string.all_clear);
		addView(allClear, LayoutParamsUtil.createWidthWeightParams(3)); 
	}
	
	/**
	 * リスナーを設定する。
	 */
	private void setListener() {
		recordClear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				alertDialogUtil.showWantToInit(new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int whichButton) {
						initRecord();
					}
				});
			}
		});
	}
	
	/**
	 * 点集を初期化します。
	 */
	private void initRecord() {
		RecordLayout recordLayout = ((MainActivity)getContext()).getRecordLayout();
		recordLayout.clear();
		recordLayout.save();
		recordLayout.calculate();
	}

}