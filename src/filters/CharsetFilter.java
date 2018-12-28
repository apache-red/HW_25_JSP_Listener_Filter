package filters;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {

private String encoding;
private ServletContext servletContext;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        encoding = filterConfig.getInitParameter("charecterEncoding");
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);

        servletContext.log("Charset was set");

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
