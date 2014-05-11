package jp.co.headwaters.mrb.layout;

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

    private CTextView playNumber;
    private CEditText[] plus;
    private CEditText[] minus;
    private CTextView difference;

    public RecordRowLayout(Context context) {
        super(context);
        setLayout();
        setListener();
    }

    private void setLayout() {
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        addView(mainLayout);

        playNumber = new CTextView(getContext());
        addView(playNumber, LayoutParamsUtil.createWidthWeightParams(1));

        plus = new CEditText[Constant.SUPPORT_NUMBER];
        minus = new CEditText[Constant.SUPPORT_NUMBER];
        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            plus[i] = new CEditText(getContext());
            plus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            addView(plus[i], LayoutParamsUtil.createWidthWeightParams(1));

            minus[i] = new CEditText(getContext());
            minus[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            addView(minus[i], LayoutParamsUtil.createWidthWeightParams(1));
        }

        difference = new CTextView(getContext());
        addView(difference, LayoutParamsUtil.createWidthWeightParams(1));
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber.setText(playNumber);
    }

    private void setListener() {
        for (int i = 0; i < Constant.SUPPORT_NUMBER; i++) {
            plus[i].addTextChangedListener(this);
            minus[i].addTextChangedListener(this);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO 自動生成されたメソッド・スタブ
        calculateDifference();
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

}