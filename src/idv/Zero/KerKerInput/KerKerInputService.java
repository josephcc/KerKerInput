package idv.Zero.KerKerInput;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.inputmethodservice.*;
import android.net.Uri;
import android.os.Handler;
import android.view.*;

public class KerKerInputService extends InputMethodService {
	private String updateServiceURL = "http://zero.itszero.info/KerKerInput/version.dat";
	private KerKerInputCore _core = null;
	
	public KerKerInputService()
	{
		super();
		// android.os.Debug.waitForDebugger();
		
		// invokeVersionCheck();
		_core = new KerKerInputCore(this);
	}
	
	@Override
	public void onInitializeInterface()
	{
		_core.initCore();
	}
	
	@Override
	public View onCreateInputView()
	{
		return _core.requestInputView();
	}
	
	@Override
	public View onCreateCandidatesView()
	{
		return _core.requestCandidatesView();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent e)
	{
		if (!_core.onKeyDown(generateVKBCode(e), e))
			return super.onKeyDown(keyCode, e);
		else
			return true;
	}
	
	@Override
	public boolean onKeyMultiple(int keyCode, int count, KeyEvent e)
	{
		if (!_core.onKeyMultiple(generateVKBCode(e), count, e))
			return super.onKeyMultiple(keyCode, count, e);
		else
			return true;
	}
	
	private int generateVKBCode(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.KEYCODE_DEL)
			return -5;
		else if (e.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP)
			return -100;
		else if (e.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN)
			return -101;
		else if (e.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT)
			return -102;
		else if (e.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT)
			return -103;
		
		return e.getUnicodeChar();
	}
	
	private void invokeVersionCheck()
	{
		final Handler AlertDialogShowCallBack = new Handler();
		
		new Thread() {
		    public void run() {		        
        		try {
            		int currentVerCode = KerKerInputService.this.getPackageManager().getPackageInfo("idv.Zero.KerKerInput", 0).versionCode;
            		String currentVersion = KerKerInputService.this.getPackageManager().getPackageInfo("idv.Zero.KerKerInput", 0).versionName;
            		final String remoteVerInfo[] = FileDownload.getContent(updateServiceURL).split("\n");
            		if (remoteVerInfo.length >= 4)
            		{
            		    int remoteVerCode = Integer.parseInt(remoteVerInfo[0]);
            		    if (remoteVerCode > currentVerCode)
            		    {
            		        final String update_str = KerKerInputService.this.getResources().getText(R.string.update_str).toString().replace("{CURRENT_VER}", currentVersion).replace("{REMOTE_VER}", remoteVerInfo[1]).replace("{UPDATE_MSG}", remoteVerInfo[3].replace("\\n", "\n")+"\n");
            		        final Runnable createAlertDialog = new Runnable() {
            		            public void run() {            		                
                                    new AlertDialog.Builder(KerKerInputService.this).setTitle(R.string.app_name).setMessage(update_str).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton(R.string.download, new DialogInterface.OnClickListener(){
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(Intent.ACTION_VIEW);
                                            i.setData(Uri.parse(remoteVerInfo[2]));
                                            KerKerInputService.this.startActivity(i);
                                            dialog.dismiss();
                                        }
                                    }).show();
                                }
                            };
                            AlertDialogShowCallBack.post(createAlertDialog);
            		    }
            		}
        		}
        		catch(Exception ex)
        		{
        		    ex.printStackTrace();
        		}
		    }
        }.start();
	}
}