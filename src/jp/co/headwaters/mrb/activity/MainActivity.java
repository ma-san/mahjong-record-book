package jp.co.headwaters.mrb.activity;

import jp.co.headwaters.mrb.layout.AmountLayout;
import jp.co.headwaters.mrb.layout.NameLayout;
import jp.co.headwaters.mrb.layout.OptionLayout;
import jp.co.headwaters.mrb.layout.RecordLayout;
import jp.co.headwaters.mrb.layout.SymbolLayout;
import jp.co.headwaters.mrb.layout.TotalLayout;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setLayout();
	}

	private void setLayout() {
		LinearLayout mainLayout = new LinearLayout(this);
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(mainLayout);
		
		NameLayout nameLayout = new NameLayout(this);
		mainLayout.addView(nameLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		SymbolLayout symbolLayout = new SymbolLayout(this);
		mainLayout.addView(symbolLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		RecordLayout recordLayout = new RecordLayout(this);
		mainLayout.addView(recordLayout, LayoutParamsUtil.createHeigthWeightParams(3));
		
		TotalLayout totalLayout = new TotalLayout(this);
		mainLayout.addView(totalLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		AmountLayout amountLayout = new AmountLayout(this);
		mainLayout.addView(amountLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		OptionLayout optionLayout = new OptionLayout(this);
		mainLayout.addView(optionLayout, LayoutParamsUtil.createHeigthWeightParams(1));
	}

}
