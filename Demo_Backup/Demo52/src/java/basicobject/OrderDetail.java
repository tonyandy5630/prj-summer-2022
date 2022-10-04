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
public class OrderDetail {
    private int detailId;
    private int orderId;
    private int FID;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int detailId, int orderId, int FID, int quantity) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.FID = FID;
        this.quantity = quantity;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
