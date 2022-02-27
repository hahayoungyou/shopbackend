package johayoung.shopbackend.Service;


import johayoung.shopbackend.Exception.ResourceNotFoundException;
import johayoung.shopbackend.Repository.boardRepository;
import johayoung.shopbackend.entity.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class boardService {

    @Autowired
    private boardRepository boardRepository;

    public List<board> getAllboard(){
        return boardRepository.findAll(); //MyBatis의 경우에는 Controller > Service > Impl > Dao > Mapper
    }
    /*public board getboardById(int idx){

        return boardRepository.findById(idx);
    }*/
    public board createboard(board board){

        return boardRepository.save(board);
    }

    public void updateboard(int idx,board updateboard){
        board board = boardRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist board Data by no : [" + idx + "]"));
        updateboard.setTitle(updateboard.getTitle());
        updateboard.setContent(updateboard.getContent());
        boardRepository.save(board);
    }

    public void deleteboard(int idx){
        board board = boardRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist board Data by no : [" + idx + "]"));
        boardRepository.delete(board);
    }


}
