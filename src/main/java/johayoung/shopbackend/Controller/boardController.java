package johayoung.shopbackend.Controller;



import johayoung.shopbackend.Service.boardService;
import johayoung.shopbackend.entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000") //react랑 REST
@RestController //controller + responsebody : JSON형태로 객체 데이터 변환
//@RequestMapping("/api") //공통 url
public class boardController {

    @Autowired
    private boardService boardService;

    @GetMapping("/") // RESTful post put get delete //boardList
    public ModelAndView home(){ //Model model
       // List<board> b = boardService.getAllboard();

       // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
        //System.out.println(b); //정상출력
        return new ModelAndView("index", "list", "nothing");// 이 방법을 활용하도록 하겠다.
        //return "home.html"; // html 파일 이름
    }
    @GetMapping("/board") // RESTful post put get delete //boardList
    public ModelAndView getAllboard(@PageableDefault(page = 0 , size = 10, sort = "idx", direction = Sort.Direction.DESC) Pageable pageable){ //Model model
        Page<board> b = boardService.getAllboard(pageable);
        int totalPage = b.getTotalPages();
        // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
        System.out.println(b.getContent());

        ModelAndView mav = new ModelAndView();

        mav.setViewName("board");
        mav.addObject("boards", b);
        mav.addObject("totalPage", totalPage);

        return mav;


        //return new ModelAndView("board", "boards", b);
        //return "home.html"; // html 파일 이름
    }
  /*  @GetMapping(value = "/pageboard")
    public String chart(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("list", boardService.searchInfoList(pageable));
        return "/board";
    }*/

    //수정이랑 등록이랑 합치고싶은데 마땅히 생각이 안나서 일단 분리
  @GetMapping("/boardNew") // RESTful post put get delete //boardList
  public ModelAndView boardNew(){ //Model model
      // List<board> b = boardService.getAllboard();

      // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
      //System.out.println(b); //정상출력
      return new ModelAndView("boardNew", "list","nothing" );


      //return "home.html"; // html 파일 이름
  }
    @GetMapping("/boardNew/{idx}") // RESTful post put get delete //boardList
    public ModelAndView boardUpdate(@PathVariable Integer idx){ //Model model
        // List<board> b = boardService.getAllboard();

        // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
        //System.out.println(b); //정상출력
        Optional<board> b = boardService.getboardById(idx);
        if(b.isPresent()) {
            board boards = b.get();
            return new ModelAndView("boardNew", "list",boards );
        }else{
            System.out.println("error");
            return new ModelAndView("boardNew", "list", "nothing");
        }



        //return "home.html"; // html 파일 이름
    }
    @GetMapping("/board/{idx}")
    public ModelAndView getboardById(@PathVariable Integer idx){ //@pathvariable
        // optional<T> T의 타입의 객체를 포장해주는 래퍼클래스  , 예상치 못한 nullpointerexception 예외 처리를 해줌
        // 없는 데이터를 찾으려 할 경우 null값이 넘어옴 System.out.println(boardService.getboardById(idx)); = Optional.empty
        Optional<board> b = boardService.getboardById(idx);
        if(b.isPresent()){
            board boards = b.get();
            return new ModelAndView("boardDetail", "board", boards);// 이 방법을 활용하도록 하겠다.
        }else{
            System.out.println("error");
            return new ModelAndView("boardNew", "list", "nothing");
        }

    }

    @PostMapping("/newboard")
    public ModelAndView createboard(@ModelAttribute board board){ //@requestbody
        board c= boardService.createboard(board);

        return getboardById( c.getIdx());
    }

    @PutMapping("/board/{idx}")
    public ModelAndView updateboard(@PathVariable int idx,@ModelAttribute board updateboard){
        //@Pathvariable url 주소에 있는 것 활용 가능
        //@RequestBody Json 정보를 보낼 수 있는것

        boardService.updateboard(idx,updateboard);

        return getboardById(idx);
    }

    @DeleteMapping ("/board/{idx}")
    public ModelAndView deleteboard(@PathVariable int idx){

        boardService.deleteboard(idx);
        String projectUrl = "redirect:http://www.naver.com";
        return new ModelAndView("redirect:" + projectUrl);
    }


}
