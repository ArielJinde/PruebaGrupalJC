package fisei.e.app_001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_Usuario;
    private EditText editText_Clave;

    private Button buttonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_Usuario = findViewById(R.id.editText_Usuario);
        editText_Clave = findViewById(R.id.editText_Clave);

        buttonAceptar = findViewById(R.id.buttonAceptar);
    }

    public void onClick(View view){
        String usuario = editText_Usuario.getText().toString();
        String clave = editText_Clave.getText().toString();

        if(!usuario.matches("") && !clave.matches("")){
            Intent intent = new Intent(this, MainActivity.class);

            intent.putExtra("parametro_usuario", usuario);
            intent.putExtra("parametro_clave", clave);

            //mostrar el segundo activity
            startActivity(intent);

        }else{
            Toast.makeText(this, "El usuario y/o clave son obligatorios", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);

        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.menuAcercaDe:
                Toast.makeText(this,
                        "Todos los derechos reservados sexto TI - 2021",Toast.LENGTH_LONG).show();
                break;
        }

        return true;
    }
}