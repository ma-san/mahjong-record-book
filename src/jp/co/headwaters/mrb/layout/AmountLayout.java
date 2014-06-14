package jp.co.headwaters.mrb.layout;

import java.text.DecimalFormat;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.activity.MainActivity;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AmountLayout extends LinearLayout implements TextWatcher{
    
	private CTextView[] playerAmount;
	private CEditText point;
    
	public AmountLayout(Context context) {
		super(context);
		setLayout();
        //	calculatedAmount();
	}
    
	private void setLayout() {
		CTextView amount = new CTextView(getContext());
		amount.setText(R.string.amount);
		addView(amount, LayoutParamsUtil.createWidthWeightParams(1));
        
		playerAmount = new CTextView[Constant.SUPPORT_NUMBER];
		for (TextView tv: playerAmount) {
			tv = new CTextView(getContext());
			addView(tv, LayoutParamsUtil.createWidthWeightParams(2));
		}
		
		point = new CEditText(getContext());
		point.setInputType(InputType.TYPE_CLASS_NUMBER);
		addView(point, LayoutParamsUtil.createWidthWeightParams(1));
	}
    
	@Override
	public void afterTextChanged(Editable s) {
	}
    
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
		calculatedAmount();
        
		
	}
    
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		calculatedAmount();
        
    }
	
	/**
	 *リスナを登録する
	 */
	private void setListener() {
		point.addTextChangedListener(this);
	}
	
	/**
	 * 額を算出
	 */
	private void calculatedAmount() {
		TotalLayout totalLayout = ((MainActivity)getContext()).getTotalLayout();
		
		int index = 0;
		for(int i=0; i < Constant.SUPPORT_NUMBER; i++){
			index = Integer.parseInt(point.getText().toString())*10;
		}
		
		int amount = (totalLayout.getPlayerTotal(0) * index);
        
		DecimalFormat formatter = new DecimalFormat("#,###");
		String result = formatter.format(amount);
		
		playerAmount[index].setText(result);
		
        if(amount >= 0) {
            playerAmount[index].setTextColor(Color.BLACK);
        }
        else {
            playerAmount[index].setTextColor(Color.RED);
        }
		
	}
    
}