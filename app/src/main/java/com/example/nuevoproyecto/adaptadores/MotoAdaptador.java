package com.example.nuevoproyecto.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nuevoproyecto.R;
import com.example.nuevoproyecto.clases.Moto;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class MotoAdaptador extends RecyclerView.Adapter<MotoAdaptador.ViewHolder> {

    private List<Moto> lista;

    public MotoAdaptador(List<Moto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Moto m = lista.get(position);
        holder.nombre.setText(m.getNombre());
        holder.detalles.setText(m.getDetalles());

        // Usamos with(context) para asegurar de que sea compatible con la versión de Picasso
        Picasso.with(holder.itemView.getContext())
                .load(m.getImagenUrl())
                .placeholder(m.getImagenResId())
                .error(m.getImagenResId())
                .into(holder.imagen);

        // --- AQUÍ AGREGAMOS EL CLIC PARA CADA TARJETA ---
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            // Nota: Crearemos esta actividad en el siguiente paso
            Intent intent = new Intent(context, com.example.nuevoproyecto.DetalleActivity.class);

            // Le pasamos el objeto Moto completo gracias a que implementa Serializable
            intent.putExtra("moto", m);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imagen;
        TextView nombre, detalles;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.img_moto);
            nombre = itemView.findViewById(R.id.txt_titulo);
            detalles = itemView.findViewById(R.id.txt_descripcion);
        }
    }
}