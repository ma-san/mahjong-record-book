package jp.co.headwaters.mrb.layout;

import jp.co.headwaters.mrb.activity.MainActivity;
import jp.co.headwaters.mrb.constant.Constant;
import jp.co.headwaters.mrb.util.LayoutParamsUtil;
import jp.co.headwaters.mrb.view.CEditText;
import jp.co.headwaters.mrb.view.CTextView;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.LinearLayout;

public class RecordRowLayout extends LinearLayout implements TextWatcher {

    private int playNumber;
    private CEditText[] plus;
    private CEditText[] minus;
    private CTextView difference;

    // private int result = 0;
    // private int position = 0;

    public RecordRowLayout(Context context, int playNumber) {
        super(context);
        this.playNumber = playNumber;
        setLayout();
        setListener();
        load();
    }

    private void setLayout() {
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        addView(mainLayout);

        CTextView playNumber = new CTextView(getContext());
        playNumber.setText(String.valueOf(this.playNumber));
        addView(playNumber, LayoutParamsUtil.createWidthWeightParams(1));

        plus = new CEditText[Constant.SUPPORT_NUMBER];
        minus = new CEditText[Constant.SUPPORT_NUMBER];
        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            plus[i] = new CEditText(getContext());
            plus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            plus[i].setKey(this.playNumber + "_plus_" + i);
            addView(plus[i], LayoutParamsUtil.createWidthWeightParams(1));

            minus[i] = new CEditText(getContext());
            minus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            minus[i].setKey(this.playNumber + "_minus_" + i);
            addView(minus[i], LayoutParamsUtil.createWidthWeightParams(1));
        }

        difference = new CTextView(getContext());
        addView(difference, LayoutParamsUtil.createWidthWeightParams(1));
    }

    private void setListener() {
        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            plus[i].addTextChangedListener(this);
            minus[i].addTextChangedListener(this);
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
        calculateDifference();

        CEditText cet = getFocusText();

        if (null != cet) {
            cet.save();
            RecordLayout recordLayout = ((MainActivity) getContext()).getRecordLayout();
            int result = getArrayIndex(cet);
            recordLayout.onChangeRecord(result);
        }
    }

    public void calculateDifference() {

        int plusToValue;
        int minusToValue;

        int answer = 0;

        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            String plusStr = plus[i].getText().toString();
            String minusStr = minus[i].getText().toString();

            try {
                plusToValue = Integer.parseInt(plusStr);
            } catch (NumberFormatException e) {
                plusToValue = 0;
            }

            try {
                minusToValue = Integer.parseInt(minusStr);
            } catch (NumberFormatException e) {
                minusToValue = 0;
            }
            answer += plusToValue + (-minusToValue);
        }

        difference.setText(String.valueOf(answer));

    }

    /**
     * プラス値を取得する
     * 
     * @param index
     * @return CEditTextの設定値
     */
    public int getPlus(int index) {
        int result = 0;
        try {
            result = Integer.parseInt(plus[index].getText().toString());
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    /**
     * マイナス値を取得する
     * 
     * @param index
     * @return CEditTextの設定値
     */
    public int getMinus(int index) {
        int result = 0;
        try {
            result = Integer.parseInt(minus[index].getText().toString());
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    /**
     * フォーカスがあるCEditTextを取得する
     * 
     * @return フォーカスがあたっているCEditText
     */
    public CEditText getFocusText() {

        CEditText resultFocus = null;
        boolean minusFocus;
        boolean plusFocus;

        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {

            plusFocus = plus[i].isFocused();
            minusFocus = minus[i].isFocused();

            if (plusFocus == true) {
                resultFocus = plus[i];
                return resultFocus;
            } else if (minusFocus == true) {
                resultFocus = minus[i];
                return resultFocus;
            } else {
                resultFocus = null;
            }
        }
        return resultFocus;
    }

    /**
     * 対象ビューの配列位置を取得する
     * 
     * @param et
     * @return 配列値を返却
     */
    public int getArrayIndex(CEditText et) {
        int result = 0;

        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            if (plus[i] == et || minus[i] == et) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void load() {
        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            plus[i].load();
            minus[i].load();
        }
    }
}