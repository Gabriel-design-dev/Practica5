
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Productos p=new Productos();
    
    @Override
    public List listar() {
        ArrayList<Productos>list=new ArrayList<>();
        String sql="select * from productos";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Productos per=new Productos();
                per.setId(rs.getInt("id"));
                per.setDescripcion(rs.getString("descripcion"));
                per.setStock(rs.getString("stock"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Productos list(int id) {
        String sql="select * from productos where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getString("stock"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Productos per) {
       String sql="insert into productos(descripcion, stock)values('"+per.getDescripcion()+"','"+per.getStock()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Productos per) {
        String sql="update productos set descripcion='"+per.getDescripcion()+"',stock='"+per.getStock()+"'where id="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from productos where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
