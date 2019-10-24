package at.htl.baeckerei.servlet;

import at.htl.baeckerei.at.htl.baeckerei.datenbank.Datenbank;
import at.htl.baeckerei.model.Kunde;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

//http://localhost:8080/baeckerei/kundenData
@WebServlet("kundenData")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();

        Datenbank db = new Datenbank();
        List<Kunde> kundeList = db.getAllKunden();

        //html tags
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BäckereiServlet</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<table>");
        out.println("<tr>" +
                "<th>ID</th><th>NAME</th>" +
                "</tr>");

        //foreach für Datenausgabe
        for (Kunde k : kundeList) {
            out.println("<tr>");
            out.println("<td>" + k.getId() + "</td>");
            out.println("<td>" + k.getName() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
