package johayoung.shopbackend.Controller;

import johayoung.shopbackend.Service.boardService;
import johayoung.shopbackend.entity.board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class productsController {
    @GetMapping("/new") // RESTful post put get delete //boardList
    public ModelAndView getNewList(){ //Model model
       // List<board> b = boardService.getAllboard();

        // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
        //System.out.println(b); //정상출력
        return new ModelAndView("new", "list", "test");// 이 방법을 활용하도록 하겠다.
        //return "home.html"; // html 파일 이름
    }
}
