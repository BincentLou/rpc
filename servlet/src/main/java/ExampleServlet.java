import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @version $Id: null.java, v 1.0 2020/1/9 2:41 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@WebServlet("/myServlet")
public class ExampleServlet extends HttpServlet {

    private static final long serialVersionUID = 4333175671999649765L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doGet方法");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        writer.println("<strong>My Servlet!</strong><br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet 在处理post（）请求...");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.println("<strong>My Servlet!</strong><br>");
    }
}
