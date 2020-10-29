package demo.pojo;

import demo.pojo.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, String> {


}


    //we use interface so that the spring data JPA is going to be providing the class. It uses the implementation that comes with spring data JPA
    //the spring already comes with CrudRepository by default.
//The CrudRepo already has the common methods. My custom repository will extend the common methods.....
    //GET, SELECT, etc

    //CrudRepo is a generic type. <>  the Entity is topic and the second genetic type is what the id is which = a String.


    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)

