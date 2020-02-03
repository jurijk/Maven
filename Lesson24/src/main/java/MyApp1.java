
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyApp1 {
    private static final Logger logger = LoggerFactory.getLogger("name.logger");//по имени логгера можно индивидуально
    private static final Logger logger1 = LoggerFactory.getLogger("name.logger1");// настроить то, куда он будет сбрасывать информацию

    public static void main(String[] args) {

        Foo foo = new Foo();
        foo.doIt();
        logger.error("MyApp logger error.");//это сообщение будет выводится в консоль
        logger.warn("MyApp logger warn.");//это сообщение будет выводится в консоль
        logger1.info("MyApp  logger1 info.");//это сообщение будет писаться в файл myApp.log
        logger1.debug("MyApp  logger1 debug.");
    }
}
