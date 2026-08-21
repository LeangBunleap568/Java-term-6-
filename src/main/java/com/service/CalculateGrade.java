package com.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculateGrade")
public class CalculateGrade extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        int score = Integer.parseInt(request.getParameter("score"));

        String grade;
        String color;
        if (score >= 90) {
            grade = "A";
            color = "#2e7d32"; // Green
        } else if (score >= 80) {
            grade = "B";
            color = "#1565c0"; // Blue
        } else if (score >= 50) {
            grade = "C";
            color = "#ef6c00"; // Orange
        } else {
            grade = "F (Fail)";
            color = "#c62828"; // Red
        }

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Academic Results</title>");
        out.println("<style>");
        out.println("    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); height: 100vh; margin: 0; display: flex; justify-content: center; align-items: center; }");
        out.println("    .card { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1); width: 100%; max-width: 400px; box-sizing: border-box; text-align: center; }");
        out.println("    h2 { color: #2c3e50; margin-top: 0; margin-bottom: 25px; font-size: 24px; }");
        out.println("    .result-box { background: #f8f9fa; padding: 15px; border-radius: 8px; margin-bottom: 20px; border: 1px solid #e9ecef; text-align: left; }");
        out.println("    p { margin: 10px 0; font-size: 16px; color: #34495e; }");
        out.println("    .grade-display { font-weight: bold; font-size: 24px; color: " + color + "; }");
        out.println("    .btn-back { display: inline-block; width: 100%; background-color: #4a90e2; color: white; padding: 12px; border: none; border-radius: 6px; text-decoration: none; font-size: 16px; font-weight: 600; box-sizing: border-box; transition: background-color 0.3s; }");
        out.println("    .btn-back:hover { background-color: #357abd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"card\">");
        out.println("<h2>Academic Results</h2>");
        out.println("<div class=\"result-box\">");
        out.println("<p><b>Student Name:</b> " + name + "</p>");
        out.println("<p><b>Score Received:</b> " + score + " points</p>");
        out.println("<p><b>Grade:</b> <span class=\"grade-display\">" + grade + "</span></p>");
        out.println("</div>");
        out.println("<a href=\"grade.html\" class=\"btn-back\">Back to Calculator</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}