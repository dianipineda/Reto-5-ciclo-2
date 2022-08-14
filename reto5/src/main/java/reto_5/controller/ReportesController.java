package reto_5.controller;

import java.sql.SQLException;
import java.util.List;

import reto_5.model.dao.ComprasDao;
import reto_5.model.dao.ListaLideresDao;
import reto_5.model.dao.ProyectosDao;
import reto_5.model.vo.*;

public class ReportesController {
    private ProyectosDao proyectosDao;
    private ComprasDao comprasDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController() {
        proyectosDao = new ProyectosDao();
        comprasDao = new ComprasDao();
        listaLideresDao = new ListaLideresDao();
    }

    public List<ProyectosVo> listarProyectos() throws SQLException {
        return proyectosDao.listar();
    }

    public List<ComprasVo> listarCompras() throws SQLException {
        return comprasDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException {
        return listaLideresDao.listar();
    }
}
