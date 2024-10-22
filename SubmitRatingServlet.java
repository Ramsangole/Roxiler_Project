package project.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/submitRating")
public class SubmitRatingServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        int userId = (int) session.getAttribute("userId");
	        int storeId = Integer.parseInt(request.getParameter("storeId"));
	        int rating = Integer.parseInt(request.getParameter("rating"));

	        RatingOperations ratingOps = new RatingOperations();
	        if (ratingOps.submitRating(userId, storeId, rating)) {
	            response.sendRedirect("storeDetails.jsp?storeId=" + storeId);
	        } else {
	            response.sendRedirect("storeDetails.jsp?storeId=" + storeId + "&error=Rating submission failed");
	        }
	    }

}
