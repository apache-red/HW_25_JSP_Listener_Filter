package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class Listener implements ServletRequestListener {


    public Listener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)   sre.getServletRequest();
        System.out.println("Request from "+ httpServletRequest.getContextPath()+ "was destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)   sre.getServletRequest();
        System.out.println("Request from "+ httpServletRequest.getContextPath()+ "was created.");
    }
}
