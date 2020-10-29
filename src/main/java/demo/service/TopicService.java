package demo.service;

import demo.pojo.Topic;
import demo.pojo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //declares that this is a business service.
public class TopicService {

    @Autowired //here it is injecting the instance of repository
    private TopicRepo topicRepo;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList( //mutable array
//        new Topic("spring", "SpringFramework", "Spring Framework Description"),
//        new Topic("java", "Core Java", "Core Java Description"),
//        new Topic("javaScript", "JavaScript", "JavaScript Description")
//     ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepo.findAll() //connects to the database. run a query to get all the topics. convert each of those rows into topic instances and get it back
         .forEach(topics::add); //creating a new topics list and iterating for the result off the findall.. getting all the topics in the database and for each of them I am populating them with .element
        return topics;
    }

    public Topic getTopic(String id) {
        //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); //lambda... inserting a topic I want to compare the id of that topic to the id that is passed in.
        // Find the very first topic element and then do a GET and then a return.
        return topicRepo.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        topicRepo.save(topic); //saving the new topic to the database
    }

    public void updateTopic(String id, Topic topic) { //the topics will be looped through depending on the size. each topic will be compared to the input id and if it matches then in that location the updated topic will be sent
//        for(int i = 0; i < topics.size(); i++){
//            Topic t= topics.get(i);
//            if(t.getId().equals(id));{
//                topics.set(i, topic);
//                return;
        //           }
        //       }

        topicRepo.save(topic); //a save can do both. add and update. sending the topic instance and the instance knows what the id is and what the instance itself is.
        // the repo knows enough to know there is a row in that particular id. if the row exists, then it will update
    }

    public void deleteTopic(String id) {
        // topics.removeIf(t -> t.getId().equals(id));
        topicRepo.delete(getTopic(id));
    }
}

