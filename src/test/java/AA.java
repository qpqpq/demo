import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AA{
    static class Demo{
        private String id;
        private boolean isNew;
        public boolean isNNN(){
            return isNew;
        }
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(JSONObject.toJSONString(d));
    }
}