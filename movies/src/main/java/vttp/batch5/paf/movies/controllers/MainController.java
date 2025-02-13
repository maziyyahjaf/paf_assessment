package vttp.batch5.paf.movies.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MainController {

  // TODO: Task 3

  @GetMapping("/api/summmary")
  public ResponseEntity<String> fetchProfitLossDirector(@RequestParam(name="count") Integer count) {

    return ResponseEntity.ok().body("{}");
  }

  
   

  
  // TODO: Task 4


}
