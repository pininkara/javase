// 2022/2/14 14:34

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nnk.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    @Test
    public void test1(){
        List<User> list=new ArrayList<>();
        Gson gson=new Gson();
        list.add(new User(111,"nnk1",16));
        list.add(new User(222,"nnk2",17));
        list.add(new User(333,"nnk3",18));
        list.add(new User(444,"nnk4",19));

        String json = gson.toJson(list);

        System.out.println(json);

        List<User> list1 = gson.fromJson(json, new TypeToken<List<User>>(){}.getType());

        for (User user : list1) {
            System.out.println(user);
        }
    }
}
