package com.example.nuevoproyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nuevoproyecto.adaptadores.MotoAdaptador;
import com.example.nuevoproyecto.clases.Moto;
import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    RecyclerView rcvMotos;
    List<Moto> listaItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        rcvMotos = view.findViewById(R.id.rcv_motos);
        rcvMotos.setLayoutManager(new LinearLayoutManager(getContext()));

        cargarMotos();

        rcvMotos.setAdapter(new MotoAdaptador(listaItems));

        return view;
    }

    private void cargarMotos() {
        listaItems.clear();

        // 1. URL web, 2. Respaldo local drawable, 3. Título, 4. Descripción
        listaItems.add(new Moto(
                "https://zagamotos.com/wp-content/uploads/2019/11/NKD-gris-verde-2.webp",
                R.drawable.moto_nkd,
                "AKT NKD 125",
                "Urbana / Calle | Modelo 2024"
        ));
        listaItems.add(new Moto(
                "https://fulldecals.com/wp-content/uploads/2023/09/Yamaha-FZ16.jpg",
                R.drawable.moto_fz,
                "Yamaha FZ 16",
                "Deportiva Naked | 153cc"
        ));
        listaItems.add(new Moto(
                "https://www.suzuki.com.co/sites/default/files/2026-05/Image_20260529_155058_329.png",
                R.drawable.moto_gn,
                "Suzuki GN 125",
                "Estilo Clásico / Vintage"
        ));
        listaItems.add(new Moto(
                "https://masmotos.co/wp-content/uploads/2026/07/8-pulsar-n200-rojo-merlot-2.webp",
                R.drawable.moto_ns,
                "Bajaj Pulsar NS 200",
                "Alto Rendimiento | 199.5cc"
        ));
    }
}