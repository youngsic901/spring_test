package pack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.SpringBoard;
import pack.model.SpringBoardRepository;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final SpringBoardRepository springBoardRepository;

    @GetMapping({"/", "/page"})
    public String showBoardList(@RequestParam(defaultValue = "0")int page,
                                @RequestParam(required = false)String searchType,
                                @RequestParam(required = false)String keyword,
                                Model model) {
        int pageSize = 5;

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "num"));
        Page<SpringBoard> boardPage;

        if(keyword != null && !keyword.isBlank()) {
            switch (searchType) {
                case "title" -> boardPage = springBoardRepository.findByTitleContaining(keyword, pageRequest);
                case "author" -> boardPage = springBoardRepository.findByAuthorContaining(keyword, pageRequest);
                case "content" -> boardPage = springBoardRepository.findByContentContaining(keyword, pageRequest);
                default -> boardPage = springBoardRepository.findAll(pageRequest);
            }
        } else {
            boardPage = springBoardRepository.findAll(pageRequest);
        }

        if(searchType != null && !searchType.isBlank()) {
            model.addAttribute("searchType", searchType);
        } else {
            model.addAttribute("searchType", "");
        }

        if(keyword != null && !keyword.isBlank()) {
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("keyword", "");
        }

        model.addAttribute("boardPage", boardPage);
        model.addAttribute("currentPage", page);

        return "list";
    }

    @GetMapping("/board/read/{num}")
    public String readDetail(@PathVariable("num") Integer num,
                             @RequestParam(defaultValue = "0")int page,
                             @RequestParam(required = false)String searchType,
                             @RequestParam(required = false)String keyword,
                             Model model) {
        SpringBoard board = springBoardRepository.findById(num)
                .orElseThrow(() -> new IllegalArgumentException(num + "번 게시글을 찾을 수 없습니다."));

        board.setReadcnt(board.getReadcnt() + 1);
        springBoardRepository.save(board);

        if(searchType != null && !searchType.isBlank()) {
            model.addAttribute("searchType", searchType);
        } else {
            model.addAttribute("searchType", "");
        }

        if(keyword != null && !keyword.isBlank()) {
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("keyword", "");
        }

        model.addAttribute("board", board);
        model.addAttribute("page", page);

        return "read";
    }

    @GetMapping("/board/write")
    public String showWriteForm(){
        return "write";
    }

    @PostMapping("/board/write")
    public String processWrite(@RequestParam("author") String author,
                               @RequestParam("title") String title,
                               @RequestParam("content") String content) {
        SpringBoard board = new SpringBoard();
        board.setAuthor(author);
        board.setTitle(title);
        board.setContent(content);
        board.setBwrite(LocalDateTime.now());
        board.setReadcnt(0);

        springBoardRepository.save(board);
        return "redirect:/";
    }

    @GetMapping("/board/update/{num}")
    public String editForm(@PathVariable("num") Integer num, Model model) {
        SpringBoard board = springBoardRepository.findById(num)
                .orElseThrow(() -> new IllegalArgumentException("해당 글 없음"));
        model.addAttribute("board", board);
        return "update";
    }

    @PostMapping("/board/update/{num}")
    public String editProcess(@PathVariable("num") Integer num,
                              @RequestParam("author") String author,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content) {

        SpringBoard board = springBoardRepository.findById(num)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다: " + num));

        board.setAuthor(author);
        board.setTitle(title);
        board.setContent(content);

        springBoardRepository.save(board); // 수정된 내용 반영

        return "redirect:/board/read/" + num;
    }

    @GetMapping("/board/delete/{num}")
    public String delete(@PathVariable("num") Integer num) {
        springBoardRepository.deleteById(num);
        return "redirect:/";
    }

}
