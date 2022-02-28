package johayoung.shopbackend.Controller;



import johayoung.shopbackend.Service.boardService;
import johayoung.shopbackend.entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") //react랑 REST
@RestController //controller + responsebody : JSON형태로 객체 데이터 변환
@RequestMapping("/api") //공통 url
public class boardController {

    @Autowired
    private boardService boardService;

    @GetMapping("/boardList") // RESTful post put get delete //boardList
    public String getAllboard(Model model){
        //List<board> b = boardService.getAllboard();

        model.addAttribute("list",boardService.getAllboard()); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체
        return "home"; //이것의 역할이 뭘까
    }

    @GetMapping("/board/{idx}")
    public Optional<board> getboardById(@PathVariable Integer idx){ //@pathvariable
        // optional<T> T의 타입의 객체를 포장해주는 래퍼클래스  , 예상치 못한 nullpointerexception 예외 처리를 해줌
        // 없는 데이터를 찾으려 할 경우 null값이 넘어옴 System.out.println(boardService.getboardById(idx)); = Optional.empty
        return boardService.getboardById(idx);
    }

    @PostMapping("/board")
    public board createboard(@RequestBody board board){ //@requestbody

        return boardService.createboard(board);
    }

    @PutMapping("/board/{idx}")
    public void updateboard(@PathVariable int idx,@RequestBody board updateboard){
        //@Pathvariable url 주소에 있는 것 활용 가능
        //@RequestBody Json 정보를 보낼 수 있는것

        boardService.updateboard(idx,updateboard);
    }

    @DeleteMapping ("/board/{idx}")
    public void deleteboard(@PathVariable int idx){

        boardService.deleteboard(idx);
    }


}
