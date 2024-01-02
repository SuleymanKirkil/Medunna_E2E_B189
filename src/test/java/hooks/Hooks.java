package hooks;

import io.cucumber.java.Before;

import static baseurl.MedunnaBaseUrl.setUp;

public class Hooks {

    @Before("@api")
    public void before_api(){
        setUp();
    }

}
