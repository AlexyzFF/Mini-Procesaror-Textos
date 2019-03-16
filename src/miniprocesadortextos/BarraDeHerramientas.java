package miniprocesadortextos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;

public class BarraDeHerramientas extends JToolBar
{
    private JButton botonCortar;
    private JButton botonCopiar;
    private JButton botonPegar;

    private JButton botonNegrita;
    private JButton botonCursiva;
    private JButton botonSubrayar;

    private JButton botonMayus;
    private JButton botonMinus;

    public BarraDeHerramientas()
    {
        botonCortar=new JButton(new ImageIcon("src/img/cortar.gif"));
        botonCopiar=new JButton(new ImageIcon("src/img//copiar.gif"));
        botonPegar=new JButton(new ImageIcon("src/img/pegar.gif"));
        botonNegrita=new JButton(new ImageIcon("src/img/negrita.gif"));
        botonCursiva=new JButton(new ImageIcon("src/img/cursiva.gif"));
        botonSubrayar=new JButton(new ImageIcon("src/img/subrayar.gif"));
        botonMayus=new JButton(new ImageIcon("src/img/mayus.gif"));
        botonMinus=new JButton(new ImageIcon("src/img/minus.gif"));

//------------------------------------------------------------------------------------------------------	
        botonCortar.addActionListener(new DefaultEditorKit.CutAction());
        botonCortar.setToolTipText("Cortar");
        add(botonCortar);

        botonCortar.addActionListener(new DefaultEditorKit.CopyAction());
        botonCopiar.setToolTipText("Copiar");
        add(botonCopiar);

        botonPegar.addActionListener(new DefaultEditorKit.PasteAction());
        botonPegar.setToolTipText("Pegar");
        add(botonPegar);

//--------------------------------------------------------------------------------------------------------		

        botonNegrita.addActionListener(new StyledEditorKit.BoldAction());
        botonNegrita.setToolTipText("Negrita");
        add(botonNegrita);

        botonCursiva.addActionListener(new StyledEditorKit.ItalicAction());
        botonCursiva.setToolTipText("Cursiva");
        add(botonCursiva);

        botonSubrayar.addActionListener(new StyledEditorKit.UnderlineAction());
        botonSubrayar.setToolTipText("Subrayar");
        add(botonSubrayar);

//----------------------------------------------------------------------------------------------------------		
        botonMayus.addActionListener(new EventosBarraHerramientas());
        botonMayus.setToolTipText("Cambiar Todo El Texto A Mayusculas");
        add(botonMayus);

        botonMinus.addActionListener(new EventosBarraHerramientas());
        botonMinus.setToolTipText("Cambiar Todo El Texto A Minisculas");
        add(botonMinus);

//-----------------------------------------------------------------------------------------------------------		

        AgregarColoresBarra("Negro",Color.BLACK);
        AgregarColoresBarra("Rojo",Color.RED);
        AgregarColoresBarra("Azul",Color.BLUE);
        AgregarColoresBarra("Amarillo",Color.YELLOW);
        AgregarColoresBarra("Verde",Color.GREEN);

//------------------------------------------------------------------------------------------------------------------		

        AgregarAlineacion("Izquierda","Alineacion: Izquierda",0);
        AgregarAlineacion("Centrado","Alineacion: Centrado",1);
        AgregarAlineacion("Derecha","Alineacion: Derecha",2);

        setOrientation(1);
    }
//-----------------------------------------------METODOS----------------------------------------------------------------

    public void AgregarColoresBarra(String nombre,Color colorTexto)
    {
        JButton botonColor=new JButton(new ImageIcon("src/img/"+nombre+".gif"));
        botonColor.addActionListener(new StyledEditorKit.ForegroundAction("", colorTexto));
        botonColor.setToolTipText(nombre);
        add(botonColor);
    }

//-------------------------------------------------------------------------------------------------------------------

    public void AgregarAlineacion(String nombre,String tip,int constAlineacion)
    {
        JButton botonAlineacion=new JButton(new ImageIcon("src/img/"+nombre+".gif"));
        botonAlineacion.addActionListener(new StyledEditorKit.AlignmentAction("", constAlineacion));
        botonAlineacion.setToolTipText(tip);
        add(botonAlineacion);	
    }

//------------------------------------------------------------------------------------------------------------------------	
    class EventosBarraHerramientas implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==botonMayus)
            {
                String g=LaminaPrincipal.texto.getText();
                String a=g.toUpperCase();
                LaminaPrincipal.texto.setText(a);
            }
    //-----------------------------------------------------------------------	
            if(e.getSource()==botonMinus)
            {
                String h=LaminaPrincipal.texto.getText();
                String b=h.toLowerCase();
                LaminaPrincipal.texto.setText(b);
            }	
        }
    }
}