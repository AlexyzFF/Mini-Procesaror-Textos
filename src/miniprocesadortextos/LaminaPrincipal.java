package miniprocesadortextos;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LaminaPrincipal extends JPanel
{
    private JPanel laminaMenu;
    public static JTextPane texto;

    public LaminaPrincipal()
    {
        setLayout(new BorderLayout());

        laminaMenu=new JPanel();
        laminaMenu.add(new BarraDeMenus());
        add(laminaMenu,BorderLayout.NORTH);

        texto=new JTextPane();
        JScrollPane textoScroll = new JScrollPane(texto);
        texto.setComponentPopupMenu(new MenuEmergente());
        add(textoScroll,BorderLayout.CENTER);

        add(new BarraDeHerramientas(),BorderLayout.WEST);
        JMenuBar a=new JMenuBar();
        a.setBackground(Color.BLACK);
        a.setForeground(Color.RED);
    }
}
