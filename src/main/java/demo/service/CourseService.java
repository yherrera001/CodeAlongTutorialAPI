package demo.service;

import demo.pojo.Course;
import demo.pojo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //declares that this is a business service.
public class CourseService {

    @Autowired //here it is injecting the instance of repository
    private CourseRepo courseRepo;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList( //mutable array
//        new Topic("spring", "SpringFramework", "Spring Framework Description"),
//        new Topic("java", "Core Java", "Core Java Description"),
//        new Topic("javaScript", "JavaScript", "JavaScript Description")
//     ));

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepo.findByTopicId(topicId)
         .forEach(courses::add); //creating a new topics list and iterating for the result off the findall.. getting all the topics in the database and for each of them I am populating them with .element
        return courses;
    }

    public Course getCourse(String id, String topicId) {
        //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); //lambda... inserting a topic I want to compare the id of that topic to the id that is passed in.
        // Find the very first topic element and then do a GET and then a return.
        return courseRepo.findById(id).orElse(null);
    }

    public void addCourse(Course course, String topicId) {
        courseRepo.save(course); //saving the new topic to the database
    }

    public void updateCourse(Course course) { //the topics will be looped through depending on the size. each topic will be compared to the input id and if it matches then in that location the updated topic will be sent
//        for(int i = 0; i < topics.size(); i++){
//            Topic t= topics.get(i);
//            if(t.getId().equals(id));{
//                topics.set(i, topic);
//                return;
        //           }
        //       }
        courseRepo.save(course); //a save can do both. add and update. sending the topic instance and the instance knows what the id is and what the instance itself is.
        // the repo knows enough to know there is a row in that particular id. if the row exists, then it will update
    }

    public void deleteCourse(String id, String topicId) {
        // topics.removeIf(t -> t.getId().equals(id));
        courseRepo.delete(getCourse(id, topicId));
    }
}

