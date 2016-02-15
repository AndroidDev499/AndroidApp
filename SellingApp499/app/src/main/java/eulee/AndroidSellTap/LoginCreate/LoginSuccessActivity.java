package eulee.AndroidSellTap.LoginCreate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import eulee.AndroidSellTap.MainActivity;
import eulee.sellingapp499.R;

public class LoginSuccessActivity extends AppCompatActivity
{
  private Button okButton;
  private Toolbar mToolbar;

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.login_success );

    mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    initUI();
  }

  private void initUI()
  {
    okButton = (Button) findViewById( R.id.okButton );

    okButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onLogoutButtonClicked();
      }
    });
  }

  private void onLogoutButtonClicked()
  {
    Intent intent = new Intent(LoginSuccessActivity.this, MainActivity.class);
    LoginSuccessActivity.this.startActivity (intent);

    /*Backendless.UserService.logout( new DefaultCallback<Void>( this )
    {
      @Override
      public void handleResponse( Void response )
      {
        super.handleResponse( response );
        startActivity( new Intent( LoginSuccessActivity.this, LoginActivity.class ) );
        finish();
      }

      @Override
      public void handleFault( BackendlessFault fault )
      {
        if( fault.getCode().equals( "3023" ) ) // Unable to logout: not logged in (session expired, etc.)
          handleResponse( null );
        else
          super.handleFault( fault );
      }
    } ); */

  }
}