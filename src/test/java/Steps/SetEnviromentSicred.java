package Steps;

import Core.BaseTest;

public class SetEnviromentSicred {
    private String url;
    private String urlBase;
    private String token;
    private String typeAutorization;
    private BaseTest baseTest = new BaseTest();

    public SetEnviromentSicred(){

        System.out.println(System.getProperty("test.ambiente"));
        switch(System.getProperty("test.ambiente")){
            case "sicred":
                urlBase = this.baseTest.getSetupProperty("base.url");
                break;
        }
    }

    public String baseUrl(){
        this.url = new StringBuilder()
                .append(urlBase)
                .toString();
        return this.url;
    }

}
