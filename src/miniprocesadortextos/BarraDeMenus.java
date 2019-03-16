package miniprocesadortextos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;

public class BarraDeMenus extends JMenuBar
{
    private JMenu archivo;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardar;
    private JMenuItem salir;

    private JMenu edicion;
    private JMenuItem cortar;
    private JMenuItem copiar;
    private JMenuItem pegar;

    private JMenu estilo;
    private JMenuItem negrita;
    private JMenuItem cursiva;
    private JMenuItem subrayado;

    private JMenu colores;

    private JMenu tama;
    private ButtonGroup grupoTama;

    private JMenu fuente;

    JFileChooser seleccionado=new JFileChooser();
    File arch;
    GestionArchivos GA=new GestionArchivos();

    public BarraDeMenus()
    {  
        archivo=new JMenu("Archivo");
        nuevo=new JMenuItem("Nuevo",new ImageIcon("src/img/nuevo.gif"));
        abrir=new JMenuItem("Abrir",new ImageIcon("src/img//abrir.gif"));
        guardar=new JMenuItem("Guardar",new ImageIcon("src/img/guardar.gif"));
        salir=new JMenuItem("Salir",new ImageIcon("src/img/salir.gif"));

        nuevo.addActionListener(new EventosMenu());
        nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.ALT_DOWN_MASK));
        archivo.add(nuevo);

        abrir.addActionListener(new EventosMenu());
        abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.ALT_DOWN_MASK));
        archivo.add(abrir);

        guardar.addActionListener(new EventosMenu());
        guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.ALT_DOWN_MASK));
        archivo.add(guardar);

        salir.addActionListener(new EventosMenu());
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.ALT_DOWN_MASK));
        archivo.add(salir);

//------------------------------------------------------------------------------------------------------------------
        edicion=new JMenu("Edicion");
        cortar=new JMenuItem("Cortar",new ImageIcon("src/img/cortar.gif"));
        copiar=new JMenuItem("Copiar",new ImageIcon("src/img/copiar.gif"));
        pegar=new JMenuItem("Pegar",new ImageIcon("src/img/pegar.gif"));

        cortar.addActionListener(new DefaultEditorKit.CutAction());
        cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_DOWN_MASK));
        edicion.add(cortar);

        copiar.addActionListener(new DefaultEditorKit.CopyAction());
        copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
        edicion.add(copiar);

        pegar.addActionListener(new DefaultEditorKit.PasteAction());
        pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_DOWN_MASK));
        edicion.add(pegar);
//-------------------------------------------------------------------------------------------------------------------------------
        estilo=new JMenu("Estilo");
        negrita=new JMenuItem("Negrita",new ImageIcon("src/img/negrita.gif"));
        cursiva=new JMenuItem("Cursiva",new ImageIcon("src/img/cursiva.gif"));
        subrayado=new JMenuItem("Subrayado",new ImageIcon("src/img/subrayar.gif"));

        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        estilo.add(negrita);

        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK));
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilo.add(cursiva);

        subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
        subrayado.addActionListener(new StyledEditorKit.UnderlineAction());
        estilo.add(subrayado);
//-----------------------------------------------------------------------------------------------------------------
        colores=new JMenu("Colores");

        AgregarColores("Negro",66,Color.BLACK);
        AgregarColores("Rojo",82,Color.RED);
        AgregarColores("Azul",69,Color.BLUE);
        AgregarColores("Amarillo",89,Color.YELLOW);
        AgregarColores("Verde",71,Color.GREEN);
//----------------------------------------------------------------------------------------------------------------------------------		
        tama=new JMenu("Tamaño");
        grupoTama=new ButtonGroup();

        AgregarTama("11",11);
        AgregarTama("12",12);
        AgregarTama("14",14);
        AgregarTama("16",16);
        AgregarTama("18",18);
        AgregarTama("20",20);
        AgregarTama("22",22);
        AgregarTama("24",24);
        AgregarTama("26",26);
        AgregarTama("28",28);
        AgregarTama("30",30);
        AgregarTama("40",40);;
//------------------------------------------------------------------------------------------------------------------------------		
        fuente=new JMenu("Fuente");

        String nombresDeFuentes[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for(int i=0;i<nombresDeFuentes.length;i++)
        {
            AgregarFuentes(nombresDeFuentes[i]);
            i=i+10;
        }

//-----------------------------------------------------------------------------------------------------------------------------------
        add(archivo);
        add(edicion);
        add(estilo);
        add(colores);
        add(tama);
        add(fuente);
    }

//------------------------METODOS-----------------------------------------------------------------------------------------	
    public void AgregarColores(String nombre,int atajo,Color colorTexto)
    {
        JMenuItem color=new JMenuItem(nombre,new ImageIcon("src/img/"+nombre+".gif"));
        color.setAccelerator(KeyStroke.getKeyStroke(atajo,InputEvent.CTRL_DOWN_MASK));
        color.addActionListener(new StyledEditorKit.ForegroundAction("", colorTexto));
        colores.add(color);
    }

//-------------------------------------------------------------------------------------------------------------------------	
    public void AgregarTama(String nombre,int tam)
    {
        JRadioButtonMenuItem botonT=new JRadioButtonMenuItem(nombre);

        grupoTama.add(botonT);

        if(tam==12)
        {
            botonT.setSelected(true);
        }

        botonT.addActionListener(new StyledEditorKit.FontSizeAction("", tam));
        tama.add(botonT);
    }
//---------------------------------------------------------------------------------------------------------------------------	
    public void AgregarFuentes(String nombre)
    {
        JMenuItem f=new JMenuItem(nombre);
        f.addActionListener(new StyledEditorKit.FontFamilyAction("",nombre));
        fuente.add(f);
    }
//----------------------------------------------------------------------------------------------------------------------	
    class EventosMenu implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()==nuevo) 
            {
                VentanaProcesador v2=new VentanaProcesador();

                if(VentanaProcesador.contador>1)
                {
                    MainProcesador.vP.dispose();	
                    MainProcesador.vP=v2;
                }
            }
        //---------------------------------------------------------------------------------------------	
                if(e.getSource()==abrir)
                {
                    if(seleccionado.showDialog(null, "ABRIR")==JFileChooser.APPROVE_OPTION)
                    {
                        arch=seleccionado.getSelectedFile();

                        if(arch.canRead()==true)
                        {
                            if(arch.getName().endsWith("txt"))
                            {
                                String contenido=GA.abiriArchivo(arch);
                                LaminaPrincipal.texto.setText(contenido);
                            }
                        }
                    }
                }

        //---------------------------------------------------------------------------------------------	
                if(e.getSource()==guardar)
                {
                    if(seleccionado.showDialog(null, "GUARDAR")==JFileChooser.APPROVE_OPTION)
                    {
                        arch=seleccionado.getSelectedFile();

                        if(arch.getName().endsWith("txt"))
                        {
                            String contenido=LaminaPrincipal.texto.getText();
                            String respuesta=GA.guardarArchivo(arch, contenido);

                            if(respuesta!=null)
                            {
                                    JOptionPane.showMessageDialog(null, respuesta);
                            }
                            else
                            {
                                    JOptionPane.showMessageDialog(null, "Error Al Guadar");
                            }
                        }
                    }
                }

        //----------------------------------------------------------------------------------------------------

                if(e.getSource()==salir)
                {
                    System.exit(0);
                }	
        }
    } //---fin de clase eventos
}

