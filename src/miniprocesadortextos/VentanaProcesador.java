package miniprocesadortextos;
import javax.swing.*;
import java.awt.*;

public class VentanaProcesador extends JFrame
{
    public static int contador=0;

    public VentanaProcesador()
    {
        setTitle("TextPro");

        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        Dimension resolucion=miPantalla.getScreenSize();

        int ancho=resolucion.width;
        int alto=resolucion.height;

        setSize(ancho/2,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image miIcono=miPantalla.getImage("src/icono.jpg");
        setIconImage(miIcono);

            contador++;
            add(new LaminaPrincipal());
            setVisible(true);
    }
}
