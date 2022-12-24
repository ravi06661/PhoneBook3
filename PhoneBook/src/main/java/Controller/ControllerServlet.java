package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;dklgfqioewj[flkwefihoqeroifqoinjoiioio

import ControllerService.ControllerServiceInterfaceImpl;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControllerServiceInterfaceImpl csii = new ControllerServiceInterfaceImpl();

	public ControllerServlet() {
		super();

	}
    
	
		case "signup":
			if (csii.signupUser(request, response)) 
				{
				request.setAttribute("msg", "Welcome to PhoneBook..please login");
				RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
				rd.forward(request, response);
				}
			else
				{
				request.setAttribute("msg", "Something went wrong..please try again");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp");
				rd.forward(request, response);
				}
			
			break;

			
		case "login":
			
			
			if (csii.loginUser(request, response,session)) 
				{
				request.setAttribute("msg", "Logged in..");
				RequestDispatcher rd=request.getRequestDispatcher("Navbar.jsp");
				rd.forward(request, response);
				}
			
			else
				{
				request.setAttribute("msg", "Something went wrong..please try again");
				RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
				rd.forward(request, response);
				}
			
              
			break;
			
			
		case "userList":
			csii.listUsers(request, response);
			break;
			
			
			
		case "editUser":
			csii.editUser(request, response);
			break;

		case "updateUser":
			if (csii.updateUser(request, response))
				{
				request.setAttribute("msg", "User Updated");
				RequestDispatcher rd=request.getRequestDispatcher("Navbar.jsp");
				rd.forward(request, response);
				}
			else
				request.setAttribute("msg", "Something went wrong..please try again");
			
			break;
			
		case "upload":
			csii.uploadImage(request,response);
			break;
			
		case "logout":
			csii.logout(response, session);
			break;
			
		case "changePassword":
			csii.changePassword(request,response);
			break;
			
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
