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
     * sharedPreferencesの取得
     * @param context
     */
    public CEditText(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg_exit_text);
        setGravity(Gravity.CENTER);

        sharedPreferences = context.getSharedPreferences("preferencesName", Context.MODE_PRIVATE);
        prefsPrivateEditor = sharedPreferences.edit();
    }

    /**
     * Preferencesのキー文字列を設定する
     * 
     * @param key
     */
    public void setKey(String key) {
        this.preferenceskey = key;
    }

    /**
     * 登録データを登録する
     */
    public void save() {
        if (preferenceskey != null) {
            prefsPrivateEditor.putString(preferenceskey, this.getText().toString());
            prefsPrivateEditor.commit();
        }
    }

    /**
     * 登録データを読み込む
     */
    public void load() {
        if (preferenceskey != null) {
            String str = sharedPreferences.getString(preferenceskey, "");
            this.setText(str);
        }
    }
}