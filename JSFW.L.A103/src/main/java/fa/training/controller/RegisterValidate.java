package fa.training.controller;

import fa.training.dao.MemberDao;
import fa.training.dao.impl.MemberDaoImpl;
import fa.training.service.MemberService;
import fa.training.service.impl.MemberServiceImpl;
import fa.training.util.HibernateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register/checkMember")
public class RegisterValidate extends HttpServlet {
    private MemberDao memberDao;
    private MemberService memberService;
    @Override
    public void init() throws ServletException {
        memberDao = new MemberDaoImpl(HibernateUtils.getSessionFactory());
        memberService = new MemberServiceImpl(memberDao);
    }

    /**
     * Checking email and username isvalid to use
     * if username or password is existed return status 204
     * else return status 200
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        resp.setContentType("text/plain");
        if (username == null) {
            if(memberService.isExistEmail(email)){
                resp.setStatus(204);
            }else{
                resp.setStatus(200);
            }
        } else {
            if(memberService.isExistUsername(username)){
                resp.setStatus(204);
            }else{
                resp.setStatus(200);
            }
        }

    }
}
