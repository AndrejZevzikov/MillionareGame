package dataPreparation;

import QA.Question;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListsConnector {

    public static List<Question> generateFullList(List<Question>...questions){
       return Arrays.stream(questions).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
