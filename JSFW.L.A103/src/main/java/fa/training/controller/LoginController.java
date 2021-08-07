package fa.training.controller;

import fa.training.dao.MemberDao;
import fa.training.dao.impl.MemberDaoImpl;
import fa.training.entities.Member;
import fa.training.service.MemberService;
import fa.training.service.impl.MemberServiceImpl;
import fa.training.util.HibernateUtils;
import fa.training.util.Log4J;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private MemberDao memberDao;
    private MemberService memberService;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Override
    public void init() throws ServletException {
        memberDao = new MemberDaoImpl(HibernateUtils.getSessionFactory());
        memberService = new MemberServiceImpl(memberDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log4J.getLogger().info("Member Login");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = new Member(username,password);
        member = memberService.findMemberByUserNameAndPassword(member);
        if(member == null){
            resp.setStatus(204);
        }else{
            resp.setStatus(200);
            HttpSession session = req.getSession();
            session.setAttribute("username",member.getUsername());
            session.setAttribute("memberId",member.getMemberId());
            resp.sendRedirect(req.getContextPath()+"/home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }
}
