package productID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProdServlet
 */
//@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		 PrintWriter out = response.getWriter(); 
		 int Pid= Integer.parseInt(request.getParameter("pid"));
		 //out.println("<html><body>"); 
		 try
		 {
			// Class.forName("com.mysql.jdbc.Driver");
			  //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_world", "root", "root");
			 Connection con=ProdClass.initializeDatabase();
			 PreparedStatement ps = con.prepareStatement("Select * from product where pid= ?");
			 ps.setInt(1, Pid);
			   
	         out.println("<table border=1 width=50% height=50%>");
	         ResultSet rs = ps.executeQuery();
	         ResultSetMetaData rsmd=rs.getMetaData();
	         int totalcol=rsmd.getColumnCount(); 
	         out.println("<tr>");
	         for (int i=1; i<=totalcol;i++)
	         {
	        	 out.print("<th>"+rsmd.getColumnName(i)+"</th>");
	         }
	         out.print("<tr>");
	         while (rs.next()) 
            {  
                //int s = rs.getInt("pid");                                   
                out.print("<tr><td>" + rs.getInt(1) + "</td>"+ "<td>" + rs.getString(2) + "</td></tr>");   
            }  
            out.println("</table>");  
            //out.println("</html></body>");  
            con.close();  
           
		 }
		 catch (Exception e) 
        {  
         out.print(e); 
        }
		 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doGet(request, response);
	}

}
