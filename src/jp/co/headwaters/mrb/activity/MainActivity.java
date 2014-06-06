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

	/** 名前レイアウト */
	private NameLayout nameLayout;
	/** 記録レイアウト */
	private RecordLayout recordLayout;
	/** 合計レイアウト */
	private TotalLayout totalLayout;
	/** 額レイアウト */
	private AmountLayout amountLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setLayout();
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
	 * 名前レイアウトを取得する。
	 * 
	 * @return 名前レイアウト
	 */
	public NameLayout getNameLayout() {
		return nameLayout;
	}
	
	/**
	 * 記録レイアウトを取得する。
	 * 
	 * @return 記録レイアウト
	 */
	public RecordLayout getRecordLayout() {
		return recordLayout;
	}
	
	/**
	 * 合計レイアウトを取得する。
	 * 
	 * @return 合計レイアウト
	 */
	public TotalLayout getTotalLayout() {
		return totalLayout;
	}

	/**
	 * 額レイアウトを取得する。
	 * 
	 * @return 額レイアウト
	 */
	public AmountLayout getAmountLayout() {
		return amountLayout;
	}

}
