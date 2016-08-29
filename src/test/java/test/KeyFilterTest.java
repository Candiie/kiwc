package test;

import CS3213.KeyFilter;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class KeyFilterTest {

    @Test
    public void testKeyFilter() throws Exception {

        KeyFilter kf = new KeyFilter();
        
        List reqWords = new ArrayList<String>();
        
        reqWords.add("Star");
        reqWords.add("Space");
        
         List oriList = new ArrayList<String>();
        
        oriList.add("Star asdasd");
        oriList.add("Space asdasdasd");
        oriList.add("asdasdStar asdasd");
        oriList.add("asdasdgSpace asdasdasd");
        
        kf.setRequiredWords(reqWords);
        kf.setKwickOriList(oriList);
        
        List filterList = kf.filterList();
        
        
        List outPut = new ArrayList<String>();
        
        outPut.add("Star asdasd");
        outPut.add("Space asdasdasd");
        
        assertEquals(outPut.get(0),filterList.get(0));
  
    }
}
