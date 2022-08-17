package prod_session;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/Register")
public class Register extends HttpServlet {


 protected void doGet (
   HttpServletRequest request, 
   HttpServletResponse response
   ) throws ServletException, IOException {

  doPost(request, response);

 }


 protected void doPost(
   HttpServletRequest request, 
   HttpServletResponse response
   ) throws ServletException, IOException {

  String firstName = request.getParameter("productName");
  String lastName = request.getParameter("productDesc");
  String email = request.getParameter("productPrice");
  String password = request.getParameter("prodStock");

  HashMap<String, String> userDetails = new HashMap<String, String>();
  userDetails.put("productName", firstName);
  userDetails.put("productDesc", lastName);
  userDetails.put("productPrice", email);
  userDetails.put("prodStock", password);

  // Creating a Session object and storing 
  // HashMap into it 
  HttpSession session = request.getSession();
  session.setAttribute("user", userDetails);
  // forwarding request to confirm.jsp page
  RequestDispatcher dispatcher = request.getRequestDispatcher("confirm.jsp");
  dispatcher.forward(request, response);

 }

}

