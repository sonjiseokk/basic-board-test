package com.board.board.service.user;

import com.board.board.domain.user.User;
import com.board.board.domain.user.UserRepository;
import com.board.board.api.dto.user.UserSaveRequestDto;
import com.board.board.api.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public Long save(UserSaveRequestDto saveRequestDto) {
        User requestDtoEntity = saveRequestDto.toEntity(saveRequestDto);
        return userRepository.save(requestDtoEntity).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto updateRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        UserUpdateParam updateParam = UserUpdateParam.builder()
                .email(updateRequestDto.getEmail())
                .username(updateRequestDto.getUsername())
                .password(updateRequestDto.getPassword())
                .profileImage(updateRequestDto.getProfileImage())
                .build();
        user.update(updateParam);
        return user.getId();
    }
}
