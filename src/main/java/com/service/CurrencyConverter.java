package com.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/convert")
public class CurrencyConverter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Conversion Result</title>");
        out.println("<style>");
        out.println("    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); height: 100vh; margin: 0; display: flex; justify-content: center; align-items: center; }");
        out.println("    .card { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1); width: 100%; max-width: 400px; box-sizing: border-box; text-align: center; }");
        out.println("    h2 { color: #2c3e50; margin-top: 0; margin-bottom: 25px; font-size: 24px; }");
        out.println("    .result-box { background: #f8f9fa; padding: 15px; border-radius: 8px; margin-bottom: 20px; border: 1px solid #e9ecef; }");
        out.println("    p { margin: 10px 0; font-size: 16px; color: #34495e; }");
        out.println("    .highlight { font-weight: bold; color: #2e7d32; font-size: 20px; }");
        out.println("    .error { color: #d32f2f; font-weight: bold; }");
        out.println("    .btn-back { display: inline-block; width: 100%; background-color: #4a90e2; color: white; padding: 12px; border: none; border-radius: 6px; text-decoration: none; font-size: 16px; font-weight: 600; box-sizing: border-box; transition: background-color 0.3s; }");
        out.println("    .btn-back:hover { background-color: #357abd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"card\">");

        try {
            String usdInput = request.getParameter("usd");
            if (usdInput == null || usdInput.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("<h2>⚠️ Error</h2>");
                out.println("<p class=\"error\">Please provide the USD parameter! <br>Example: <code>?usd=10</code></p>");
            } else {
                double usdAmount = Double.parseDouble(usdInput);
                int exchangeRate = 4000;
                double khrAmount = usdAmount * exchangeRate;

                out.println("<h2>Conversion Result</h2>");
                out.println("<div class=\"result-box\">");
                out.println("<p>USD Amount: <b>$" + String.format("%.2f", usdAmount) + "</b></p>");
                out.println("<p>Exchange Rate: <b>1 USD = " + exchangeRate + " Riel</b></p>");
                out.println("<p>Total KHR: <br><span class=\"highlight\">" + String.format("%,.0f", khrAmount) + " Riel</span></p>");
                out.println("</div>");
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h2>⚠️ Invalid Input</h2>");
            out.println("<p class=\"error\">The USD value must be a valid number!</p>");
        }

        out.println("<br><a href=\"convert.html\" class=\"btn-back\">Back to Converter</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}