package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.widget.LinearLayout;

/**
 * 名前を管理するレイアウトクラス。
 */
public class NameLayout extends LinearLayout {

	/** プレイヤー名 */
	private CEditText[] playerName;

	/**
	 * コンストラクタ
	 * 
	 * @param context コンテキスト
	 */
	public NameLayout(Context context) {
		super(context);
		setLayout();
	}

	/**
	 * レイアウトを設定する。
	 */
	private void setLayout() {
		CTextView nameLabel = new CTextView(getContext());
		nameLabel.setText(R.string.player_name);
		addView(nameLabel, LayoutParamsUtil.createWidthWeightParams(1));

		playerName = new CEditText[Constant.SUPPORT_NUMBER];
		for (int i = 0; i < playerName.length; i++) {
			playerName[i] = new CEditText(getContext());
			addView(playerName[i], LayoutParamsUtil.createWidthWeightParams(2));
		}
		
		CTextView margin = new CTextView(getContext());
		addView(margin, LayoutParamsUtil.createWidthWeightParams(1));
	}
	
	/**
	 * 入力内容をクリアする。
	 */
	public void clear() {
		for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++){
			//playerName[i].getEditableText().clear();
			playerName[i].setText("");
			
		}
	}
}