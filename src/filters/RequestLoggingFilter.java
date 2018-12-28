package filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class RequestLoggingFilter implements Filter {

    private ServletContext servletContext;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.servletContext.log("ReqLogFil init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> params = httpServletRequest.getParameterNames();
        while (params.hasMoreElements()){

            String name  = params.nextElement();
            String value = servletRequest.getParameter(name);
            this.servletContext.log(httpServletRequest.getRemoteAddr() + "::Request Params::{"+ name+"="+value+"}");
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie cookie: cookies) {
                this.servletContext.log(httpServletRequest.getRemoteAddr()+
                        "::Cookie::{"+ cookie.getName() + ","+cookie.getValue()+"}");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
