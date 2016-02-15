package eulee.sellingapp499.LoginCreate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import eulee.sellingapp499.LoginCreate.LoginActivity;
import eulee.sellingapp499.R;

public class PasswordRecoveryRequestedActivity extends AppCompatActivity
{
  private Button loginButton;
  private Toolbar mToolbar;

  @Override
  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.password_recovery_requested );

    mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    initUI();
  }

  private void initUI()
  {
    loginButton = (Button) findViewById( R.id.loginButton );

    loginButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onLoginButtonClicked();
      }
    } );
  }

  public void onLoginButtonClicked()
  {
    startActivity( new Intent( this, LoginActivity.class ) );
    finish();
  }
}