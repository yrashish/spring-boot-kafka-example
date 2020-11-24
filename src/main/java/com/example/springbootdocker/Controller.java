package com.example.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private StateService stateService;
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/states")
    private List<State> getAllStates(){
        var stateList = stateService.findAll();
        sendMessage(stateList);
        return stateList;
    }

    private void sendMessage(List<State> stateList) {
        stateList.stream().forEach(state -> kafkaProducer.getKafkaTemplate().send("test",state.capital,state.name));
    }


}
