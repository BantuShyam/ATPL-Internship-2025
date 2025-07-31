package com.aaslin.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@WebListener
public class OrderListener implements ServletRequestListener {
	
	@Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = request.getSession(false);
        if (session != null) {
            
			Object itemId = session.getAttribute("item_id");
			Object quantity = session.getAttribute("quantity");
			Object date = session.getAttribute("order_time");
			
            if (date != null && itemId != null && quantity != null) {
                Timestamp ts = (Timestamp) date;
                String orderTime = ts.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"));
                System.out.println("Order Date : " + orderTime + ", Item ID : " + itemId + ", Item Qty :" + quantity);

                session.removeAttribute("item_id");
                session.removeAttribute("quantity");
                session.removeAttribute("order_time");
            }
        }
    }
}