package org.example;

import java.util.List;

    public class Picker {
        public String pickerID;
        public List<Order> assignedOrders;

        public Picker(){

        }
        public Picker(String pickerID, List<Order> assignedOrders){
            this.pickerID = pickerID;
            this.assignedOrders = assignedOrders;
        }
}
