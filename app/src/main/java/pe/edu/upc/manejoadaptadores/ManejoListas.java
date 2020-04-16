package pe.edu.upc.manejoadaptadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class ManejoListas extends AppCompatActivity {
    private String[] paises = new String[] {"Peru","Chile","Argentina"};
    private String url = "http://tiendas.atwebpages.com/index.php/productos";
    //
    ArrayList<Productos> listaProductos;
    Bundle bundle=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejo_listas);
        FragmentManager manege =getSupportFragmentManager();
        //final FragmentTransaction frag =manege.beginTransaction();

        //ListView lista = (ListView)findViewById(R.id.lstPaises);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
/*
        lista.setAdapter(ada    ptador);
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ManejoListas.this,paises[position],Toast.LENGTH_SHORT).show();
                }
            });
            //Fin Lista
            */

        final List<String> items = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                    try {
                       Productos productos = null;
                       listaProductos = new ArrayList<Productos>();

                        JSONArray mJSONArray = new JSONArray(response);
                            for (int i = 0; i<mJSONArray.length();i++) {
                                JSONObject filas = mJSONArray.getJSONObject(i);
                                Integer idProducto = filas.getInt("idProducto");
                                String descripcion = filas.getString("descripcion");
                                String nombre = filas.getString("nombre");
                                productos = new Productos();
                                productos.setId(idProducto);
                                productos.setNombre(nombre);
                                productos.setDescripcion(descripcion);
                                listaProductos.add(productos);
                                items.add(nombre);
                            }
                                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(ManejoListas.this,android.R.layout.simple_spinner_item,items);
                                ListView combo = (ListView) findViewById(R.id.lstPaises);
                                combo.setAdapter(adaptador);
                                combo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Integer cod = listaProductos.get(position).getIdProducto();
                                        String nombre = listaProductos.get(position).getNombre();
                                        String descripcion = listaProductos.get(position).getDescripcion();
                                        Toast.makeText(ManejoListas.this,"codigo: " + cod + " nombre: " + nombre + " descripcion " + descripcion,Toast.LENGTH_SHORT).show();

                                        bundle.putString("codigo", cod.toString());
                                        bundle.putString("nombre", nombre);
                                        bundle.putString("descripcion", descripcion);
                                       // m4.setArguments(bundle);

                                        datos fragg = new datos();
                                        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
                                        fragg.setArguments(bundle);
                                        ft.replace(R.id.fragMostrar, fragg);
                                        ft.commit();

                                    }
                                });

                    } catch (JSONException e) {


                    }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}
