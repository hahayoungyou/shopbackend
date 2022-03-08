package johayoung.shopbackend.Service;


import johayoung.shopbackend.Exception.ResourceNotFoundException;
import johayoung.shopbackend.Repository.boardRepository;
import johayoung.shopbackend.entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class boardService {

    @Autowired
    private boardRepository boardRepository;

    public Page<board> getAllboard(Pageable pageable){
        return boardRepository.findAll(pageable); //MyBatis의 경우에는 Controller > Service > Impl > Dao > Mapper
    }




    public Optional<board> getboardById(Integer idx){ //Optional<

        return boardRepository.findById(idx);
    }
    public board createboard(board board){

        return boardRepository.save(board);
    }

    public void updateboard(int idx,board updateboard){
        board board = boardRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist board Data by no : [" + idx + "]"));
        System.out.println(updateboard.toString());

        board.setTitle(updateboard.getTitle());
        board.setContent(updateboard.getContent());
        board.setCount(board.getCount());
        board.setFilename(board.getFilename());
        board.setWridate(board.getWridate());
        board.setWriter(board.getWriter());

        boardRepository.save(board);
    }

    public void deleteboard(int idx){
        board board = boardRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist board Data by no : [" + idx + "]"));
        boardRepository.delete(board);
    }


}
