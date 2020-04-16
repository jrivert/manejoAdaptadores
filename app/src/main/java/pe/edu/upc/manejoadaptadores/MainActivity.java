package pe.edu.upc.manejoadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
private String[] paises = new String[] {"Peru","Chile","Argentina"};
private String url = "http://tiendas.atwebpages.com/index.php/productos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Crear un adaptador
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,paises);
        //Spinner combo = (Spinner)findViewById(R.id.spinner);
        //combo.setAdapter(adaptador);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Crear lista
                List<String> items = new ArrayList<>();
                try {
                    JSONArray mJSONArray = new JSONArray(response);
                        for (int i=0;i<mJSONArray.length();i++)
                        {
                            JSONObject fila = mJSONArray.getJSONObject(i);
                            String nombre = fila.getString("nombre");
                            items.add(nombre);
                        }
                        //Crear el Adaptador
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,items);
                    Spinner combo = (Spinner)findViewById(R.id.spinner);
                    combo.setAdapter(adaptador);

                } catch (JSONException e)
                {
                    String mensaeError = e.getMessage();
                    Toast.makeText(MainActivity.this,mensaeError,Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        ); //Fin Request
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
        /*
        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(MainActivity.this,paises[position],Toast.LENGTH_SHORT).show();
                //Intent
                //Fragment

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//Fin del setOnItem
        */

    }
}
