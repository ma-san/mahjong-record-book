package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.R;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.widget.LinearLayout;

/**
 * ���O���Ǘ����郌�C�A�E�g�N���X�B
 */
public class NameLayout extends LinearLayout {

	/** �v���C���[�� */
	private CEditText[] playerName;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param context �R���e�L�X�g
	 */
	public NameLayout(Context context) {
		super(context);
		setLayout();
		load();
	}

	/**
	 * ���C�A�E�g��ݒ肷��B
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
	 * ��͓��e���N���A����B
	 */
	public void clear() {
		for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++){
			//playerName[i].getEditableText().clear();
			playerName[i].setText("");
			
		}
	}
	
	   public void load() {
	        for(int i = 0; i < Constant.SUPPORT_NUMBER; i ++){
	            playerName[i].load();
	        }
	    }

}