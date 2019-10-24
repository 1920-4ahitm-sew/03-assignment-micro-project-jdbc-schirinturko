package at.htl.baeckerei.servlet;

import at.htl.baeckerei.at.htl.baeckerei.datenbank.Datenbank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("my")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        resp.getWriter().printf("<h1>Hello %s</h1>", name);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();

        try{
            //open html tags
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BäckereiServlet</title>");
            out.println("</head>");
            out.println("<body>");

            //set up table
            //getKunde();

            //set foodValue to request parameter from html

        }
    }



}
