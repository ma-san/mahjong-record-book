package jp.co.headwaters.mrb.view;

import java.util.Map;
import java.util.Set;

import jp.co.headwaters.mrb.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.EditText;

public class CEditText extends EditText {

    String key = null;
    SharedPreferences sharedPreferences;
    Context context;
    Editor prefsPrivateEditor;
    
    public CEditText(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg_exit_text);
        setGravity(Gravity.CENTER);

        this.context = context;
        
        //sharedPreferencesの取得
        sharedPreferences = context.getSharedPreferences("preferencesName",
                Context.MODE_PRIVATE);
        prefsPrivateEditor = sharedPreferences.edit();
    }

    //Preferencesのキー文字列を設定する
    public void setKey(String key) {
        this.key = key;
    }

    //登録データを登録する
    public void save() {
        if (key != null) {
            prefsPrivateEditor.putString(key, this.getText().toString());
            prefsPrivateEditor.commit();
        }
    }

    //登録データを読み込む
    public void load() {
        if (key != null) {
            String str = sharedPreferences.getString(key, "");
            this.setText(str);
        }
    }
}