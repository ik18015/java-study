package ik18015;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ik18015.k1_2", urlPatterns = { "/ik18015.k1_2" })

public class k1_2 extends HttpServlet {
	private int [][] kdata = {
	//   年度　M    A    J    S    K
        { 1994, 187, 198,  81,  86, 209 },
        { 1995, 175, 213, 102,  75,  94 },
        { 1996, 200, 244, 149, 105, 215 },
        { 1997, 268, 326, 206, 142, 171 },
        { 1998, 262, 288, 195, 125, 120 },
        { 1999, 203, 242, 162, 106, 130 },
        { 2000, 237, 235, 189, 129, 161 },
        { 2001, 269, 270, 207, 135, 106 },
        { 2002, 213, 231, 172,  93,  85 },
        { 2003, 190, 233, 169,  74,  49 },
        { 2004, 279, 301, 220, 126,  73 },
        { 2005, 321, 330, 256, 130, 105 },
        { 2006, 504, 480, 344, 208, 155 },
        { 2007, 579, 603, 430, 270, 200 },
        { 2008, 540, 590, 412, 200, 179 },
        { 2009, 381, 400, 288, 160, 137 },
        { 2010, 332, 350, 254, 156, 133 },
        { 2011, 332, 350, 242, 156, 137 },
        { 2012, 235, 236, 287,  95, 113 },
        { 2013, 435, 383, 333, 213, 261 },
        { 2014, 509, 487, 429, 297, 425 },
        { 2015, 640, 631, 523, 415, 512 },
        { 2016, 702, 727, 476, 416, 518 },
        { 2017, 742, 775, 540, 422, 525 },
        { 2018, 746, 788, 629, 461, 547 },
        { 2019, 723, 742, 634, 471, 520 },
        { 2020, 725, 744, 632, 515, 544 }
	};

    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// HTTPリクエストのエンコーディングを UTF-8 とする
		request.setCharacterEncoding("utf-8");

		// この部分を完成させる
    
    String year1 = request.getParameter("year1");
		String year2 = request.getParameter("year2");
		int start;
    int end;
    
		start = Integer.parseInt(year1);
		if(start < 1994)
			start = 1994;
		else if(start > 2020)
			start = 2020;
		start = 26 - (2020 - start);
		
		end = Integer.parseInt(year2);
		if(end < 1994)
			end = 1994;
		else if(end > 2020)
			end = 2020;
		end = 26 - (2020 - end);
		out.println("<h1>本校への求人企業数一覧</h1>");
		
    
    if(start <= end)
		{
			out.println("<table border = 1 style = border-collapse:collapse  width = 50%>");
			out.println("<tr>");
			out.println("<th>" + "年度" + "</th>");
			out.println("<th>" + "M" + "</th>");
			out.println("<th>" + "A" + "</th>");
			out.println("<th>" + "J" + "</th>");
			out.println("<th>" + "S" + "</th>");
			out.println("<th>" + "K" + "</th>");
			out.println("</tr>");
			while(true)
			{
				out.println("<tr>");
				for(int i = 0;i < 6;i++)
				{
					out.print("<td align=right>" + kdata[start][i] + "</td>");
				}
				out.println("</tr>");
				if(kdata[start][0] == kdata[end][0])
					break;
				start++;
			}
		}

		out.println("<hr>");
		out.println("<form action=\"/webapps/ik18015.k1_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\">");
		out.println("</form>");
		out.println("No.01　K.ISHIKAWA<br>");
		out.println("</body></html>");
    }
}
