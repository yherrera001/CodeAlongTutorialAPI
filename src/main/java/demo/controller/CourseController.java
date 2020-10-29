package demo.controller;

import demo.pojo.Course;
import demo.pojo.Topic;
import demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired //Marks the private TopicService as something that needs a dependency injection. Declaring the dependency
    private CourseService courseService; //Here you are asking to get the instance that spring created

    @RequestMapping ("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){ //path variables ALWAYS have to match the endpoints
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}") //the curly braces represents the variable portion. Spring is going to match this {id}
    public Course getCourse(@PathVariable String id, @PathVariable String topicId){ //this will return one course. Accepts ID. Looks up by the ID.
    return courseService.getCourse(id,topicId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses") //specify a method. map this method to any request that is apposed on "/topics"
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", "")); //whatever the requestbody is set to, we are changing it to a NEW topic
        courseService.addCourse(course,topicId);

    }

    @RequestMapping(method = RequestMethod.PUT ,value ="/topics/{topicId}/courses/{id}") //this is an individual fetch
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) { //the Requestbody will contain the updated topic
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id,  @PathVariable String topicId){
        courseService.deleteCourse(id,topicId);
    }
}

