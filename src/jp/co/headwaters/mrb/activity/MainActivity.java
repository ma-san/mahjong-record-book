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

	/**  */
	private NameLayout nameLayout;
	/**  */
	private RecordLayout recordLayout;
	/**  */
	private TotalLayout totalLayout;
	/**  */
	private AmountLayout amountLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setLayout();
		calculate();
	}

	private void setLayout() {
		LinearLayout mainLayout = new LinearLayout(this);
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(mainLayout);
		
		nameLayout = new NameLayout(this);
		mainLayout.addView(nameLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		SymbolLayout symbolLayout = new SymbolLayout(this);
		mainLayout.addView(symbolLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		recordLayout = new RecordLayout(this);
		mainLayout.addView(recordLayout, LayoutParamsUtil.createHeigthWeightParams(3));
		
		totalLayout = new TotalLayout(this);
		mainLayout.addView(totalLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		amountLayout = new AmountLayout(this);
		mainLayout.addView(amountLayout, LayoutParamsUtil.createHeigthWeightParams(1));

		OptionLayout optionLayout = new OptionLayout(this);
		mainLayout.addView(optionLayout, LayoutParamsUtil.createHeigthWeightParams(1));
	}

	/**
	 */
	public NameLayout getNameLayout() {
		return nameLayout;
	}
	
	/**
	 */
	public RecordLayout getRecordLayout() {
		return recordLayout;
	}
	
	/**
	 */
	public TotalLayout getTotalLayout() {
		return totalLayout;
	}

	/**
	 */
	public AmountLayout getAmountLayout() {
		return amountLayout;
	}
	
	/**
	 * 算出
	 */
	private void calculate() {
		recordLayout.calculate();
	}

}
