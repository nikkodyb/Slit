package moduleManagement;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author Vebjørn
 * @Author Emil-Ruud
 * Dette er en servlet som henter ut data fra en gitt modul.
 */

@WebServlet(name = "ViewModule", urlPatterns = {"/ViewModule"})
public class ViewModule extends HttpServlet {

    /**
     * Oppretter Entity Manager for modulobjekt
     */
    @EJB
    private ModuleManagerLocal em;

    /**
     * Sjekker hvilken av modulknappene som har blitt trykket i ModuleDescriptionAndDelivery
     * @param request Et HTTP request objekt
     * @param response Et HTTP response objekt
     * @throws IOException
     * @throws ServletException
     */

    private void viewModule(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException {

        if (request.getParameter("module1") != null) {
            int knappTrykketInt = 1;
            getModuleData(knappTrykketInt, request, response);

        } else if (request.getParameter("module2") != null) {
            int knappTrykketInt = 2;
            getModuleData(knappTrykketInt, request, response);

        } else if (request.getParameter("module3") != null) {
            int knappTrykketInt = 3;
            getModuleData(knappTrykketInt, request, response);

        } else if (request.getParameter("module4") != null) {
            int knappTrykketInt = 4;
            getModuleData(knappTrykketInt, request, response);

        } else if (request.getParameter("module5") != null) {
            int knappTrykketInt = 5;
            getModuleData(knappTrykketInt, request, response);
        }
    }

    /**
     * Henter ut feltene til valgt modul
     * @param knappTrykketInt Knapp fra ModuleDescriptionAndDelivery som brukes til å angi hvilken modul som blir hentet ut
     * @param request Et HTTP request objekt
     * @param response Et HTTP response objekt
     */

    private void getModuleData(int knappTrykketInt, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException {
        Module module = em.getModule(knappTrykketInt);
        if (module != null) {
            String modulNummer = Integer.toString(knappTrykketInt);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDateDeadline = LocalDate.parse(deadline, formatter);

            try {
                skrivModulTilJSP(request, response, modulNummer, goals, resources, approvalCriterias, tasks, localDateDeadline);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } else {
            skrivNullTilJSP(request, response);
        }
    }


    /**
     * Skriver parameterne til ModuleDescriptionAndDelivery.jsp
     * @param request Et HTTP request objekt
     * @param response Et HTTP response objekt
     * @param modulNummer ModulID
     * @param goals Læringsmålene i modulen
     * @param resources Læringsressursene i modulen
     * @param localDateDeadLine Innleveringsfrist for modul
     * @param approvalCriterias Kriteriene for modulen
     * @param tasks Oppgavene i modulen
     * @throws IOException Java exception
     * @throws ServletException Java exception
     */

    private void skrivModulTilJSP(HttpServletRequest request, HttpServletResponse response, String modulNummer, String goals, String resources, String approvalCriterias, String tasks, LocalDate localDateDeadLine) throws IOException, ServletException {

        Diverse.DataRelated stringLinebreak = new Diverse.DataRelated();
        request.getSession().setAttribute("message", null);
        request.getSession().setAttribute("moduleError",null);
        request.getSession().setAttribute("mNr", stringLinebreak.LineBreak(modulNummer));
        request.getSession().setAttribute("goals", stringLinebreak.LineBreak(goals));
        request.getSession().setAttribute("resources", stringLinebreak.LineBreak(resources));
        request.getSession().setAttribute("deadline", "23:59 " + localDateDeadLine);
        request.getSession().setAttribute("approvalCriterias", stringLinebreak.LineBreak(approvalCriterias));
        request.getSession().setAttribute("tasks", stringLinebreak.LineBreak(tasks));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModuleDescriptionAndDelivery.jsp");
        requestDispatcher.forward(request, response);
        //Dette sender en varibelverdi som et parameter til session -
        //slik at andre servlets kan hente inn verdien.
        HttpSession session = request.getSession();
        session.setAttribute("modulNummer", modulNummer);
        session.setAttribute("deadline", localDateDeadLine);
    }

    /**
     * Skriver tomme variabler til ModuleDescriptionAndDelivery.jsp
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void skrivNullTilJSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String moduleError = "&#9731;";
        request.getSession().setAttribute("moduleError", "Denne modulen har ikke blitt lastet opp ennå &#9978; &#9975;");
        request.getSession().setAttribute("mNr", moduleError);
        request.getSession().setAttribute("goals", "");
        request.getSession().setAttribute("resources", "");
        request.getSession().setAttribute("deadline", "");
        request.getSession().setAttribute("approvalCriterias", "");
        request.getSession().setAttribute("tasks", "");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ModuleDescriptionAndDelivery.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * Standard Java metode for HTTP Get
     * @param request Et HTTP request objekt
     * @param response Et HTTP response objekt
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            viewModule(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            viewModule(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

