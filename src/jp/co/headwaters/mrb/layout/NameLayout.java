package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

/**
 * 名前を表示するレイアウト
 */
public class NameLayout extends LinearLayout implements TextWatcher {

	/** 名前 */
	private CEditText[] playerName;

	/**
	 * コンストラクタ
	 * 
	 * @param context コンテキスト
	 */
	public NameLayout(Context context) {
		super(context);
		setLayout();
		load();
        setListener();
	}

	/**
	 * レイアウトを設定する
	 */
	private void setLayout() {
		CTextView nameLabel = new CTextView(getContext());
		nameLabel.setText(R.string.player_name);
		addView(nameLabel, LayoutParamsUtil.createWidthWeightParams(1));

		playerName = new CEditText[Constant.SUPPORT_NUMBER];
		for (int i = 0; i < playerName.length; i++) {
			playerName[i] = new CEditText(getContext());
			playerName[i].setKey("playerName_" + i);
			addView(playerName[i], LayoutParamsUtil.createWidthWeightParams(2));
		}
		
		CTextView margin = new CTextView(getContext());
		addView(margin, LayoutParamsUtil.createWidthWeightParams(1));
	}
	
    /**
     * 
     */
    private void setListener() {
    	for (CEditText et: playerName) {
    		et.addTextChangedListener(this);
    	}
    }
	
	/**
	 * 
	 */
	public void clear() {
		for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++) {
			playerName[i].setText("");
		}
	}
	
    /**
     * 設定値を読み込む。
     */
    public void save() {
        for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++) {
            playerName[i].save();
        }
    }
	
	/**
	 */
	public void load() {
		for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++){
			playerName[i].load();
		}
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void afterTextChanged(Editable s) {
		CEditText et = getFocusText();
		if (null != et) {
			et.save();
		}
	}
	
    /**
     */
    public CEditText getFocusText() {
    	for (CEditText et: playerName) {
    		if (et.isFocused()) {
    			return et;
    		}
    	}
    	return null;
    }

}