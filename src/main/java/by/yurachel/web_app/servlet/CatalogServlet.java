package by.yurachel.web_app.servlet;

import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private static final Logger ROOT_LOGGER = LogManager.getLogger();

    private final PhoneRepository pr = PhoneRepository.getInstance();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("phones", pr.getPhones());
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);
        ServletContext sc = getServletContext();
        ROOT_LOGGER.debug("Phone count: {} ",pr.getPhones().size());
        ROOT_LOGGER.info("Products retrieved successfully");
        sc.setAttribute("phones", pr.getPhones());

    }
}
