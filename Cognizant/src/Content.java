

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userdao.home.JDBCconnection;


@WebServlet("/Content")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Content() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String ccode = (String) session.getAttribute("user");
		out.println(ccode);
		Connection con = null;
		PreparedStatement pst = null;

		con = JDBCconnection.getConnection();
		String query = "select topic from content where course_code = ?";

		try {
			pst = con.prepareStatement(query);
			pst.setString(1, ccode);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				String topic = rs.getString(1);
				System.out.println(topic);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
