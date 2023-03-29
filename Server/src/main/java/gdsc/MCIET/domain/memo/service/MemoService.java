package gdsc.MCIET.domain.memo.service;

import gdsc.MCIET.domain.memo.domain.Memo;
import gdsc.MCIET.domain.memo.domain.repository.MemoRepository;
import gdsc.MCIET.domain.memo.exception.MemoNotFound;
import gdsc.MCIET.domain.memo.presentaion.dto.request.SaveMemoDto;
import gdsc.MCIET.domain.memo.presentaion.dto.response.ShowMemoDto;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.utils.SecurityUtils;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemoService implements MemoUtils{

    private final MemoRepository memoRepository;
    private final UserUtilsImpl userUtils;

    //메모 저장
    @Transactional
    public Long saveMemo(SaveMemoDto saveMemoDto){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        return memoRepository.save(Memo.builder()
                .user(user)
                .contents(saveMemoDto.getContents())
                .build()
        ).getId();
    }

    //저장된 메모 보여주기
    public List<ShowMemoDto> showAllMemo(){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        List<Memo> memoList = memoRepository.findByUser(user);
        return memoList.stream()
                .map(memo -> new ShowMemoDto(memo))
                .collect(Collectors.toList());
    }

    //메모 삭제
    public void deleteMemo(Long memoId){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        Memo memo = findMemo(memoId);
        memoRepository.delete(memo);
    }

    @Override
    public Memo findMemo(Long memoId) {
        return memoRepository.findById(memoId).orElseThrow(() -> MemoNotFound.EXCEPTION);
    }
}
