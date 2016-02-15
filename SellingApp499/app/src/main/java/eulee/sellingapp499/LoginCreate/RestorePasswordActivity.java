package eulee.sellingapp499.LoginCreate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.backendless.Backendless;

import eulee.sellingapp499.Backend.DefaultCallback;
import eulee.sellingapp499.R;

public class RestorePasswordActivity extends AppCompatActivity
{
  private Button restorePasswordButton;
  private EditText loginField;
  private Toolbar mToolbar;

  @Override
  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.restore_password );

    mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    initUI();
  }

  private void initUI()
  {
    restorePasswordButton = (Button) findViewById( R.id.restorePasswordButton );
    loginField = (EditText) findViewById( R.id.loginField );

    restorePasswordButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onRestorePasswordButtonClicked();
      }
    } );
  }

  public void onRestorePasswordButtonClicked()
  {
    String login = loginField.getText().toString();
    Backendless.UserService.restorePassword( login, new DefaultCallback<Void>( this )
    {
      @Override
      public void handleResponse( Void response )
      {
        super.handleResponse( response );
        startActivity( new Intent( RestorePasswordActivity.this, PasswordRecoveryRequestedActivity.class ) );
        finish();
      }
    } );
  }
}