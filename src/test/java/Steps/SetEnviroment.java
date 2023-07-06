package Steps;

import Core.BaseTest;

public class SetEnviroment {
    private String url;
    private String urlBase;
    private BaseTest baseTest = new BaseTest();

    public SetEnviroment(){

        System.out.println(System.getProperty("test.ambiente"));
        switch(System.getProperty("test.ambiente")){
            case "getNet":
                urlBase = this.baseTest.getSetupProperty("base.url");
                break;
        }
    }

    public String baseUrl(){
        this.url = new StringBuilder()
                .append(urlBase)
                .toString();
        System.out.println(url);
        return this.url;

    }

}
