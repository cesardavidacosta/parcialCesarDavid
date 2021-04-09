package com.example.primer_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtBienvenido;
    private TextView txtName;
    private Spinner spCategoria;
    private TextView txtCodigo;
    private TextView txtPrecio;
    private Button btnAgregar;
    private Button btnNext;
    private Spinner spIva;
    List<String> Categoria = new ArrayList<>();
    List<String> Iva = new ArrayList<>();
    private static List<PRODUCTO> listadoproductos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Categoria.add("Carnicos");
        Categoria.add("Frutas - Verduras");
        Categoria.add("Granos - Viveres");
        setContentView();
    }

    private void setContentView() {
        txtBienvenido = findViewById(R.id.txtBienvenido);
        txtName = findViewById(R.id.txtName);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtPrecio = findViewById(R.id.txtPrecio);
        spCategoria = findViewById(R.id.spCategoria);

        btnNext =findViewById(R.id.btnNext);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Categoria);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            String nombre = txtName.getText().toString();
            int codigo = Integer.parseInt(txtCodigo.getText().toString());
            int precio = Integer.parseInt(txtPrecio.getText().toString());
            String categoria = spCategoria.getSelectedItem().toString();


            if (nombre.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Ingrese su nombre", R.layout.custom_toast).show();
                return;
            }

            PRODUCTO producto = new PRODUCTO(nombre, codigo, precio, categoria);
            listadoproductos.add(producto);
            CustomToastView.makeSuccessToast(this, "El producto se registro correctamente ", R.layout.custom_toast).show();

        } else if (v.getId() == R.id.btnNext) {
            Intent myIntent = new Intent(this, CONSULTA.class);
            myIntent.putExtra("lista", (Serializable) listadoproductos);
            myIntent.putExtra("Categoria", (Serializable) Categoria);
            startActivity(myIntent);

        }
    }
}
