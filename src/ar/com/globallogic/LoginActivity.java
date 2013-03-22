package ar.com.globallogic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	 private EditText userName;
	 
	 private EditText password;
	 
	 private TextView reponse;
	 
	 private Button loginButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
        
		setContentView(R.layout.activity_login);
        
		userName = (EditText) findViewById(R.id.editText_userName);
        password = (EditText) findViewById(R.id.editText_password);
        reponse = (TextView) findViewById(R.id.div_response);
        loginButton = (Button) findViewById(R.id.buton_login);
        
        loginButton.setOnClickListener(new LoginListener());
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    
    
    private class LoginListener implements View.OnClickListener {
    	
    	public void onClick(View v) {
    		
    		if ((!userName.getText().toString().equals("niko")) && (!password.getText().toString().equals("1234"))){
    			reponse.setText("Invalid Login!");
    		}else {
    			reponse.setText("logged in");
    		}
    	}
    	
    }
}
