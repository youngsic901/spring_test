package pack;

import org.springframework.stereotype.Component;

@Component
public class LogicImpl implements LogicInter {
    public LogicImpl(){

    }

    @Override
    public void startProcess() {
        System.out.println("검증이 되었으므로 핵심 로직 수행");
    }
}
