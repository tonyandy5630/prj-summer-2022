/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phant
 */
public class Cart {

    private Map<String, Tree> cart;

    public boolean add(Tree tree) {
        boolean result = false;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(tree.getId())) {
            int currentQuantity = this.cart.get(tree.getId()).getQuantity();
            tree.setQuantity(currentQuantity + tree.getQuantity());
        }
        this.cart.put(tree.getId(), tree);
        result = true;
        return result;
    }

    public boolean edit(String id, Tree tree) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, tree);
                result = true;
            }
        }
        return result;
    }

    public boolean remove(String id) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.remove(id);
                result = true;
            }
        }
        return result;
    }

    public Cart() {
    }

    public Cart(Map<String, Tree> cart) {
        this.cart = cart;
    }

    public Map<String, Tree> getCart() {
        return cart;
    }

    public void setCart(Map<String, Tree> cart) {
        this.cart = cart;
    }

}
