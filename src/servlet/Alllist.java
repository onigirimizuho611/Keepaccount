package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KeepaccountDao;
import dto.Keepaccount;
import dto.Returnl;

/**
 * Servlet implementation class Alllist
 */
@WebServlet("/Alllist")
public class Alllist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alllist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param list
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		ArrayList<Keepaccount> keepaccount = KeepaccountDao.getAllList();
		int i = 0;
		for(Keepaccount result : keepaccount){
			String income = result.getincome();
			String spending = result.getspending();
			Keepaccount data = new Keepaccount(income,spending);
			String rs = "rs" + i;
			request.setAttribute(rs, data);
			i++;
		}

		Returnl ri = new Returnl(i);
		request.setAttribute("lnum", ri);

		request.setCharacterEncoding("UTF-8");
		String view = "/WEB-INF/view/Alllist.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
