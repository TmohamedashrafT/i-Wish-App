/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Ahmed
 */
public class HomeUserDTO {
    private String username;
    private String fullName;
    private double balance;

    public HomeUserDTO(String username, String fullName, double balance) {
        this.username = username;
        this.fullName = fullName;
        this.balance = balance;
    }

    public HomeUserDTO() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }


}
