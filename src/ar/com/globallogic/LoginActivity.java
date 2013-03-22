package ar.com.globallogic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ar.com.globallogic.services.DummyAuthService;
import ar.com.globallogic.services.IAuthenticationService;

/**
 * 
 * @author ngonzalez
 * First Fucking Login 
 */
public class LoginActivity extends Activity {

	 protected static final String TAG = LoginActivity.class.getSimpleName();
	
	 private IAuthenticationService authenticationService;
	
	 private EditText userName;
	 
	 private EditText password;
	 
	 private TextView reponse;
	 
	 private Button loginButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		
		authenticationService = new DummyAuthService();
        
		setContentView(R.layout.activity_login);
        
		userName = (EditText) findViewById(R.id.editText_userName);
        password = (EditText) findViewById(R.id.editText_password);
        reponse = (TextView) findViewById(R.id.div_response);
        loginButton = (Button) findViewById(R.id.buton_login);
        loginButton.setOnClickListener(new LoginListener());
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    private class LoginListener implements View.OnClickListener {
    	
    	public void onClick(View v) {
    		
    		try {
				
    			Log.d(TAG,"Authenticating...");
    			
    			authenticationService.doLogin(userName.getText().toString(), password.getText().toString());
				
				reponse.setText("Logged in!");
			
    		} catch (Exception e) {
    			
    			Log.d(TAG,"Failed!");
    			
    			reponse.setText("Invalid Login");
			}
    	}
    }
}
