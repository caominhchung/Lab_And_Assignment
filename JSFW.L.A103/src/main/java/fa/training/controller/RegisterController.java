package fa.training.controller;

import fa.training.dao.MemberDao;
import fa.training.dao.impl.MemberDaoImpl;
import fa.training.entities.Member;
import fa.training.service.MemberService;
import fa.training.service.impl.MemberServiceImpl;
import fa.training.util.HibernateUtils;
import fa.training.util.Log4J;
import fa.training.util.ValidatorUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private MemberDao memberDao;
    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberDao = new MemberDaoImpl(HibernateUtils.getSessionFactory());
        memberService = new MemberServiceImpl(memberDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log4J.getLogger().info("Register User");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Member member = new Member(username, password, email);

        if (ValidatorUtil.isValidEmail(member.getEmail())) {
            resp.setStatus(204);
        }else if(!memberService.create(member)){
            resp.setStatus(204);
        }else{
            resp.setStatus(200);
            resp.sendRedirect(req.getContextPath() +"/login");
        }
    }
}
