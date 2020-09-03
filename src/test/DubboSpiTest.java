import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
@WebAppConfiguration
public class DubboSpiTest {

    @Test
    public void test(){
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        GoodsOrder aliPay = loader.getExtension("aliPay");
        aliPay.getPayWay();

        GoodsOrder wechatPay = loader.getExtension("wechatPay");
        wechatPay.getPayWay();
    }
}
