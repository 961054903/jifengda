package jpush;

import java.util.HashMap;
import java.util.Map;

import com.caogen.jfd.jpush.JPush;

public class demo {
    public static void main(String[] args) {
        //设置推送参数
        //这里同学们就可以自定义推送参数了
        Map<String, String> parm = new HashMap<String, String>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        parm.put("id", "160a3797c8760e8ae76");
        //设置提示信息,内容是文章标题
        parm.put("msg", "测试测试,");
        JPush.jpushAll(parm);
    }

}
