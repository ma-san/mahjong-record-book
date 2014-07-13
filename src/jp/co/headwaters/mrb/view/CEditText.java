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
     * sharedPreferences縺ｮ蜿門ｾ�
     * @param context
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
     * Preferences縺ｮ繧ｭ繝ｼ譁�ｭ怜�繧定ｨｭ螳壹☆繧�
     * 
     * @param key
     */
    public void setKey(String key) {
        this.preferenceskey = key;
    }

    /**
     * 逋ｻ骭ｲ繝��繧ｿ繧堤匳骭ｲ縺吶ｋ
     */
    public void save() {
        if (preferenceskey != null) {
            prefsPrivateEditor.putString(preferenceskey, this.getText().toString());
            prefsPrivateEditor.commit();
        }
    }

    /**
     * 逋ｻ骭ｲ繝��繧ｿ繧定ｪｭ縺ｿ霎ｼ繧�
     */
    public void load() {
        if (preferenceskey != null) {
            String str = sharedPreferences.getString(preferenceskey, "");
            this.setText(str);
        }
    }
}