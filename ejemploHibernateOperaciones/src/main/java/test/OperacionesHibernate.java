
package test;

import java.util.Scanner;
import model.Persona;
import model.PersonaDao;
import javax.swing.JOptionPane;

public class OperacionesHibernate {
    public static void main(String[] args){
        //variables generales
        PersonaDao pDao = new PersonaDao();
        Persona p1 = null;
        int opcion = -1;
        String idStr, nombre, apellido="";
        
        //presiona 0 para salir
        while (opcion != 0) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una obsion:\n1.lista personas"
                      + "\n2.buscar persona por id"
                      + "\n3.agragar una persona"
                      + "\n4.modificar Persona"
                      + "\n5.eliminar persona"
                      + "\n0.salir"));
                
                switch(opcion){
                    case 1:
                        JOptionPane.showMessageDialog(null, "\n1.listado*************");
                        pDao.listar();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "\n2.buscar por id************");
                        idStr = JOptionPane.showInputDialog("Introduce el id de la persona a buscar");
                        p1 = new Persona();
                        p1.setIdPersona(new Integer(idStr));
                        p1 = pDao.buscarPorId(p1);
                        JOptionPane.showMessageDialog(null, "objeto encontrado "+p1);
                        break;
                        
                    case 3:
                        JOptionPane.showMessageDialog(null, "\n3.insertar persona*****************");
                        
                        nombre = JOptionPane.showInputDialog("introdusca el nomobre de la persona a agragar");
                        
                        apellido = JOptionPane.showInputDialog("introdusca el apellido de la persona a agragar");
                        
                        p1 = new Persona();
                        p1.setNombre(nombre);
                        p1.setApellido(apellido);
                        //se guarda el objeto
                        pDao.insertar(p1);
                        break;
                    
                    case 4:
                        JOptionPane.showMessageDialog(null, "\n4.modificar*****************");
                        
                        //se busca la persona que se desea modificar
                        
                        idStr = JOptionPane.showInputDialog("introdusca el id de la persona");
                        p1 = new Persona();
                        p1.setIdPersona(new Integer(idStr));
                        p1 = pDao.buscarPorId(p1);
                       
                        nombre = JOptionPane.showInputDialog("introduse el nombre de la persona a editar: ");
                        
                        apellido = JOptionPane.showInputDialog("introduse el apellido de la persona a editar: ");
                        //modificamos algun valor
                        p1.setNombre(nombre);
                        p1.setApellido(apellido);
                        pDao.actualizar(p1);
                        break;
                        
                        
                    case 5:
                        JOptionPane.showMessageDialog(null, "\n5.eliminar**************");
                        
                        //se busca la persona que se desea eliminar
                        
                        idStr = JOptionPane.showInputDialog("introduse el id de la persona a eliminar");
                        p1 = new Persona();
                        p1.setIdPersona(new Integer(idStr));
                        p1 = pDao.buscarPorId(p1);
                        // se elimina la persona encontrada
                        pDao.eliminar(p1);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Adios!!!!");
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Consultaincorecta");
                        break;
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                
            }
            
        }
    }
}
