package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Maestros.CrudPerson;

@WebServlet({ "/personaBuscar", "/personBuscar2", "/personProcesar" })
public class PersonController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Maestros.CrudPerson service = new Maestros.CrudPerson();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/personBuscar":
                buscar(request, response);
                break;
            case "/personBuscar2":
                buscar2(request, response);
                break;
            case "/personProcesar":
                procesar(request, response);
                break;
        }
    }

    private void procesar(HttpServletRequest request, HttpServletResponse response) {
        // Datos
        String accion = request.getParameter("accion");
        CrudPerson bean = new CrudPerson();
        bean.setId(Integer.parseInt(request.getParameter("id")));
        bean.setFirst_name(request.getParameter("first_name"));
        bean.setLast_name(request.getParameter("last_name"));
        bean.setIdentity_document(request.getParameter("identity_document"));
        bean.setGrade(request.getParameter("grade"));
        bean.setSection(request.getParameter("section"));
        bean.setStates(request.getParameter("states"));
        bean.setPerson_type(request.getParameter("person_type"));
        bean.setCellphone(request.getParameter("cellphone"));
        // Proceso
        try {
            switch (accion) {
                case ControllerUtil.CRUD_NUEVO:
                    service.insert(bean);
                    break;
                case ControllerUtil.CRUD_EDITAR:
                    service.update(bean);
                    break;
                case ControllerUtil.CRUD_ELIMINAR:
                    service.delete(Integer.toString(bean.getId()));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + accion);
            }
            ControllerUtil.responseJson(response, "Proceso ok.");
        } catch (Exception e) {
            ControllerUtil.responseJson(response, e.getMessage());
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Datos
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        // Proceso
        CrudPerson bean = new CrudPerson();
        bean.setLast_name(last_name);
        bean.setFirst_name(first_name);
        List<CrudPerson> lista = service.get(bean);
        // Reporte
        request.setAttribute("listado", lista);
        RequestDispatcher rd = request.getRequestDispatcher("person.jsp");
        rd.forward(request, response);
    }

    private void buscar2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Datos
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        // Proceso
        CrudPerson bean = new CrudPerson();
        bean.setLast_name(last_name);
        bean.setFirst_name(first_name);
        List<CrudPerson> lista = service.get(bean);
        // Preparando el JSON
        Gson gson = new Gson();
        String data = gson.toJson(lista);
        // Reporte
        ControllerUtil.responseJson(response, data);
    }
}

