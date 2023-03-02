package edu.fit;

import edu.fit.mapper.ExpressItemMapper;
import edu.fit.mapper.UserMapper;
import edu.fit.pojo.ExpressItem;
import edu.fit.pojo.User;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = FrontApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class springTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ExpressItemMapper expressItemMapper;

    @Test
    public void selectSUesr(){
        ExpressItem expressItem = expressItemMapper.selectEIMessage("1672905349783101");
        log.info(expressItem);
    }
}
