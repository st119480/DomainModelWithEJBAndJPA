package com.bazaar.web;

import com.bazaar.accounts.AccountManagerRemote;
import com.bazaar.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AccountManagerServlet", urlPatterns={"/sayHello", "/createUser", "/showUser"})
public class AccountManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    AccountManagerRemote accountManager;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        String requestUri = request.getRequestURI();
        if (requestUri != null && requestUri.endsWith("/sayHello"))
        {
            //String name = request.getParameter("name");
            if (name == null || name.length() == 0)
            {
                name = "anonymous";
            }
            response.getWriter().write(accountManager.sayHello(name));
        } else if (requestUri != null && requestUri.endsWith("/createUser"))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User(firstName, lastName, username, password);
            //accountManager.createUser(user);
            Long id = accountManager.createUser(user);
            response.getWriter().write("Created user successfully. New Id: " + id);
        } else if (requestUri != null && requestUri.endsWith("/showUser"))
        {
            User user = null;
            String id = request.getParameter("id");
            if (id != null)
                user = accountManager.findUser(Long.parseLong(id));
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("user.jsp");
            dispatcher.forward(request, response);
        }
    }

}
