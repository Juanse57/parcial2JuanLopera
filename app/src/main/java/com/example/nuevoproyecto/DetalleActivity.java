package com.example.nuevoproyecto;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nuevoproyecto.clases.Moto;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Vincular componentes de la vista XML
        CircleImageView imgMoto = findViewById(R.id.imgDetalleMoto);
        TextView tvNombre = findViewById(R.id.tvDetalleNombre);
        TextView tvDetalles = findViewById(R.id.tvDetalleTexto);

        // Recibir el objeto Moto enviado por el adaptador mediante el Intent
        Moto moto = (Moto) getIntent().getSerializableExtra("moto");

        if (moto != null) {
            // Asignar los valores a los elementos visuales
            tvNombre.setText(moto.getNombre());
            tvDetalles.setText(moto.getDetalles());

            // Cargar la imagen con Picasso usando el respaldo local o la URL
            Picasso.with(this)
                    .load(moto.getImagenUrl())
                    .placeholder(moto.getImagenResId())
                    .error(moto.getImagenResId())
                    .into(imgMoto);
        }

        //  Habilitar boton de "Atras" en la barra superior si lo deseas
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detalles de la Moto");
        }
    }

    // Método para que funcione la flecha hacia atrás de la barra superior
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}