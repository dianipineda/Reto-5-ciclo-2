package reto_5.model.dao;

import java.util.ArrayList;
import java.util.List;

import reto_5.model.vo.ComprasVo;
import reto_5.utils.JDBCUtilities;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComprasDao {
    public List<ComprasVo> listar() throws SQLException {
        List<ComprasVo> respuesta = new ArrayList<ComprasVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                ComprasVo vo = new ComprasVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
