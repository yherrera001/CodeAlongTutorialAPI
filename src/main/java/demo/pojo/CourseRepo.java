package demo.pojo;

import demo.pojo.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepo extends CrudRepository<Course, String> {

//creating a method that takes in a topic id and returns a list of courses
    @Query(nativeQuery = true, value = "SELECT * FROM COURSE WHERE topic_topic_id = ?1")
    public List<Course> findByTopicId(String topicId);

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

