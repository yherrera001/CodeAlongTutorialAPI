package demo.controller;

import demo.pojo.Topic;
import demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //HERE IS WHERE YOU WRITE YOUR METHODS
public class TopicController {

    @Autowired //Marks the private TopicService as something that needs a dependency injection. Declaring the dependency
    private TopicService topicService; //Here you are asking to get the instance that spring created

    @RequestMapping ("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}") //the curly braces represents the variable portion. Spring is going to match this {id}
    public Topic getTopic(@PathVariable String id){ //this will return one topic. Accepts ID. Looks up by the ID.
        // The @PathVariable annotation will match/map the variable portion and then call the "getTopic" method to execute everything else
    return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics") //specify a method. map this method to any request that is apposed on "/topics"
    public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic); //Take that requestbody and convert it into the topic instance, then pass it to the addTopic method
    } //this method is going to post request to /topics and pass in the topic object. and its going to create a new topic for me

    @RequestMapping(method = RequestMethod.PUT ,value = "/topics/{id}") //this is an individual fetch
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { //the Requestbody will contain the updated topic
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}

