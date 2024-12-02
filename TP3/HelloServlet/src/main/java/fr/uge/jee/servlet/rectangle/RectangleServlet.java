package fr.uge.jee.servlet.rectangle;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet("/rectangle")
public class RectangleServlet extends HttpServlet {
    public static String readFromInputStream(InputStream inputStream) throws IOException {
        var lines = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines();
        return lines.collect(Collectors.joining("\n"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        InputStream inputStream = getServletContext().getResourceAsStream("WEB-INF/templates/rectangle-form.html");
        writer.println(readFromInputStream(inputStream));
        writer.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var heigth = request.getParameter("height");
        var width = request.getParameter("width");

        if(heigth.matches("[0-9]*") && width.matches("[0-9]*")){
            var result = Integer.parseInt(heigth) * Integer.parseInt(width);
            var writer = response.getWriter();
            writer.println("Area of rectangle is :" + String.valueOf(result));
            writer.flush();
        } else{

        }
    }
}