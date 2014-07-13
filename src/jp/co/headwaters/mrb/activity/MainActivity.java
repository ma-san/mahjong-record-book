package jp.co.headwaters.mrb.activity;

import jp.co.headwaters.mrb.layout.AmountLayout;
import jp.co.headwaters.mrb.layout.NameLayout;
import jp.co.headwaters.mrb.layout.OptionLayout;
import jp.co.headwaters.mrb.layout.RecordLayout;
import jp.co.headwaters.mrb.layout.SymbolLayout;
import jp.co.headwaters.mrb.layout.TotalLayout;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	/** 蜷榊燕繝ｬ繧､繧｢繧ｦ繝� */
	private NameLayout nameLayout;
	/** 險倬鹸繝ｬ繧､繧｢繧ｦ繝� */
	private RecordLayout recordLayout;
	/** 蜷郁ｨ医Ξ繧､繧｢繧ｦ繝� */
	private TotalLayout totalLayout;
	/** 鬘阪Ξ繧､繧｢繧ｦ繝� */
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
	 * 蜷榊燕繝ｬ繧､繧｢繧ｦ繝医ｒ蜿門ｾ励☆繧九��
	 * 
	 * @return 蜷榊燕繝ｬ繧､繧｢繧ｦ繝�
	 */
	public NameLayout getNameLayout() {
		return nameLayout;
	}
	
	/**
	 * 險倬鹸繝ｬ繧､繧｢繧ｦ繝医ｒ蜿門ｾ励☆繧九��
	 * 
	 * @return 險倬鹸繝ｬ繧､繧｢繧ｦ繝�
	 */
	public RecordLayout getRecordLayout() {
		return recordLayout;
	}
	
	/**
	 * 蜷郁ｨ医Ξ繧､繧｢繧ｦ繝医ｒ蜿門ｾ励☆繧九��
	 * 
	 * @return 蜷郁ｨ医Ξ繧､繧｢繧ｦ繝�
	 */
	public TotalLayout getTotalLayout() {
		return totalLayout;
	}

	/**
	 * 鬘阪Ξ繧､繧｢繧ｦ繝医ｒ蜿門ｾ励☆繧九��
	 * 
	 * @return 鬘阪Ξ繧､繧｢繧ｦ繝�
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
