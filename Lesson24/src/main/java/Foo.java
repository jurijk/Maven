
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
    private static final Logger logger2 = LoggerFactory.getLogger("loggerFoo");

    public void doIt() {
        logger2.error("Foo error");//это сообщение будет писаться в файл myFoo.log
        logger2.warn("Foo warn");
        logger2.info("Foo info");
        logger2.debug("Foo debug");
    }
}
