package org.example;

import java.time.LocalTime;
import java.util.List;

    public class Store {
        public List<String> pickers;
        public LocalTime pickingStartTime;
        public LocalTime pickingEndTime;
        public Store(List<String> _pickers, LocalTime _pickingStartTime, LocalTime _pickingEndTime){
            this.pickers = _pickers;
            this.pickingStartTime = _pickingStartTime;
            this.pickingEndTime = _pickingEndTime;
    }
}
