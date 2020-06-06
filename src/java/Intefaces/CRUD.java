
package Intefaces;

import Modelo.Productos;
import java.util.List;


public interface CRUD {
    public List listar();
    public Productos list(int id);
    public boolean add(Productos per);
    public boolean edit(Productos per);
    public boolean eliminar(int id);
}
