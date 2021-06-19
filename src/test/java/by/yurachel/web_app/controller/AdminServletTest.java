package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

@WebServlet()
class AdminServletTest extends HttpInit {

    @InjectMocks
    private AdminServlet adminServlet;

    @Test
    void doGet() throws ServletException, IOException {
        adminServlet.doGet(request, response);
    }
}