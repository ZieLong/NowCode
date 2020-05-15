package com.hqu.community;

import com.hqu.community.dao.DiscussPostMapper;
import com.hqu.community.dao.MessageMapper;
import com.hqu.community.dao.UserMapper;
import com.hqu.community.entity.DiscussPost;
import com.hqu.community.entity.Message;
import com.hqu.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(111);
        System.out.println(rows);
    }

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(111);
        System.out.println(user);
    }
    @Test
    public void testMessage() {
        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        List<Message> list = messageMapper.selectLetters("111_112", 0, 10);
        for(Message message : list) {
            System.out.println(message);
        }

        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);

        count = messageMapper.selectLetterUnreadCount(131,"111_131");
        System.out.println(count);
    }

}
