package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public MainService() {
    }

    public ResponseEntity doubling(Integer received) {
        if (received == null) {
            return ResponseEntity.status(200).body(new ErrorMessage("Please provide an input!"));
        } else {
            Doubling doubling = new Doubling(received);
            return ResponseEntity.status(200).body(doubling);
        }
    }

    public ResponseEntity greeting (String name, String title) {
        if (name != null && title != null) {
            return ResponseEntity.status(200).body(new Greeting(name, title));
        } else if (name == null && title == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a name and a title!"));
        } else if (name == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a name!"));
        } else {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a title!"));
        }
    }

    public int action(String action, DoUntil doUntil) {
        int result = 0;
        if (action.equals("sum")) {
            result = doUntil.sum();
        } else if (action.equals("factor")) {
            result = doUntil.factor();
        }
        return result;
    }

}
