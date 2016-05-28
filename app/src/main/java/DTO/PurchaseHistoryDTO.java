package DTO;

import DAO.PurchaseHistoryDAO;

/**
 * Created by User on 5/20/2016.
 */
public class PurchaseHistoryDTO {
    private Number[] electronic;
    private Number[] food;
    private Number[] education;
    private Number[] clothe;

    public PurchaseHistoryDTO(){
        electronic = new Number[10];
        food = new Number[10];
        education = new Number[10];
        clothe= new Number[10];
    }

}
