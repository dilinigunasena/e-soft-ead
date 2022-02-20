package com.esoft.ead.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet's doGet() method is invoked.");
        doAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet's doPost() method is invoked.");
        doAction(req, resp);
    }

    private void doAction(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        res.setContentType("text/html");
        res.getWriter().write("Hello " + name + "!");
        PrintWriter out = res.getWriter();
        out.println("<h3>Hello Dear");
        out.println(name);
        out.println("</h3>");
    }
}
