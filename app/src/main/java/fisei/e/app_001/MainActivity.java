package fisei.e.app_001;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMensaje;

    private int codigoRequerido = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMensaje = findViewById(R.id.textViewMensaje);

        //recuperar los datos pasados como parametros

        Bundle bundle = getIntent().getExtras();

        String usuario = bundle.getString("parametro_usuario");
        String clave = bundle.getString("parametro_clave");

        textViewMensaje.setText("Datos recuperados: " + usuario + " " + clave);
    }

    public void onClickNavegadorWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void onClickLlamarTelefono(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +593 963028274"));
        startActivity(intent);
    }

    public void onClickMostrar(View view){
        Intent intent = new Intent(this, TercerActivity.class);

//        para cuando la actividad regresa datos
        startActivityForResult(intent, codigoRequerido);
//        startActivity(intent);
    }

//    este metodo se ejecuta luego de que la ventan hija se cierra
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == codigoRequerido) && (resultCode == RESULT_OK)){
            textViewMensaje.setText("Usted selecciono el item: " + data.getDataString());
        }else{
            Toast.makeText(this, "ERROR: al cerrar la ventan", Toast.LENGTH_LONG).show();
        }
    }
}