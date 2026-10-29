package com.example.nuevoproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfiguracionFragment extends Fragment {

    TextView txtUsuarioLogueado;
    Button btnCerrarSesion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracion, container, false);

        txtUsuarioLogueado = view.findViewById(R.id.txt_usuario_logueado);
        btnCerrarSesion = view.findViewById(R.id.btn_cerrar_sesion);

        // Recibimos los datos enviados mediante Bundle desde el HomeActivity
        if (getArguments() != null) {
            String usuario = getArguments().getString("USUARIO");
            txtUsuarioLogueado.setText("Usuario activo: " + usuario);
        }

        // Botón para cerrar sesión y regresar al Login
        btnCerrarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            // Limpiamos la pila de actividades para que no pueda volver atrás con el botón físico
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }
}