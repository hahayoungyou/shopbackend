package johayoung.shopbackend.Controller;



import johayoung.shopbackend.Service.boardService;
import johayoung.shopbackend.entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //react랑 REST
@RestController //controller + responsebody : JSON형태로 객체 데이터 변환
@RequestMapping("/api") //공통 url
public class boardController {

    @Autowired
    private boardService boardService;

    @GetMapping("/boardList") // RESTful post put get delete
    public List<board> getAllboard(){

        return boardService.getAllboard();
    }

    /*@GetMapping("/board/{idx}")
    public board getboardById(@PathVariable int idx){ //@pathvariable

        return boardService.getboardById(idx);
    }*/

    @PostMapping("/board")
    public board createboard(@RequestBody board board){ //@requestbody

        return boardService.createboard(board);
    }

    @PutMapping("/board/{idx}")
    public void updateboard(@PathVariable int idx,board updateboard){

        boardService.updateboard(idx,updateboard);
    }

    @DeleteMapping ("/board/{idx}")
    public void deleteboard(@PathVariable int idx){

        boardService.deleteboard(idx);
    }


}
