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

import Maestros.CrudBook;

@WebServlet({ "/bookBuscar", "/bookBuscar2", "/bookProcesar" })
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Maestros.CrudBook service = new Maestros.CrudBook();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/bookBuscar":
                buscar(request, response);
                break;
            case "/bookBuscar2":
                buscar2(request, response);
                break;
            case "/bookProcesar":
                procesar(request, response);
                break;
        }
    }

    private void procesar(HttpServletRequest request, HttpServletResponse response) {
        // Datos
        String accion = request.getParameter("accion");
        CrudBook bean = new CrudBook();
        bean.setId(Integer.parseInt(request.getParameter("id")));
        bean.setNames(request.getParameter("names"));
        bean.setAuthor(request.getParameter("author"));
        bean.setDescriptions(request.getParameter("descriptions"));
        bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        bean.setStates(request.getParameter("states"));
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
                    throw new IllegalArgumentException("Valor inesperado: " + accion);
            }
            ControllerUtil.responseJson(response, "Proceso exitoso.");
        } catch (Exception e) {
            ControllerUtil.responseJson(response, e.getMessage());
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Datos
        String names = request.getParameter("names");
        String author = request.getParameter("author");
        // Proceso
        CrudBook bean = new CrudBook();
        bean.setNames(names);
        bean.setAuthor(author);
        List<CrudBook> lista = service.get(bean);
        // Reporte
        request.setAttribute("listado", lista);
        RequestDispatcher rd = request.getRequestDispatcher("Book.jsp");
        rd.forward(request, response);
    }

    private void buscar2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Datos
        String names = request.getParameter("names");
        String author = request.getParameter("author");
        // Proceso
        CrudBook bean = new CrudBook();
        bean.setNames(names);
        bean.setAuthor(author);
        List<CrudBook> lista = service.get(bean);
        // Preparando el JSON
        Gson gson = new Gson();
        String data = gson.toJson(lista);
        // Reporte
        ControllerUtil.responseJson(response, data);
    }
}

