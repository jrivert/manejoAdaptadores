package pe.edu.upc.manejoadaptadores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link datos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class datos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String cod;
    View vista;
    EditText edtCodigo, edtNombre, edtDesc;
    public datos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datos.
     */
    // TODO: Rename and change types and number of parameters
    public static datos newInstance(String param1, String param2) {
        datos fragment = new datos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //cod = getArguments().getInt("codigo",0);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_datos, container, false);
        edtCodigo= vista.findViewById(R.id.edtid);
        edtNombre = vista.findViewById(R.id.edtNombre);
        edtDesc = vista.findViewById(R.id.edtDescrip);
        Bundle b3=getArguments();
        edtCodigo.setText(b3.getString("codigo"));
        edtNombre.setText(b3.getString("nombre"));
        edtDesc.setText(b3.getString("descripcion"));
        return vista;
    }
}
