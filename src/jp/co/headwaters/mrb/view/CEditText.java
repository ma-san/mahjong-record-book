package jp.co.headwaters.mrb.view;

import jp.co.headwaters.mrb.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Gravity;
import android.widget.EditText;

public class CEditText extends EditText {

    private SharedPreferences sharedPreferences;
    private String preferenceskey = null;
    private Editor prefsPrivateEditor;

    /**
     * コンストラクタ
     * 
     * @param context コンテキスト
     */
    public CEditText(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg_exit_text);
        setGravity(Gravity.CENTER);
		setTextSize(16);

        sharedPreferences = context.getSharedPreferences("preferencesName", Context.MODE_PRIVATE);
        prefsPrivateEditor = sharedPreferences.edit();
    }

    /**
     * 保存キーを設定する。
     * 
     * @param key 保存キー
     */
    public void setKey(String key) {
        this.preferenceskey = key;
    }

    /**
     * 設定値を保存します。
     */
    public void save() {
        if (preferenceskey != null) {
            prefsPrivateEditor.putString(preferenceskey, this.getText().toString());
            prefsPrivateEditor.commit();
        }
    }

    /**
     * 保存値を読み込みます。
     */
    public void load() {
        if (preferenceskey != null) {
            String str = sharedPreferences.getString(preferenceskey, "");
            this.setText(str);
        }
    }
}