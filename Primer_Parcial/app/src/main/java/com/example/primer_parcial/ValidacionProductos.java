package com.example.primer_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.List;

public class ValidacionProductos extends AppCompatActivity implements View.OnClickListener {
    private TextView txtProductos;
    private TextView txtResultados;
    private Spinner spConsultas;
    private Button btnBack;
    private Button btnConsultar;
    private List<PRODUCTO> resultadoProductos = new ArrayList<>();
    private List<String> resultadoCategoria = new ArrayList<>();
    private String Mensaje;
    private CONSULTA consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion_productos);

        List<String> Categoria = (List<String>) getIntent().getSerializableExtra("Categoria");
        List<PRODUCTO> listadoproductos = (List<PRODUCTO>) getIntent().getSerializableExtra("lista");
        consulta = new CONSULTA(listadoproductos, Categoria);


        txtProductos = findViewById(R.id.txtProductos);
        txtResultados = findViewById(R.id.txtResultados);
        spConsultas = findViewById(R.id.spConsultas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spConsultas, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spConsultas.setAdapter(adapter);
        btnBack = findViewById(R.id.btnBack);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(this);

        if (listadoproductos != null) {
            Cargarlista(listadoproductos);

        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConsultar) {
            int elementosSpinner = (int) spConsultas.getSelectedItemId();
            switch (elementosSpinner) {
                case 0:
                    CustomToastView.makeErrorToast(this, "Seleccione su consulta", R.layout.custom_toast).show();
                    break;

                case 1:
                    Mensaje= null;
                    Mensaje ="El empleado mas joven es ";
                    resultadoProductos = null;


                    for (int i=0; i<= resultadoProductos.size()-1; i++){
                        Mensaje= Mensaje + "\n" + " Nombre " + resultadoProductos.get(i).getNombre() + " " + resultadoProductos.get(i).getCodigo()
                                + " Codigo " + resultadoProductos.get(i);
                    }
                    txtProductos.setText(Mensaje);
                    break;

            }
        }

    }

    public void Cargarlista(List<PRODUCTO> Cargarlista) {
        String Resultado = "";
        for (int i = 0; i <= Cargarlista.size() - 1; ++i) {
            Resultado = Resultado + "\n" + Cargarlista.get(i).getNombre() + " " + Cargarlista.get(i).getCodigo();
        }
        txtProductos.setText(Resultado);

    }
}