package project.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String role = "NormalUser";  // Default for normal users

        UserOperations userOps = new UserOperations();
        if (userOps.registerUser(name, email, password, address, role)) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed");
        }
    }

}
