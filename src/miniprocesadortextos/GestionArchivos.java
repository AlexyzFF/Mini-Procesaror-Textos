package miniprocesadortextos;
import java.io.*;

public class GestionArchivos
{
    FileInputStream entrada;
    FileOutputStream salida;

    public GestionArchivos()
    {	
    }
//----------------------------------METODOS----------------------------------------------------
	
public String abiriArchivo(File archivo)
{
        String contenido="";

        try
        {
                entrada=new FileInputStream(archivo);
                int ascci;

                while((ascci=entrada.read())!=-1)
                {
                        char caracter=(char)ascci;
                        contenido=contenido+caracter;
                }
        }
        catch(Exception e)
        {

        }
        return contenido;
}
	
//---------------------------------------------------------------------------------------------------
    public String guardarArchivo(File archivo,String contenido)
    {
        String respuesta=null;

        try
        {
                salida=new FileOutputStream(archivo);
                byte[] bytesText=contenido.getBytes();

                salida.write(bytesText);

                respuesta="Se Guardo Con exito El Archivo";
        }
        catch(Exception e)
        {
        }
        return respuesta;
    }
}
