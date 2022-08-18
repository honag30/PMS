package fa.trainning.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class FilterAuthentication implements Filter {
    private List<String> excludedRequests;
    private System LogFactory;

    public void init(FilterConfig config) throws ServletException {
        excludedRequests = new ArrayList<>();
        excludedRequests.add(new String("login.jsp"));
        excludedRequests.add(new String("/ServletEmployeeLogin"));
        excludedRequests.add(new String(".js"));
        excludedRequests.add(new String(".css"));
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        boolean loggedIn = session != null && (session.getAttribute("admin") != null || session.getAttribute("staff") != null);
        String userRequest = req.getRequestURI();
        if (loggedIn || isValidRequest(userRequest)) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/ServletEmployeeLogin");
        }
    }

    private boolean isValidRequest(String request) {
        for (String excludedRequest : excludedRequests) {
            if (request.endsWith(excludedRequest)) {
                return true;
            }
        }
        return false;
    }
}
