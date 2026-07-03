import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.PacienteDAO;
import modelo.Paciente;

@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    String correo = request.getParameter("correo");
    String telefono = request.getParameter("telefono");

    Paciente paciente = new Paciente();

    paciente.setNombre(nombre);
    paciente.setCorreo(correo);
    paciente.setTelefono(telefono);

    PacienteDAO dao = new PacienteDAO();

    dao.insertarPaciente(paciente);

    request.setAttribute("nombre", nombre);
    request.setAttribute("correo", correo);
    request.setAttribute("telefono", telefono);

    request.getRequestDispatcher("resultado.jsp")
            .forward(request, response);
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}