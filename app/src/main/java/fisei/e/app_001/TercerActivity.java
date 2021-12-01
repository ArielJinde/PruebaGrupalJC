package fisei.e.app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TercerActivity extends AppCompatActivity {

    private ListView listViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        listViewDatos = findViewById(R.id.listViewDatos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cargarListView());

        //asociar los datos con el listView
        listViewDatos.setAdapter(adapter);

        //obtener el item donde se hizo un click
        listViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSeleccionado = (String) listViewDatos.getAdapter().getItem(i);

//                Toast.makeText(getApplicationContext(), "Item: " + itemSeleccionado + " " + i, Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSeleccionado));

//                indica que la actividad al cerrar regresara datos en un Intent de forma correcta
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private List<String> cargarListView() {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 20; i++){
            String item = "Número: " + i;
            list.add(item);
        }

        return list;
    }
}