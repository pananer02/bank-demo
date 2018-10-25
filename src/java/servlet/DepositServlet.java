/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Account;
import model.History;
import model.controller.AccountJpaController;
import model.controller.HistoryJpaController;
import model.controller.exceptions.NonexistentEntityException;
import model.controller.exceptions.RollbackFailureException;

/**
 *
 * @author naijab
 */
public class DepositServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "BankDemoPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account acc = (Account) session.getAttribute("acc");
            if (acc != null) {
                String depositValue = request.getParameter("depositValue");
                if (depositValue != null && depositValue.trim().length() > 0) {
                    int depositNumber = Integer.parseInt(depositValue);
                    if (depositNumber > 0) {
                        AccountJpaController accCtrl = new AccountJpaController(utx, emf);
                        HistoryJpaController historyCtrl = new HistoryJpaController(utx, emf);
                        
                        int id = historyCtrl.findHistoryEntities().size() + 1;
                        int balance = acc.getBalance() + depositNumber;
                        
                        Account myAcc = accCtrl.findAccount(acc.getId());
                        
                        myAcc.setBalance(balance);
                        acc.setBalance(balance);
                        
                        History newHistory = new History(id, depositNumber, balance, new Date(), "deposit", myAcc);
                        
                        try {
                            accCtrl.edit(myAcc);
                            historyCtrl.create(newHistory);
                            request.setAttribute("transactionResponse", "Deposit Success!");
                            request.getRequestDispatcher("MyAccount").forward(request, response);
                        } catch (Exception ex) {
                            System.out.println("Deposit: " + ex.getMessage());
                        }
                    }
                    request.setAttribute("transactionResponse", "Withdraw Error!");
                    request.getRequestDispatcher("/withdraw.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/deposit.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("Login").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
