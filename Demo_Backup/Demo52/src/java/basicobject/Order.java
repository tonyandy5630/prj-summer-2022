/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

/**
 *
 * @author thanh
 */
public class Order {
    private int orderId;
    private String orderDate;
    private String shipDate;
    private int status;
    private int accID;

    public Order() {
    }

    public Order(int orderId, String orderDate, String shipDate, int status, int accID) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.status = status;
        this.accID = accID;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }
    
}
