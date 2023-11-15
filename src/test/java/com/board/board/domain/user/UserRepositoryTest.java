package com.board.board.domain.user;

import com.board.board.domain.image.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@DataJpaTest
@Transactional(readOnly = true)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    @DisplayName("유저 저장")
    @Transactional
    void 유저_저장() throws Exception {
        //given
        Image mockImage = mock(Image.class);
        User user = User.builder()
                .email("aaa@bbb.com")
                .username("test")
                .password("test2")
                .profileImage(mockImage)
                .build();
        //when
        /**
         * user 저장 반영을 위해 flush
         */
        User savedUser = userRepository.save(user);
        entityManager.flush();

        /**
         * testEntityManager를 통해 데이터베이스에서 가져오는 것 처럼 모방
         */
        User retrievedUser = entityManager.find(User.class, savedUser.getId());
        //then
        assertThat(retrievedUser).isNotNull();
    }
}