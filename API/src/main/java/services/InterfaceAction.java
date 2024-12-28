package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceAction {
    String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response);
}
