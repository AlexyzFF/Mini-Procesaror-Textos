package miniprocesadortextos;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MenuEmergente extends JPopupMenu
{
    private JMenuItem negritaE;
    private JMenuItem cursivaE;
    private JMenuItem subrayarE;

    private JMenuItem cortarE;
    private JMenuItem copiarE;
    private JMenuItem pegarE;

    public MenuEmergente()
    {
        negritaE=new JMenuItem("Negrita",new ImageIcon("src/img/negrita.gif"));
        cursivaE=new JMenuItem("Cursiva",new ImageIcon("src/img/cursiva.gif"));
        subrayarE=new JMenuItem("Subrayar",new ImageIcon("src/img/subrayar.gif"));

        cortarE=new JMenuItem("Cortar",new ImageIcon("src/img/cortar.gif"));
        copiarE=new JMenuItem("Copiar",new ImageIcon("src/img/copiar.gif"));
        pegarE=new JMenuItem("Pegar",new ImageIcon("src/img/pegar.gif"));

//-------------------------------------------------------------------------------------------------------------		
        cortarE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_DOWN_MASK));
        cortarE.addActionListener(new DefaultEditorKit.CutAction());
        add(cortarE);

        copiarE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
        copiarE.addActionListener(new DefaultEditorKit.CopyAction());
        add(copiarE);

        pegarE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_DOWN_MASK));
        pegarE.addActionListener(new DefaultEditorKit.PasteAction());
        add(pegarE);
        addSeparator();

//-----------------------------------------------------------------------------------------------------------------

        negritaE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        add(negritaE);

        cursivaE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK));
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
        add(cursivaE);

        subrayarE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
        subrayarE.addActionListener(new StyledEditorKit.UnderlineAction());
        add(subrayarE);
        addSeparator();

//-------------------------------------------------------------------------------------------------------------------
        AgregarColoresEmergente("Negro",66,Color.BLACK);
        AgregarColoresEmergente("Rojo",82,Color.RED);
        AgregarColoresEmergente("Azul",Color.BLUE);    //metodo sobrecargado
        AgregarColoresEmergente("Amarillo",89,Color.YELLOW);
        AgregarColoresEmergente("Verde",71,Color.GREEN);

    }
//------------------------------------METODOS------------------------------------------------------------------------

    public void AgregarColoresEmergente(String nombre,int atajo,Color colorTexto)
    {
            JMenuItem colorEmergente=new JMenuItem(nombre,new ImageIcon("src/img/"+nombre+".gif"));
            colorEmergente.setAccelerator(KeyStroke.getKeyStroke(atajo,InputEvent.CTRL_DOWN_MASK));
            colorEmergente.addActionListener(new StyledEditorKit.ForegroundAction("", colorTexto));
            add(colorEmergente);
    }
//---------------------------------------------------------------------------------------------------------------------	
    public void AgregarColoresEmergente(String nombre,Color colorTexto)
    {
            JMenuItem colorEmergente=new JMenuItem(nombre,new ImageIcon("src/img/"+nombre+".gif"));
            colorEmergente.addActionListener(new StyledEditorKit.ForegroundAction("", colorTexto));
            add(colorEmergente);
    }
}

