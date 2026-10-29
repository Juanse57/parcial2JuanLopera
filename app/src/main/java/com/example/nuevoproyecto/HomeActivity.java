package com.example.nuevoproyecto;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Recogemos el usuario enviado desde el Login
        String usuarioLogueado = getIntent().getStringExtra("NOMBRE_USUARIO");

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // Cargar por defecto el fragment de Inicio
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InicioFragment()).commit();
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_inicio) {
                selectedFragment = new InicioFragment();
            } else if (itemId == R.id.nav_configuracion) {
                // Pasamos el usuario mediante un Bundle al Fragment de Configuración
                selectedFragment = new ConfiguracionFragment();
                Bundle bundle = new Bundle();
                bundle.putString("USUARIO", usuarioLogueado);
                selectedFragment.setArguments(bundle);
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        });
    }
}