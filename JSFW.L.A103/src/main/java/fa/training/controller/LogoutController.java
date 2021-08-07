package fa.training.controller;

import fa.training.util.Log4J;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log4J.getLogger().info("Logging out");
        // remove session userLogin
        req.getSession().removeAttribute("username");
        req.getSession().removeAttribute("memberId");
        // redirect to /login
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
