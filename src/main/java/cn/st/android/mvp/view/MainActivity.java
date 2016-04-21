package cn.st.android.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.st.android.mvp.R;
import cn.st.android.mvp.entity.User;
import cn.st.android.mvp.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IUserView{
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSave;
    private UserPresenter userPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPresenter=new UserPresenter(this);
        etFirstName= (EditText) findViewById(R.id.et_first_name);
        etLastName= (EditText) findViewById(R.id.et_last_name);
        btnSave= (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:{
                User user=new User();
                user.setFirstName(getFirstName());
                user.setLastName(getLastName());
                userPresenter.saveUser(user);
                break;
            }
        }
    }

    @Override
    public String getLastName() {
        return etLastName.getText().toString();
    }

    @Override
    public String getFirstName() {
        return etFirstName.getText().toString();
    }
}
