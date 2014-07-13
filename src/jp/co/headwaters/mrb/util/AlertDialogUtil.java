package jp.co.headwaters.mrb.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class AlertDialogUtil extends AlertDialog.Builder {
	
	public static final DialogInterface.OnClickListener NO_ACTION_LISTENER = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
		}
	};
	
	public AlertDialogUtil(Context context) {
		super(context);
	}
	
	public void showWantToInit(DialogInterface.OnClickListener yes) {
		showYesNoDialog("èâä˙âªÇµÇ‹Ç∑Ç©ÅH", yes, NO_ACTION_LISTENER);	
	}
		
	public void showYesNoDialog(String message, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no) {
		setMessage(message);
		setPositiveButton("ÇÕÇ¢", yes);
		setNegativeButton("Ç¢Ç¢Ç¶", no);
		create();
		show();
	}

}