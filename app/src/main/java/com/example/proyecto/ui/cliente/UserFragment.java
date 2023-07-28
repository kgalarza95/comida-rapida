package com.example.proyecto.ui.cliente;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyecto.login.LoginActivity;
import com.example.proyecto.R;

public class UserFragment extends Fragment {

    Button btnLoginUser, btnTerminosLegales, btnAyuda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        btnLoginUser = view.findViewById(R.id.btnLogInUser);
        btnTerminosLegales = view.findViewById(R.id.btnTerminosLegales);
        btnAyuda = view.findViewById(R.id.btnAyuda);

        btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnTerminosLegales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view, "t");
            }
        });

        btnAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view, "a");
            }
        });

        return view;
    }

    private void showDialog(View view, String tipoDialogo) {
        switch (tipoDialogo) {
            case "t":
                showDialog( view,  "Términos y Condiciones",  "Términos y Condiciones\n\n" +
                        "Al utilizar esta aplicación, aceptas los siguientes términos y condiciones:\n\n" +
                        "1. No compartir tu cuenta con otras personas.\n" +
                        "2. Respetar los derechos de autor y propiedad intelectual de los contenidos.\n" +
                        "3. Mantener actualizada tu información de perfil.\n" +
                        "4. Utilizar la aplicación de acuerdo con las leyes locales y nacionales.\n" +
                        "5. No publicar contenido ofensivo o ilegal.\n" +
                        "...\n\n" +
                        "Estos términos y condiciones están sujetos a cambios sin previo aviso.");
                break;
            case "a":
                showDialog( view,  "Ayuda",  "Cómo usar la aplicación de kiosko y comida rápida\n" +
                        "\n" +
                        "La aplicación de kiosko y comida rápida es una forma rápida y conveniente de pedir comida. Puede usar la aplicación para pedir comida en su restaurante favorito, pagar su pedido y recoger su comida en los kioskos.\n" +
                        "\n" +
                        "Para usar la aplicación, primero debe crear una cuenta. Una vez que haya creado una cuenta, puede iniciar sesión en la aplicación y comenzar a ordenar.\n" +
                        "\n" +
                        "Cuando ordene, puede elegir de una variedad de alimentos y bebidas. También puede personalizar su orden agregando o eliminando ingredientes.\n" +
                        "\n" +
                        "Una vez que haya realizado su pedido, puede pagarlo con una tarjeta de crédito o débito. Después de pagar su pedido, puede recoger su comida en los kioskos.\n" +
                        "\n" +
                        "Los kioskos se encuentran cerca de la entrada del restaurante. Para recoger su comida, simplemente escanee el código QR en su teléfono en los kioskos. Su comida se entregará en una bandeja en los kioskos.\n" +
                        "\n" +
                        "¡Gracias por usar la aplicación de kiosko y comida rápida!\n" +
                        "\n" +
                        "Aquí hay algunos consejos adicionales para usar la aplicación:\n" +
                        "\n" +
                        "Puede agregar sus alimentos y bebidas favoritos a su lista de deseos para que sea más fácil encontrarlos la próxima vez que ordene.\n" +
                        "Puede recibir notificaciones cuando su restaurante favorito tenga ofertas especiales.\n" +
                        "Puede compartir sus pedidos con amigos y familiares en las redes sociales.\n" +
                        "¡Esperamos que disfrutes usando la aplicación de kiosko y comida rápida!\n");
                break;
        }
    }

    private void showDialog(View view, String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}